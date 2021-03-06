package me.leemo.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Leemo on 15-12-23.
 * 拦截器接口
 */
public interface InterceptorInterface {
    public boolean intercept(HttpServletRequest request, HttpServletResponse response, Method method);
}
