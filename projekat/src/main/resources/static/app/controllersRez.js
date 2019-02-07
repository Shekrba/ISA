webApp.controller('tabController', function($rootScope,$scope, $location) {
	
	function init() {
		$rootScope.putanja='partials/biranjeRezervacijeHotela.html';
		
		$rootScope.letClass = 'nav-link disabled';
		
		$rootScope.hotelClass = 'nav-link active';
		
		$rootScope.rentClass = 'nav-link disabled';
    };

	init();
	
});