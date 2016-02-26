<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String BASE_URL = request.getContextPath();
%>
<script type="text/javascript">
    var BASE_URL = '<%=BASE_URL%>';
</script>
<div ng-controller="dashboardCtrl" class="inner-wrap">
    <div class="static-left">
        <div class="left">
            <div>
                <img alt="augmentum" ng-src={{augmentum}} />
            </div>
            <span class="font-style09">
                <label>Online Exam System</label>
            </span>
        </div>
        <div class="center font-style10">
            <div question-nav id="question" class="menu">
                <a href="javascript:void();"><fmt:message key="question" /></a>
                <ul class="menu-children hidden">
                    <li>
                        <a ng-href="{{questionList}}"><fmt:message key="questionList" /></a>
                    </li>
                    <li>
                        <a ng-href="{{myQuestion}}"><fmt:message key="myQuestion" /></a>
                    </li>
                    <li>
                        <a ng-href="{{createQuestion}}"><fmt:message key="createQuestion" /></a>
                    </li>
                </ul>
            </div>
            <div question-nav id="exam" class="menu">
                <a href="javascript:void();"><fmt:message key="exam" /></a>
                <ul class="menu-children hidden">
                    <li>
                        <a ng-href="{{examList}}"><fmt:message key="examList" /></a>
                    </li>
                    <li>
                        <a ng-href="{{myExam}}"><fmt:message key="myExam" /></a>
                    </li>
                    <li>
                        <a ng-href="{{createExam}}"><fmt:message key="createExam" /></a>
                    </li>
                </ul>
            </div>
            <div question-nav id="tag" class="menu">
                <a href="javascript:void();"><fmt:message key="tag" /></a>
                <ul class="menu-children hidden">
                    <li>
                        <a ng-href="{{tagList}}"><fmt:message key="tagList" /></a>
                    </li>
                    <li>
                        <a ng-href="{{createTag}}"><fmt:message key="createTag" /></a>
                    </li>
                </ul>
            </div>
            <div question-nav id="developer" class="menu">
                <a href="javascript:void();"><fmt:message key="developer" /></a>
                <ul class="menu-children hidden">
                    <li>
                        <a ng-href="javascript:void();"><fmt:message key="undefined" /></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="right font-style11">
        <a href="javascript:void();" class="upload normal" title="upload resource">
            <img alt="upload" ng-click="show('file')" ng-src={{uploadQuestion}} />
        </a>
        <a class="normal">
            <img ng-src={{header}} />
            <label style="color: #CDELD8">
                <c:out value="${user.name}"></c:out>
            </label>
        </a>
        <a class="language a-apacity" href="javascript:void();" id="language"  ng-click="changeLanguage('<fmt:message key="locale" />')"><fmt:message key="yz"></fmt:message></a>
        <a class="logout normal" href="<%=BASE_URL%>/page/user/logout" id="logout">
            <img alt="exit" ng-src="{{exit}}" />
        </a>
    </div>
</div>
