'use strict';

/* App Module */

var klpvAdminApp = angular.module('klpvAdminApp', [
  'ngRoute',
  'klpvAdminAppControllers'
]);

klpvAdminApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/product', {
        templateUrl: 'product/productView.html',
        controller: 'ProductListCtrl'
      }).
      when('/product/:productId', {
        templateUrl: 'product/productDetailsView.html',
        controller: 'ProductDetailsCtrl'
      }).
      when('/dashboard', {
          templateUrl: 'dashboard.html',
          controller: 'DashboardCtrl'
        }).
      otherwise({
        redirectTo: '/dashboard'
      });
  }]);