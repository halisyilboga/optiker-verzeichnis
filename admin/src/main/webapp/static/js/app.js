'use strict';

/* App Module */

var ovAdminApp = angular.module('ovAdminApp', [
  'ngRoute',
  'ovAdminAppControllers'
]);

ovAdminApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/optician', {
        templateUrl: 'optician/opticianView.html',
        controller: 'OpticianListCtrl'
      }).
      when('/optician/:opticianId', {
        templateUrl: 'optician/opticianDetailsView.html',
        controller: 'OpticianDetailsCtrl'
      }).
      when('/dashboard', {
          templateUrl: 'dashboard.html',
          controller: 'DashboardCtrl'
        }).
      otherwise({
        redirectTo: '/dashboard'
      });
  }]);