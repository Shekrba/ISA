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
	}).when('/hoteli/editHotel/:id',{
		templateUrl: 'partials/hotelIzmenaInf.html'
	}).when('/hoteli/cenovnik/:hotelId',{
		templateUrl: 'partials/izmenaCenovnikaHotela.html'
	}).when('/hoteli/editUsluga/:uslugaId',{
		templateUrl: 'partials/izmenaUsluge.html'
	}).when('/hoteli/addUsluga/:hotelId',{
		templateUrl: 'partials/dodavanjeUsluge.html'
	}).when('/rentacar/:id',{
		templateUrl: 'partials/rentacarProfil.html'
	}).when('/login',{
		templateUrl: 'partials/login.html'
	}).when('/users/:name',{
		templateUrl: 'partials/pretragaKorisnika.html'
	}).when('/zahtevi',{
		templateUrl: 'partials/zahtevi.html'
	});
	$routeProvider.otherwise({redirectTo: '/'});
});