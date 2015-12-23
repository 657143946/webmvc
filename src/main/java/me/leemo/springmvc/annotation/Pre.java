package me.leemo.springmvc.annotation;


import me.leemo.springmvc.interceptor.InterceptorInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Leemo on 15-12-23.
 * 前向拦截器
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pre {
    Class<? extends InterceptorInterface>[] on() default {};

    Class<? extends InterceptorInterface>[] off() default {};
}
