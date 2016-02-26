define(['modules/service'], function(service) {
    service.factory('questionService', ['$http', function($http) {
        return {
            getTag : function(param) {
                return $http({
                    url : BASE_URL + "/page/tag/search/" + param,
                    method : "GET"
                });
            },
            submitForm : function(formData) {
                return $http.post(BASE_URL + '/page/question', formData);
            }
        };
    }]);
});