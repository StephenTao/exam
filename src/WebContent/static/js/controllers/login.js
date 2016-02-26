define(['modules/controller', 'services/system'], function(controller) {
    controller.controller('languageController', ['$scope', 'systemService', function($scope, systemService) {
        $scope.changeLanguage = function(language) {
            systemService.changeLanguage(language);
            location.reload(true);
        };
    }]);
});