define(['angular', 'angular-ui-router', 'ng-file-upload', "controllers/dashboard", 'controllers/create-question',
    'directives/create-question', 'directives/dashboard'], function(angular) {
    var questionModule = angular.module("createQuestionModule", ['ui.router', 'ngFileUpload', 'controller',
        'directive', 'service'], angular.noop);
    questionModule.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/choice");
        $stateProvider.state("subjective", {
            url : "/subjective",
            templateUrl : BASE_URL + "/static/html/question/subjective.html"
        }).state("choice", {
            url : "/choice",
            templateUrl : BASE_URL + "/static/html/question/choice.html"
        }).state("complete", {
            url : "/complete",
            templateUrl : BASE_URL + "/static/html/question/show-test.html"
        }).state("r", {
            url : "/r",
            templateUrl : BASE_URL + "/static/html/question/show-test.html"
        }).state("d", {
            url : "/d",
            templateUrl : BASE_URL + "/static/html/question/show-test.html"
        }).state("tf", {
            url : "/tf",
            templateUrl : BASE_URL + "/static/html/question/show-test.html"
        });
    }]);
    questionModule.run(function($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    });
    return questionModule;
});