package com.augmentum.exam.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.augmentum.common.AppConstants;
import com.augmentum.common.util.AppUtil;
import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;
import com.augmentum.exam.dto.UserDTO;

public class SessionFilter implements Filter {

    public SessionFilter() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // Set encoding method
        try {
            request.setCharacterEncoding(AppConstants.UTF_ENCODE);
        } catch (UnsupportedEncodingException e1) {
            throw new RuntimeException(e1);
        }
        response.setCharacterEncoding(AppConstants.UTF_ENCODE);

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO)session.getAttribute(AppConstants.USER);
        EContext appContext = EContext.getContext();
        if (user != null) {
            appContext.addObject(AppConstants.USER, user);
        }
        String locale = request.getParameter(AppConstants.LOCALE);
        if (locale != null) {
            session.setAttribute(AppConstants.LOCALE, locale);
            appContext.addObject(AppConstants.LOCALE, locale);
        }
        System.out.println(appContext.getLocale());
        session.setAttribute(AppConstants.VERSION, AppUtil.getPropertyValue(AppConstants.VERSION));
        // put staticURL into request for being called in JSP
        request.setAttribute(AppConstants.STATIC_URL, AppUtil.getPropertyValue(AppConstants.STATIC_URL));
        String uri =  request.getRequestURI();
        String requestedUri = uri.substring(request.getContextPath().length() + 1);
        appContext.addObject(AppConstants.REQUESTED_URI, requestedUri);
        session.setAttribute(Constants.RESOURCE_URL, AppUtil.getPropertyValue(Constants.RESOURCE_URL));
        try {
            chain.doFilter(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } finally {
            appContext.clear();
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
