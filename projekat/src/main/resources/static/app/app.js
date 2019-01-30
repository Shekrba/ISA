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
	}).when('/rentacar/:id',{
		templateUrl: 'partials/rentacarProfil.html'
	}).when('/login',{
		templateUrl: 'partials/login.html'
	}).when('/regUserMainPage',{
		templateUrl: 'partials/regUserMainPage.html'
	}).when('/regUserHoteli',{
		templateUrl: 'partials/regUserHoteli.html'
	}).when('/regUserHoteli/:id',{
		templateUrl: 'partials/regUserHotelProfil.html'
	}).when('/regUserAvioKompanije',{
		templateUrl: 'partials/regUserAvioKompanije.html'
	}).when('/regUserRentacar',{
		templateUrl: 'partials/regUserRentacar.html'
	}).when('/regUserRentacar/:id',{
		templateUrl: 'partials/regUserRentacarProfil.html'
	});
	$routeProvider.otherwise({redirectTo: '/'});
	
});