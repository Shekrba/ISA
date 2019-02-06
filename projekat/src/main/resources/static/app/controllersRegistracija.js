/**
 * 
 */

webApp.controller('dodavanjeKorisnikaController', function($scope, $location, korisnikFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeKorisnika=function(korisnik){
		korisnikFactory.addKorisnik(korisnik).then(function success(response) {
    		$scope.addedKorisnik=response.data;
    		$location.path("/korisnik/addKorisnik");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});