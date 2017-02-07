'use strict';

angular.module('myApp.view', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/view', {
		templateUrl : 'view/view.html',
		controller : 'ViewCtrl'
	});
} ])

.controller('ViewCtrl', ['$http', '$scope', function($http, $scope) {
	$scope.beer = {};
	$scope.errorMessage = "";
	
	$scope.randomBeer = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/beers/randombeer'
		}).then(function successCallback(response) {
			$scope.displayBeer(response.data)
		}, function errorCallback(response) {
			console.log(response);
			$scope.errorMessage = response.data.message;
		});
		
		$scope.displayBeer = function (beer) {
			$scope.beer.id = beer.id;
			$scope.beer.name = beer.name;
			$scope.beer.description = beer.description;
			$scope.beer.abv = beer.abv;
			$scope.beer.breweryLocation = beer.breweryLocation;
			$scope.beer.img = beer.img;
		}
	}
	
	if(Object.keys($scope.beer).length == 0){
		$scope.randomBeer();
	}

} ]);