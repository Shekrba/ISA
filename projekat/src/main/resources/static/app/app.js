// napravimo modul
var webApp = angular.module('webApp', ['ngRoute']);

webApp.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'partials/mainPage.html'
	}).when('/hoteli',{
		templateUrl: 'partials/hoteli.html'
	});
	
});