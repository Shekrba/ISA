/**
 * 
 */

webApp.controller('dodavanjeKorisnikaController', function($scope, $location, korisnik1Factory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeKorisnika=function(korisnik){
		korisnik1Factory.addKorisnik(korisnik).then(function success(response) {
    		$scope.addedKorisnik=response.data;
    		$location.path("/korisnik/uspesnaRegistracija");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});