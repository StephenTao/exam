define(['angular', 'angular-ui-router', 'controllers/tag-list', 'services/tag', 'directives/tag-list',
    "controllers/dashboard", 'services/dashboard', 'directives/dashboard', 'ng-file-upload'], function(angular) {
    var dashboardModule = angular.module("tagListModule", ['ui.router', 'controller', 'directive', 'service',
        'ngFileUpload'], angular.noop);
    dashboardModule.run(function($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
        $rootScope.$on("$viewContentLoaded", function() {
            if ($("span.ng-scope").text() == "NotLogin") {
                var hashValue = location.hash.split("#")[1];
                if (hashValue != null || hashValue != "") {
                    var exdate = new Date();
                    exdate.setTime(exdate.getTime() + 30 * 60 * 1000);
                    document.cookie = "examRoute=" + escape(hashValue) + ";Path=" + baseUrl + ";expires="
                        + exdate.toGMTString();
                }
            }
        });
    });

    return dashboardModule;
});