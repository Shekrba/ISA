webApp.controller('rentacarController', function($scope, $location, rentacarFactory) {
	
	function init() {
		rentacarFactory.getAll().then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaRentacara=function(id){
		$location.path("/rentacar/"+id);
	};
	
});

webApp.controller('rentacarProfilController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getRentACar($routeParams.id).then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazVozila=function(from,to){
		rentacarFactory.getFreeCars($routeParams.id,from,to).then(function success(response) {
    		$scope.freeVozila=response.data;
		}, function error(response) {
			$scope.errorVozila="Greska";
		});
	}
});