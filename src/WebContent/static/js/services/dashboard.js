define(['modules/service'], function(service) {
    service.factory("dashboardService", ['$http', 'Upload', function($http, Upload) {
        return {
            upload : function(file, url) {
                return Upload.upload({
                    url : url,
                    method : "POST",
                    data : {
                        file : file
                    }
                });
            }
        };
    }]);
});