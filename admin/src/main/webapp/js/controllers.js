'use strict';

/* Controllers */

var klpvAdminAppControllers = angular.module('klpvAdminAppControllers', []);

klpvAdminAppControllers.controller('ProductListCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/rest/product/fetchAll').success(function(data) {
				$scope.products = data;
			});
			$scope.orderProp = 'name';
		} ]);

klpvAdminAppControllers.controller('ProductDetailsCtrl', [
		'$scope',
		'$http',
		'$routeParams',
		function($scope, $http, $routeParams) {
			if ($routeParams.productId == 'new') {
				$scope.product = {};
			} else {
				$http.get('/rest/product/' + $routeParams.productId).success(
						function(data) {
							$scope.product = data;
						});
			}

			$scope.update = function(user) {
				$http.post('/rest/product', $scope.product).success(
						function(retdata) {
							$scope.product = retdata;
						});
			};

			$scope.reset = function() {
				$scope.product = {};
			};

			$scope.remove = function() {
				$http.delete('/rest/product/' + $scope.product.id);
				$scope.product = {};
			};
			
			$scope.addImage = function(product) {
				var f = document.getElementById('image').files[0], r = new FileReader();
                r.onloadend = function(e){
			    	var data = e.target.result;
			    	$http.post('rest/product/image/' + $scope.product.id + '/' + f.type, data);
			    }
			    r.readAsBinaryString(f);
			};
		} ]);

klpvAdminAppControllers.controller('DashboardCtrl', [ '$scope', '$routeParams',
		function($scope, $routeParams) {
		} ]);