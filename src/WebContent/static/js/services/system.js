define(['modules/service'], function(service) {
    service.factory("systemService", ['$http', function($http) {
        return {
            changeLanguage : function(language) {
                return $http({
                    url : BASE_URL + "/i18n/switch",
                    method : "GET",
                    params : {
                        locale : language
                    }
                });
            }
        };
    }]);
});