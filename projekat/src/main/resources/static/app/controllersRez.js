webApp.controller('tabController', function($rootScope,$scope, $location, $log, rezFactory) {
	
	function init() {
		$rootScope.putanja='partials/biranjeRezervacijeHotela.html';
		
		$rootScope.letClass = 'nav-link disabled';
		
		$rootScope.hotelClass = 'nav-link active';
		
		$rootScope.rentClass = 'nav-link disabled';
		
	    rezFactory.getEmptyRez().then(function success(response) {
			$rootScope.rezervacija=response.data;
			$log.log(response.data);
	    }, function error(response) {
			$scope.error="Greska";
		});
	   
    };

	init();
	
});