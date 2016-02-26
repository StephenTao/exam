define(['angular', 'lib/tool'], function(angular, tool) {
    return angular.module('filter', []).filter(
        'fileNameFilter',
        function() {
            return function(input) {
                var array = input.match(tool.regex.fileNameFormat);
                if (array && array.length > 0) {
                    for (var i = 0; i < array.lenght; i++) {
                        var fileName = array[i].substring(data.lastIndexOf(':'), data.indexOf('/') - 1);
                        var fileType = fileName.substring(fileName.lastIndexOf('/'), fileName.lastIndexOf(']') - 1);
                        var source;
                        if (fileType == 'image') {
                            source = '<img src=' + RESOURCE_URL + '/' + fileName + '/>';

                        } else if (fileType == 'audio') {
                            var fullName = RESOURCE_URL + '/' + fileName;
                            source = '<img ng-click="playAudio("' + fullName + '")" src=' + STATIC_URL
                                + 'static/images/play.png />';
                        } else if (fileType == 'video') {
                            var fullName = RESOURCE_URL + '/' + fileName;
                            source = '<img ng-click="playVideo("' + fullName + '")" src=' + STATIC_URL
                                + 'static/images/play.png />';
                        }

                    }
                }
            }
        });
});