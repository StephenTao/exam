require.config({
    baseUrl : STATIC_URL + "static/js",
    urlArgs : "v=" + VERSION || "",
    paths : {
        'angular' : 'lib/angular.min',
        'jQuery' : 'lib/jquery-2.1.4.min',
        'angular-ui-router' : 'lib/angular-ui-router.min',
        'angular-resource' : 'lib/angular-resource.min'
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
        'angular-resource' : ['angular']
    }
});

require(['angular', 'jQuery', 'modules/app/login'], function(angular, $) {
    angular.bootstrap(document, ['loginModule']);
    $(function() {
        var hashValue = location.hash.split("#")[1];
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf("examRoute=");
            if (c_start != -1) {
                c_start = c_start + "examRoute".length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1)
                    c_end = document.cookie.length;
                var value = unescape(document.cookie.substring(c_start, c_end));
                if (value != "undefined") {
                    return;
                }
            }
        }
        if (hashValue != null || hashValue != "") {
            var exdate = new Date();
            exdate.setTime(exdate.getTime() + 30 * 60 * 1000);
            document.cookie = "examRoute=" + escape(hashValue) + ";Path=" + BASE_URL + ";expires="
                + exdate.toGMTString();
        }
    });
});
