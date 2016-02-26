<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div  class="first font-style05">
    <div ng-model="file" ngf-select="upload($file, $invalidFiles)" ngf-pattern="'.mp3,.wav'" ngf-accept="'.mp3,.wav'" ngf-max-size="10MB">
        <a href="javascript:void();" class="upload-audio upload-common"></a>
        <a href="javascript:void();" class="color-style04 hover-color"><fmt:message key="question.audio" /></a>
    </div>
    <div ng-model="file" ngf-select="upload($file, $invalidFiles)" ngf-pattern="'.avi,.flv,.mov,.3gp,.mp4'" ngf-accept="'.avi,.flv,.mov,.3gp,.mp4'" ngf-max-size="100MB">
        <a href="javascript:void();" class="upload-video upload-common"></a>
        <a href="javascript:void();" class="color-style04 hover-color"><fmt:message key="question.video" /></a>
    </div>
    <div ng-model="file" ngf-select="upload($file, $invalidFiles)" ngf-pattern="'.jpeg,.gif,.png,.jpg'" ngf-accept="'.jpeg,.gif,.png,.jpg'" ngf-max-size="1MB">
        <a href="javascript:void();" class="upload-img upload-common"></a>
        <a href="javascript:void();" class="color-style04 hover-color"><fmt:message key="question.image" /></a>
    </div>
    <div ng-model="file" ngf-select="upload($file, $invalidFiles)" ngf-max-size="1000MB">
        <a href="javascript:void();" class="upload-attachment upload-common"></a>
        <a href="javascript:void();" class="color-style04 hover-color"><fmt:message key="question.attachment" /></a>
    </div>
</div>
<div class="second font-style02">
    <div>
        <span full-screen="edit" class="hand">
            <a href="javascript:void()" class="normal">
                <img alt="full screen" ng-src="{{max}}">
            </a>
            <a href="javascript:void();" class="hover-color color-style04"><fmt:message key="fullScreen" /></a>
        </span>
        <span reduce-screen="edit" class="hand hidden">
            <a href="javascript:void()" class="normal">
                <img alt="reduce screen" ng-src="{{max}}">
            </a>
            <a href="javascript:void();" class="hover-color color-style04"><fmt:message key="exitScreen" /></a>
        </span>
    </div>
</div>
