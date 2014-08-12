'use strict';

/* Controllers */

var ovAdminAppControllers = angular.module('ovAdminAppControllers', []);

ovAdminAppControllers.controller('OpticianListCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/rest/optician/fetchAll').success(function(data) {
				$scope.opticians = data;
			});
			$scope.orderProp = 'name';
		} ]);

ovAdminAppControllers.controller('OpticianDetailsCtrl', [
		'$scope',
		'$http',
		'$routeParams',
		function($scope, $http, $routeParams) {
			if ($routeParams.opticianId == 'new') {
				$scope.optician = {};
			} else {
				$http.get('/rest/optician/' + $routeParams.opticianId).success(
						function(data) {
							$scope.optician = data;
						});
			}

			$scope.update = function(user) {
				$http.post('/rest/optician', $scope.optician).success(
						function(retdata) {
							$scope.optician = retdata;
						});
			};

			$scope.reset = function() {
				$scope.optician = {};
			};

			$scope.remove = function() {
				$http.delete('/rest/optician/' + $scope.optician.id);
				$scope.optician = {};
			};
		} ]);

ovAdminAppControllers.controller('DashboardCtrl', [ '$scope', '$routeParams',
		function($scope, $routeParams) {
		} ]);