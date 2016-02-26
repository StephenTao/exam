<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${cssFiles}" var="cssFile">
    <link type="text/css" rel="stylesheet" href="${staticURL}${cssFile}" />
</c:forEach>
<c:forEach items="${jsFiles}" var="jsFile">
    <c:out value="<script " escapeXml="false" />
    <c:forEach items="${jsFile}" var="entry">
        ${entry.key} = "${staticURL}${entry.value}" 
    </c:forEach>
    <c:out value="></script>" escapeXml="false" />
</c:forEach>
