package com.augmentum.exam.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;
import com.augmentum.exam.service.ACLService;

public class PrivilegeInterceptor extends HandlerInterceptorAdapter {

    private static final String NOT_ACCESS = "you have not permission to access!";

    @Resource
    private ACLService aclService;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) {
        response.addHeader("X-XSS-Protection", "0");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException, ServletException {
        HandlerMethod maControl = (HandlerMethod) handler;
        String className = maControl.getBeanType().getSimpleName();
        Method pmrResolver = maControl.getMethod();
        String methodName = pmrResolver.getName();
        String requestMethod = request.getMethod().toLowerCase();

        StringBuilder builder = new StringBuilder();
        builder.append(className);
        builder.append(Constants.SPLIT_STRIKE);
        builder.append(methodName);
        builder.append(Constants.SPLIT_STRIKE);
        builder.append(requestMethod);
        String privilegeKey = builder.toString();

        int userId = EContext.getContext().getUserId();
        boolean result = aclService.isAllow(userId, privilegeKey);
        if (!result) {
            response.getWriter().print(NOT_ACCESS);
        }
        return result;
    }
}
