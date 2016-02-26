<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="show-top show-max font-style02 ">
    <div>
        <span full-screen="show" class="hand">
            <a href="javascript:void()" class="normal">
                <img alt="full screen" ng-src="{{showMax}}">
            </a>
            <a href="javascript:void();" class="hover-color color-style04"><fmt:message key="fullScreen" /></a>
        </span>
        <span reduce-screen="show" class="hand hidden">
            <a href="javascript:void();" class="normal">
                <img alt="reduce screen" ng-src="{{showMax}}">
            </a>
            <a href="javascript:void();" class="hover-color color-style04"><fmt:message key="exitScreen" /></a>
        </span>
    </div>
</div>
<div class="question-content font-style01">
    <div class="content-view">
        <div class="question-tag">
            <div class="tag model-left"><fmt:message key="tag" /></div>
            <div class="model-right">
                <div ng-repeat="tag in question.formData.tags" ng-show="tag.visible"
                    class="show-tag-style tagValue block-style">
                    <label>{{tag.name}}</label>
                </div>
            </div>
        </div>
        <div class="question-title font-style07">
            <div id="titleView" class="font-style01 question word-break"></div>
        </div>
        <div ng-include="question.refView"></div>
    </div>
</div>
