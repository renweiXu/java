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
 * desc：同步记录切面
 * 
 * @author xurw
 */
@Aspect
@Component
@Order(2)
public class ContextResolveAspect {
    
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ContextResolveAspect.class);
    
    /**
     * desc:切入点
     */
    @Pointcut(value = "@annotation(com.sendinfo.ordermg.basequery.facade.aop.ContextResolve)")
    private void pointcut() {

    }
    
    /**
     * desc:在方法执行前后
     *
     * @param point
     * @param myLog
     * @return
     * @throws Throwable
     */
    @Around(value = "pointcut() && @annotation(contextResolve)")
    public Object around(ProceedingJoinPoint point, ContextResolve contextResolve) throws Throwable {
        System.out.println("contextResolve注解拦截----开始");
        try {
        	//解析上下文并赋值到ThreadLocal 获取 最后入参
        	String  context = resolveContext(point.getArgs(), contextResolve.context());
        	System.out.println("解析参数 ="+context);
            return point.proceed();
        } catch (Exception e){
        	System.out.println("解析参数失败,"+e.getMessage());
        }  finally {
            //清理上下文
        	System.out.println("contextResolve注解拦截----结束");
        }
		return null;
    }
    
    /**
     * desc: 解析id
     * 
     * @param args 参数集合
     * @param contextIndex 索引
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
