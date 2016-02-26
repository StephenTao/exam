define(['modules/controller', 'jQuery', 'services/system', 'services/dashboard'], function(controller, $) {
    controller.controller('dashboardCtrl', ['$scope', 'dashboardService', 'systemService',
        function($scope, dashboardService, systemService) {
            $scope.augmentum = STATIC_URL + 'static/images/augmentum.png';
            $scope.uploadQuestion = STATIC_URL + 'static/images/upload_question.png';
            $scope.header = STATIC_URL + 'static/images/header.png';
            $scope.exit = STATIC_URL + 'static/images/exit.png';
            $scope.nav = STATIC_URL + 'static/html/nav.html';
            $scope.createQuestion = BASE_URL + '/page/question/create-question';
            $scope.createExam = BASE_URL + '/page/exam/create-exam';
            $scope.createTag = BASE_URL + '/page/tag/create-tag';
            $scope.questionList = BASE_URL + '/page/question/question-list';
            $scope.examList = BASE_URL + '/page/exam/exam-list';
            $scope.myQuestion = BASE_URL + '/page/question/myquestion';
            $scope.myExam = BASE_URL + '/page/exam/myexam';
            $scope.tagList = BASE_URL + '/page/tag/tag-list';
            $scope.changeLanguage = function(language) {
                systemService.changeLanguage(language);
                location.reload(true);
            };
        }]);
});