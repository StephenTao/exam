<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib uri="/WEB-INF/aug.tld" prefix="aug"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String STATIC_URL = (String) request.getAttribute("staticURL");
    String LOCALE = (String) session.getAttribute("locale");
    String VERSION = (String) session.getAttribute("version");
    String RESOURCE_URL = (String) session.getAttribute("resourceURL");
%>
<fmt:setLocale value="<%=LOCALE%>" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><aug:pageTitle /></title>
<script type="text/javascript">
    var STATIC_URL = '<%=STATIC_URL%>';
    var VERSION = '<%=VERSION%>';
    var LOCALE = '<%=LOCALE%>';
    var RESOURCE_URL = '<%=RESOURCE_URL%>';
</script>
<aug:block name="staticResources" />
</head>
<body id="body" class="bg-color">
    <header>
        <jsp:include page="../nav.jsp"></jsp:include>
    </header>
    <div id="topContainerId" ng-controller="createQuestionCtrl" class="common container">
        <div id="tag" class="top box-style">
            <div>
                <label class="first"><fmt:message key="home" />><fmt:message key="questionManager" />><fmt:message key="createQuestion" />></label>
                <label id="target" class="font-style03">
                    {{question.routeTag}}
                </label>
            </div>
        </div>
        <div class="question-container baseBlockIn">
            <div id="editQuestionId" class="left box-style">
                <div class="question-tool">
                    <jsp:include page="blocks/upload-menu.jsp"></jsp:include>
                </div>
                <div question-menu id="questionMenu" class="question-menu">
                    <jsp:include page="blocks/question-menu.jsp"></jsp:include>
                </div>
                <div class="question-content font-style01 box-style">
                    <div class="flow-style">
                        <div class="question-tag">
                            <div id="tagMessage" class="statictext" ng-class="{'model-left':true,'tag':true,'color-style03':validator.tag}"><fmt:message key="tag" />*</div>
                            <div class="model-right tagValue">
                                <div ng-repeat="tag in question.formData.tags" ng-show="tag.visible"
                                    class="tag-id show-tag-style block-style">
                                    <label>{{tag.name}}</label>
                                    <img class="hand" alt="delete tag" ng-click="deleteTag($index)" ng-src={{question.minDel}} />
                                </div>
                                <div>
                                    <input id="tagId" ng-blur="blur()" ng-keyup="change()" ng-focus="focus()"
                                        ng-model="question.formData.tagValue" class="{{question.isHasBorder}}"
                                        placeholder="<fmt:message key="question.message" />" />
                                    <ul class="ul-css abs">
                                        <a href="javascript:void();" class="box-style"
                                            ng-repeat="tag in question.searchTagList" ng-mousedown="selectedValue(tag)">
                                            <li>{{tag.name}}</li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="question-title">
                            <div id="titleMessage" class="statictext" ng-class="{'model-left':true,'question':true,'color-style03':validator.title}"><fmt:message key="question.title" />*</div>
                            <div area id="title" ng-bind="question.formData.title" ng-model="question.formData.title" class="question  model-right rich box-styl" data-placeholder="<fmt:message key="question.message" />"
                                contenteditable="true"></div>
                        </div>
                        <div class="flow-style" ui-view></div>
                    </div>
                </div>
                <div class="question-button">
                    <div>
                        <button  button id="create" ng-click="create()" class="element-style03 a-apacity hand">
                            <fmt:message key="submit" />
                        </button>
                        <button button id="createAgain" ng-click="createAgain()" class="element-style03 a-apacity hand">
                            <fmt:message key="submitAndCreate" />
                        </button>
                        <button button ng-click="cancel()" class="element-style02 a-apacity">
                            <fmt:message key="cancel" />
                        </button>
                    </div>
                </div>
            </div>
            <div id="showQuestionId" class="right box-style">
                <div class="right-container box-style">
                    <jsp:include page="blocks/question-view.jsp" />
                </div>
            </div>
        </div>
        <div ng-show="message.length>0" class="message">
            <center>
                <label ng-class="{'color-style03':visibleMsg}">{{message}}</label>
            </center>
        </div>
    </div>
</body>
</html>