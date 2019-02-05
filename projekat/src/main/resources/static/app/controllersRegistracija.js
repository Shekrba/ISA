/**
 * 
 */

webApp.controller('dodavanjeKorisnikaController', function($scope, $location, korisnikFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeKorisnika=function(k){
		korisnikFactory.addKorisnik(k).then(function success(response) {
    		$scope.addedKorisnik=response.data;
    		$location.path("/rentacar/vozila/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});