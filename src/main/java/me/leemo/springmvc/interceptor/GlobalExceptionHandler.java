package me.leemo.springmvc.interceptor;

import me.leemo.springmvc.controller.ControllerModel;
import me.leemo.springmvc.utils.ResponseUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Leemo on 15-12-22.
 * 全局出错处理
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private static final ModelAndView NONE = new ModelAndView();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // TODO 记录日志
        ex.printStackTrace();
        if (request.getServletPath().endsWith(".json")) {
            /**
             * 返回数据
             */
            ControllerModel data = new ControllerModel(ControllerModel.StandardCodeMsg.INNER_BUG, ex.getMessage());
            ResponseUtils.jsonReturn(response, data);
        } else if (request.getServletPath().endsWith(".page")) {
            /**
             * 重定向到错误页面
             */
            ResponseUtils.redirectPage(response, request.getContextPath() + "/html/404.html");
        }
        return NONE;
    }
}
