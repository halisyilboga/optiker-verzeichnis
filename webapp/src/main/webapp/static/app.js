'use strict';

/* App Module */

var klpvAdminApp = angular.module('OptikerVerzeichnisApp', [
  'ngRoute'
]);




klpvAdminApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/optiker/:city/:name', {
        templateUrl: 'optiker.html',
        controller: 'OptikerDetailsCtrl'
      }).
      when('/', {
          templateUrl: 'homepage.html',
          controller: 'HonepageCtrl'
        }).
      otherwise({
        redirectTo: '/'
      });
  }]);