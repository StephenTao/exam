require.config({
    baseUrl : STATIC_URL + "static/js/",
    urlArgs : "v=" + VERSION || "",
    paths : {
        'jQuery' : 'lib/jquery-2.1.4.min',
        'angular' : 'lib/angular.min',
        'angular-ui-router' : 'lib/angular-ui-router.min',
        'angular-resource' : 'lib/angular-resource.min',
        'swfobject' : 'lib/swfobject',
        'recorder' : 'lib/recorder',
        'recorder-operator' : 'lib/recorder-operator',
        'jQuery-ui' : 'lib/jquery-ui',
        'ng-file-upload-shim' : 'lib/ng-file-upload-shim.min',
        'ng-file-upload' : 'lib/ng-file-upload.min'
    },
    shim : {
        'jQuery' : {
            'exports' : 'jQuery'
        },
        'angular' : {
            'exports' : 'angular'
        },
        'jQuery-ui' : {
            'deps' : ['jQuery'],
            'exports' : 'jQuery-ui'
        },
        'angular-ui-router' : {
            'deps' : ['angular'],
            'exports' : 'angular-ui-router'
        },
        'swfobject' : {
            'exports' : 'swfobject'
        },
        'recorder' : {
            'exports' : 'recorder'
        },
        'recorder-operator' : {
            'deps' : ['recorder', 'swfobject'],
            'exports' : 'recorder-operator'
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

require(['angular', 'modules/app/exam-list'], function(angular) {
    angular.bootstrap(document, ['examListModule']);
});
