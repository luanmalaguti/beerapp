'use strict';

angular.module('BeerApp', [
  'ngRoute',
  'myApp.view'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
  $routeProvider.otherwise({redirectTo: '/view'});
}]);
