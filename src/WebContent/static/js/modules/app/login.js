define(['angular', 'controllers/login'], function(angular) {
    var loginModule = angular.module("loginModule", ['controller', 'service'], angular.noop);
    /*
     * loginModule.run(function($rootScope, $state, $stateParams) {
     * $rootScope.$state = $state; $rootScope.$stateParams = $stateParams; });
     */
    return loginModule;
});