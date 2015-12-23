package me.leemo.springmvc.annotation;

import java.lang.reflect.Method;

/**
 * Created by Leemo on 15-12-23.
 * 注解帮助类
 */
public class AnnotationFinder {
    public static Object[] findClassAndMethodAnnotation(Method method, Class annotationClass) {
        Object methodAnnotation = method.getAnnotation(annotationClass);
        Object classAnnotation = method.getDeclaringClass().getAnnotation(annotationClass);
        return new Object[]{classAnnotation, methodAnnotation};
    }
}
