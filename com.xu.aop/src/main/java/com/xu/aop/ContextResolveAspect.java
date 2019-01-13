/**
 * sendinfo.com Inc.
 * Copyright (c) All Rights Reserved.
 */
package com.xu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * desc��ͬ����¼����
 * 
 * @author xurw
 */
@Aspect
@Component
@Order(2)
public class ContextResolveAspect {
    
    /** ��־ */
    private static final Logger logger = LoggerFactory.getLogger(ContextResolveAspect.class);
    
    /**
     * desc:�����
     */
    @Pointcut(value = "@annotation(com.sendinfo.ordermg.basequery.facade.aop.ContextResolve)")
    private void pointcut() {

    }
    
    /**
     * desc:�ڷ���ִ��ǰ��
     *
     * @param point
     * @param myLog
     * @return
     * @throws Throwable
     */
    @Around(value = "pointcut() && @annotation(contextResolve)")
    public Object around(ProceedingJoinPoint point, ContextResolve contextResolve) throws Throwable {
        System.out.println("contextResolveע������----��ʼ");
        try {
        	//���������Ĳ���ֵ��ThreadLocal ��ȡ ������
        	String  context = resolveContext(point.getArgs(), contextResolve.context());
        	System.out.println("�������� ="+context);
            return point.proceed();
        } catch (Exception e){
        	System.out.println("��������ʧ��,"+e.getMessage());
        }  finally {
            //����������
        	System.out.println("contextResolveע������----����");
        }
		return null;
    }
    
    /**
     * desc: ����id
     * 
     * @param args ��������
     * @param contextIndex ����
     * @return
     */
    protected String resolveContext(Object[] invokeParams, String contextIndex) {
        int routeIndex = Integer.parseInt(contextIndex);
        if (routeIndex == -1) {
        	routeIndex = invokeParams.length - 1;
        }
        return (String)invokeParams[routeIndex];
    }

}
