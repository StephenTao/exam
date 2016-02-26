require.config({
    baseUrl : STATIC_URL + "static/js",
    urlArgs : "v=" + VERSION || "",
    paths : {
        'jQuery' : 'lib/jquery-2.1.4.min',
        'angular' : 'lib/angular.min',
        'angular-ui-router' : 'lib/angular-ui-router.min',
        'angular-resource' : 'lib/angular-resource.min',
        'ng-file-upload-shim' : 'lib/ng-file-upload-shim.min',
        'ng-file-upload' : 'lib/ng-file-upload.min',
    },
    shim : {
        'jQuery' : {
            'exports' : 'jQuery'
        },
        'angular' : {
            'exports' : 'angular'
        },
        'angular-ui-router' : {
            'deps' : ['angular'],
            'exports' : 'angular-ui-router'
        },
        'angular-resource' : ['angular'],
        'ng-file-upload-shim' : {
            'deps' : ['angular'],
            'exports' : 'ng-file-upload-shim'
        },
        'ng-file-upload' : {
            'deps' : ['angular'],
            'exports' : 'ng-file-upload'
        }
    }
});

require(['angular', 'modules/app/dashboard'], function(angular) {
    angular.bootstrap(document, ['dashboardModule']);
});
