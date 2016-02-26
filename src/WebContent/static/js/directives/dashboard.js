define(['modules/directive', 'jQuery'], function(directive, $) {
    directive.directive('questionNav', function() {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                $(element).bind({
                    mouseover : function() {
                        $(this).children('ul').removeClass('hidden');
                    },
                    mouseout : function() {
                        $(this).children('ul').addClass('hidden');
                    }
                });
            }
        };
    });
});