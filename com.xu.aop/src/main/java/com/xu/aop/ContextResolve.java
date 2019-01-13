/**
 * sendinfo.com Inc.
 * Copyright (c) All Rights Reserved.
 */
package com.xu.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author xurw
 * �Զ���ע��
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ContextResolve {
    
    /** context������ */
    String context() default "-1";
    
    /** ��չ���������ŷָ� */
    String extendParam() default "";

}
