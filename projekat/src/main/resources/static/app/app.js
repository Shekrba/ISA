// napravimo modul
var webApp = angular.module('webApp', ['ngRoute','uiGmapgoogle-maps','jkuri.datepicker']);


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
	}).when('/hoteli/oceneSobaHotela/:hotelId',{
		templateUrl: 'partials/oceneSobaKartice.html'
	}).when('/hoteli/oceneSobe/:sobaId',{
		templateUrl: 'partials/izvestajOcenaSobe.html'
	}).when('/hoteli/prihodi/:hotelId',{
		templateUrl: 'partials/uvidPrihodaHotela.html'
	}).when('/hoteli/setStatuse/:sobaId',{
		templateUrl: 'partials/podesavanjeCeneSobe.html'
	}).when('/add/hotel',{
		templateUrl: 'partials/dodavanjeHotela.html'
	}).when('/add/aviokompanija',{
		templateUrl: 'partials/dodavanjeAvio.html'
	}).when('/add/rentacar',{
		templateUrl: 'partials/dodavanjeRentacar.html'
	}).when('/add/admin/hotel',{
		templateUrl: 'partials/regAdminHotel.html'
	}).when('/add/admin/aviokompanija',{
		templateUrl: 'partials/regAdminAvio.html'
	}).when('/add/admin/rentacar',{
		templateUrl: 'partials/regAdminRent.html'
	}).when('/add/admin/sistem',{
		templateUrl: 'partials/regAdminSis.html'
	}).when('/rezervacija/',{
		templateUrl: 'partials/tabs.html'
	}).when('/rezervacija/hotel/',{
		templateUrl: 'partials/biranjeRezervacijeHotela.html'
	}).when('/rezervacija/rentacar/',{
		templateUrl: 'partials/biranjeRezervacijeRentacara.html'
	}).when('/rentacar/:id',{
		templateUrl: 'partials/rentacarProfil.html'
	}).when('/rentacar/editRentacar/:id',{
		templateUrl: 'partials/rentacarIzmenaInf.html'
	}).when('/rentacar/filijala/:rentacarId',{
		templateUrl: 'partials/izmenaFilijala.html'
	}).when('/rentacar/editFilijala/:filijalaId',{
		templateUrl: 'partials/izmenaJedneFilijale.html'
	}).when('/rentacar/addFilijala/:rentacarId',{
		templateUrl: 'partials/dodavanjeFilijale.html'
	}).when('/rentacar/vozila/:rentacarId',{
		templateUrl: 'partials/konfiguracijaVozila.html'
	}).when('/rentacar/editVozilo/:voziloId',{
		templateUrl: 'partials/izmenaVozila.html'
	}).when('/rentacar/addVozilo/:rentacarId',{
		templateUrl: 'partials/dodavanjeVozila.html'
	}).when('/rentacar/oceneRentacar/:rentacarId',{
		templateUrl: 'partials/izvestajOcenaRentacar.html'
	}).when('/rentacar/oceneVozilaServisa/:rentacarId',{
		templateUrl: 'partials/oceneVozilaKartice.html'
	}).when('/rentacar/oceneVozila/:voziloId',{
		templateUrl: 'partials/izvestajOcenaVozila.html'
	}).when('/rentacar/prihodi/:rentacarId',{
		templateUrl: 'partials/uvidPrihodaRentacar.html'
	}).when('/rentacar/setStatuse/:voziloId',{
		templateUrl: 'partials/podesavanjeCeneVozila.html'
	}).when('/login',{
		templateUrl: 'partials/login.html'
	}).when('/korisnik/addKorisnik',{
		templateUrl: 'partials/registracija.html'
	}).when('/korisnik/uspesnaRegistracija',{
		templateUrl: 'partials/postRegistracija.html'
	}).when('/users/:name',{
		templateUrl: 'partials/pretragaKorisnika.html'
	}).when('/zahtevi',{
		templateUrl: 'partials/zahtevi.html'
	}).when('/izmena/ak',{
		templateUrl: 'partials/avioKompanijaIzmena.html'
	}).when('/izmena/letovi',{
		templateUrl: 'partials/avioKompanijaIzmenaLetova.html'
	}).when('/izmena/letovi/novi',{
		templateUrl: 'partials/avioKompanijaNoviLet.html'
	}).when('/izmena/letovi',{
		templateUrl: 'partials/avioKompanijaIzmenaLetova.html'
	}).when('/prijatelji',{
		templateUrl: 'partials/prijatelji.html'
	});
	$routeProvider.otherwise({redirectTo: '/'});
});