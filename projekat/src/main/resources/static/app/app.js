// napravimo modul
var webApp = angular.module('webApp', ['ngRoute','uiGmapgoogle-maps']);



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
	}).when('/hoteli/sobe/:hotelId',{
		templateUrl: 'partials/konfiguracijaSoba.html'
	}).when('/hoteli/editSoba/:sobaId',{
		templateUrl: 'partials/izmenaSobe.html'
	}).when('/hoteli/addSoba/:hotelId',{
		templateUrl: 'partials/dodavanjeSobe.html'
	}).when('/hoteli/oceneHotela/:hotelId',{
		templateUrl: 'partials/izvestajOcenaHotela.html'
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
	}).when('/users/:name',{
		templateUrl: 'partials/pretragaKorisnika.html'
	}).when('/zahtevi',{
		templateUrl: 'partials/zahtevi.html'
	}).when('/izmena/ak',{
		templateUrl: 'partials/avioKompanijaIzmena.html'
	});
	$routeProvider.otherwise({redirectTo: '/'});
});