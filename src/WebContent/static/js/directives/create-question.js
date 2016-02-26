define(['modules/directive', 'jQuery', 'lib/tool'], function(directive, $, tool) {
    directive.directive('questionMenu', function() {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                var hash = location.hash.replace("#/", "");
                var newHash = hash.replace(hash.substr(0, 1), hash.substr(0, 1).toUpperCase());
                var elem = $(element).find("span[ui-sref='" + hash + "']");
                scope.changeMenu(elem, hash, scope, newHash);
                $(element).find('span').bind({
                    mouseover : function() {
                        if (location.hash.replace("#/", "") != $(this).attr('ui-sref')) {
                            $(this).addClass('color-style01').removeClass('color-style02');
                            $(this).find('label').first().addClass('color-style02').removeClass('color-style01');
                        }
                    },
                    mouseout : function() {
                        if (location.hash.replace("#/", "") != $(this).attr('ui-sref')) {
                            $(this).removeClass('color-style01').addClass('color-style02');
                            $(this).find('label').first().addClass('color-style01').removeClass('color-style02');
                        }
                    }
                });
            }
        };
    }).directive('button', function() {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                $(element).bind({
                    mouseover : function() {
                        $(element).removeClass('a-apacity');
                    },
                    mouseout : function() {
                        $(element).addClass('a-apacity');
                    }
                });
            }
        };
    }).directive('reduceScreen', function() {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                $(element).bind({
                    click : function() {
                        $(this).addClass('hidden').siblings('span').removeClass('hidden');
                        $('#topContainerId').css('width', '94%');
                        $('#editQuestionId').css('width', '56%').removeClass('hidden');
                        $('#showQuestionId').css('width', '44%').removeClass('hidden');
                    }
                });
            }
        };
    }).directive('fullScreen', function() {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                $(element).bind({
                    click : function() {
                        $('#topContainerId').css('width', '94%');
                        $(this).addClass('hidden').siblings('span').removeClass('hidden');
                        if (attrs.fullScreen == 'edit') {
                            $('#editQuestionId').css('width', '100%');
                            $('#showQuestionId').addClass('hidden');
                        } else if (attrs.fullScreen == 'show') {
                            $('#editQuestionId').addClass('hidden');
                            $('#showQuestionId').css('width', '100%');
                        }
                    }
                });
            }
        };
    }).directive('area', function() {
        return {
            restrict : 'A',
            require : '?ngModel',
            link : function(scope, element, attrs, ngModel) {
                if (!ngModel) {
                    return;
                }
                element.on('keydown keyup change', function() {
                    ngModel.$setViewValue(element.text());
                });
                $(element).bind({
                    focus : function() {
                        $(this).addClass('border-style01');
                    },
                    blur : function() {
                        var template = false;
                        if ($(this).text().trim().length < 1) {
                            $(this).removeClass('font-style07').removeClass("font-style01").addClass('font-style06');
                        }
                        $(this).removeClass('border-style01');
                    },
                    keydown : function() {
                        if (attrs.id == "title") {
                            $(this).removeClass('font-style06').addClass("font-style07");
                        } else {
                            $(this).removeClass('font-style06').addClass("font-style01");
                        }
                    }
                });
            }
        };
    });
});