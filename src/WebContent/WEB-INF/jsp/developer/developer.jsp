<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib uri="/WEB-INF/aug.tld" prefix="aug"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String BASE_URL = request.getContextPath();
    String STATIC_URL = (String) request.getAttribute("staticURL");
    String LOCALE = (String) session.getAttribute("locale");
    String VERSION = (String) session.getAttribute("version");
%>
<fmt:setLocale value="<%=LOCALE%>" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><aug:pageTitle /></title>
<script type="text/javascript">
    var BASE_URL = '<%=BASE_URL%>';
    var STATIC_URL = '<%=STATIC_URL%>';
    var VERSION = '<%=VERSION%>';
    var LOCALE = '<%=LOCALE%>';
</script>
<aug:block name="staticResources" />
</head>
<body>
    <h1>JUST ONE TEST DEVELOPER !</h1>
</body>
</html>