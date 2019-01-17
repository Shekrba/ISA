// napravimo modul
var webApp = angular.module('webApp', ['ngRoute']);

webApp.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'partials/mainPage.html'
	}).when('/hoteli',{
		templateUrl: 'partials/hoteli.html'
	}).when('/avioKompanije',{
		templateUrl: 'partials/avioKompanije.html'
	}).when('/rentacar',{
		templateUrl: 'partials/rentacar.html'
	}).when('/hoteli/:id/:from/:to',{
		templateUrl: 'partials/hotelProfil.html'
	});
	
});