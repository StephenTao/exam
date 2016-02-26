<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/aug.tld" prefix="aug"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String BASE_URL = request.getContextPath();
    String STATIC_URL = (String) request.getAttribute("staticURL");
    String VERSION = (String) session.getAttribute("version");
    String FROM_URL = request.getParameter("fromUrl");
    String LOCALE = (String) session.getAttribute("locale");
    String RESOURCE_URL = (String) session.getAttribute("resourceURL");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><aug:pageTitle /></title>
<link rel="icon" href="<%=STATIC_URL%>static/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="<%=STATIC_URL%>static/images/favicon.ico" type="image/x-icon" />
<link rel="bookmark" href="<%=STATIC_URL%>static/images/favicon.ico" type="image/x-icon" />
<script type="text/javascript">
    var BASE_URL = '<%=BASE_URL%>';
    var STATIC_URL = '<%=STATIC_URL%>';
    var VERSION = '<%=VERSION%>';
    var LOCALE = '<%=LOCALE%>';
    var RESOURCE_URL = '<%=RESOURCE_URL%>';
</script>
<aug:block name="staticResources" />
</head>
<body>
    <header>
        <div class="inner-wrap clearFix" ng-controller="languageController">
            <span class="main-logo-login fl"></span>
            <label class="language fr" id="language" ng-click="changeLanguage('<fmt:message key="locale" />')"><fmt:message key="language" /></label>
        </div>
    </header>
    <div class="wrapper">
        <form class="login-main" id="login-main" action="<%=BASE_URL%>/page/user/login" method="POST">
            <div class="title">Online Exam System</div>
            <div class="line">
                <p>
                    <fmt:message key="username-tip" />
                </p>
                <input id="username" type="text" name="userName" />
            </div>
            <div class="line">
                <p>
                    <fmt:message key="password-tip" />
                </p>
                <input id="password" type="password" name="password" />
            </div>
            <span class="error-message">${errorMessage}</span>
            <input type="hidden" name="fromUrl" value="<%=FROM_URL%>" />
            <div>
                <input class="login-btn fl" id="login-button" type="submit" value="<fmt:message key="login" />" />
                <a class="login-btn reset fr" id="reset" href="<%=BASE_URL%>/page/user/login">
                    <fmt:message key="reset" />
                </a>
            </div>
        </form>
    </div>
    <footer>
        <p>Copyright © 2015 Augmentum, Inc. All Rights Reserved</p>
    </footer>
</body>
</html>
