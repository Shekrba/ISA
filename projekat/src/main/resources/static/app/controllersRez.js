webApp.controller('tabController', function($rootScope,$scope, $location, $log, rezFactory) {
	
	function init() {
		$rootScope.putanja='partials/letoviSvi.html';
		
		$rootScope.letClass = 'nav-link active';
		
		$rootScope.hotelClass = 'nav-link disabled';
		
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