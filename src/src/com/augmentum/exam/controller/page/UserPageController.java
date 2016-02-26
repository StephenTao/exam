package com.augmentum.exam.controller.page;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.augmentum.common.AppConstants;
import com.augmentum.common.util.AppUtil;
import com.augmentum.common.util.SpringUtil;
import com.augmentum.common.util.StringUtil;
import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;
import com.augmentum.exam.base.BasePageController;
import com.augmentum.exam.dto.UserDTO;
import com.augmentum.exam.service.UserService;

@Controller
@RequestMapping("/page/user")
public class UserPageController extends BasePageController {

    private static final String JSP_USER_LOGIN = "user/user-login";

    private static final String URL_USER_DASHBORAD = "/page/user/dashboard";

    private static final String KEY_LOGIN_ERROR_MESSAGE = "errorMessage";
    private static final String DASH_BOARD = "dashboard";
    private static final String USER_LOGIN = "userLogin";
    private static final String EXAM_ROUTE = "examRoute";

    @Resource
    private UserService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request) {
        ModelAndView mav = getNotLoginModelAndView(request);
        if (mav != null) {
            return mav;
        }
        EContext.getContext().addObject(Constants.PAGE_TITLE, Constants.TITLE_DASHBOARD);
        ModelAndView modelAndView = new ModelAndView(JSP_MAIN_LAYOUT);
        modelAndView.addObject(KEY_MAIN_BLOCK, DASH_BOARD);
        modelAndView.addObject(AppConstants.USER, getUser());
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, String fromUrl) {
        ModelAndView modelAndView = new ModelAndView(JSP_USER_LOGIN);
        if (Boolean.parseBoolean(AppUtil.getPropertyValue(Constants.CAS_LOGIN_OPEN))) {
            String errorMsg = SpringUtil.getMessage(Constants.KEY_ERROR_CAS_LOGIN_OPEN);
            modelAndView.addObject(KEY_LOGIN_ERROR_MESSAGE, errorMsg);
            return modelAndView;
        }
        UserDTO user = EContext.getContext().getUser();
        if (user != null) {
            modelAndView.setViewName(JSP_MAIN_LAYOUT);
            String url = null;
            if (!StringUtil.isEmpty(fromUrl)) {
                url = fromUrl;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (EXAM_ROUTE.equals(cookie.getName())) {
                            url += "#" + cookie.getValue();
                            break;
                        }
                    }
                }
            }
            if (url == null) {
                url = request.getContextPath() + URL_USER_DASHBORAD;
            }
            modelAndView.setView(new RedirectView(url));
            return modelAndView;
        }
        EContext.getContext().addObject(Constants.PAGE_TITLE, Constants.TITLE_USER_LOGIN);
        modelAndView.addObject(KEY_MAIN_BLOCK, USER_LOGIN);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String userName, String password, String fromUrl, HttpServletRequest request) {
        EContext.getContext().addObject(Constants.PAGE_TITLE, Constants.TITLE_USER_LOGIN);
        ModelAndView modelAndView = new ModelAndView(JSP_USER_LOGIN);
        UserDTO user = userService.getUserByName(userName);
        if (user == null || user.isDeleted()) {
            modelAndView.addObject(KEY_MAIN_BLOCK, USER_LOGIN);
            String errorMsg = SpringUtil.getMessage(AppConstants.KEY_ERROR_MSG_USER_NAME_ERROR);
            modelAndView.addObject(KEY_LOGIN_ERROR_MESSAGE, errorMsg);
        } else if (!user.getPassword().equals(StringUtil.MD5(password))) {
            modelAndView.addObject(KEY_MAIN_BLOCK, USER_LOGIN);
            String errorMsg = SpringUtil.getMessage(AppConstants.KEY_ERROR_MSG_PASSWORD_ERROR);
            modelAndView.addObject(KEY_LOGIN_ERROR_MESSAGE, errorMsg);
        } else {
            HttpSession session = request.getSession();
            user.setPassword(null);
            session.setAttribute(AppConstants.USER, user);
            String url = null;
            if (!StringUtil.isEmpty(fromUrl)) {
                url = fromUrl;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (EXAM_ROUTE.equals(cookie.getName())) {
                            url += "#" + cookie.getValue();
                            break;
                        }
                    }
                }
            }
            if (url == null) {
                url = request.getContextPath() + URL_USER_DASHBORAD;
            }
            modelAndView.setView(new RedirectView(url));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(String fromUrl, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute(AppConstants.USER);
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        if (fromUrl == null || AppConstants.EMPTY.equals(fromUrl)) {
            fromUrl = request.getRequestURL().substring(0, request.getRequestURL().indexOf("/page"));
        }
        String redirectUrl = request.getContextPath() + URL_USER_LOGIN;
        if (Boolean.parseBoolean(AppUtil.getPropertyValue(Constants.CAS_LOGIN_OPEN))) {
            String logout = AppUtil.getPropertyValue(Constants.CAS_LOGOUT_URL);
            redirectUrl = logout + fromUrl;
        }
        modelAndView.setView(new RedirectView(redirectUrl));
        return modelAndView;
    }
}
