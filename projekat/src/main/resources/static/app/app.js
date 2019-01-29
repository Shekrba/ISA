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
	}).when('/hoteli/:id',{
		templateUrl: 'partials/hotelProfil.html'
<<<<<<< HEAD
	}).when('/hoteli/editHotel/:id',{
		templateUrl: 'partials/hotelIzmenaInf.html'
=======
	}).when('/rentacar/:id',{
		templateUrl: 'partials/rentacarProfil.html'
>>>>>>> branch 'master' of https://github.com/Shekrba/ISA.git
	}).when('/login',{
		templateUrl: 'partials/login.html'
	});
	$routeProvider.otherwise({redirectTo: '/'});
	
});