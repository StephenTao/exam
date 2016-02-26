define(['angular', 'angular-ui-router', "controllers/dashboard", 'services/dashboard', 'directives/dashboard',
    'controllers/myexam', 'services/exam', 'directives/myexam', 'ng-file-upload'], function(angular) {
    var dashboardModule = angular.module("myExamModule", ['ui.router', 'controller', 'directive', 'service',
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