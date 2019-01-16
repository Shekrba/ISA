
webApp.controller('mainController', function($scope, $location) {
	
    function init() {
    	
    };

	init();
	
	$scope.prikazHotela=function(){
		$location.path("/hoteli");
	};
	
	$scope.prikazAvioKompanija=function(){
		$location.path("/avioKompanije");
	};
	
	$scope.prikazRentacar=function(){
		$location.path("/rentacar");
	};
});

webApp.controller('hoteliController', function($scope, $location, hotelFactory, hotelProfilFactory) {
	
    function init() {
    	hotelFactory.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.hoteli="Greska";
		});
    	
    	hotelProfilFactory.getHotel().then(function success(response) {
    		$scope.hotel=response.data;
		}, function error(response) {
			$scope.hotel="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaHotela=function(id){
		$location.path("/hoteli/"+id);
	};
});

webApp.controller('avioKompanijeController', function($scope, $location, avioKompanijeFactory) {
	
	function init() {
    	avioKompanijeFactory.getAll().then(function success(response) {
    		$scope.avioKompanije=response.data;
		}, function error(response) {
			$scope.avioKompanije="Greska";
		});
    };

	init();
	
});

webApp.controller('rentacarController', function($scope, $location, rentacarFactory) {
	
	function init() {
		rentacarFactory.getAll().then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.rentacar="Greska";
		});
    };

	init();
	
});