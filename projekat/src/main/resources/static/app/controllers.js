
webApp.controller('mainController', function($rootScope,$scope, $location) {
	
    function init() {
    	$rootScope.getImage= (url, imageType = 'image/jpeg') => {
    		  return $http.get(url, {responseType: 'arraybuffer'}).then((res) => {
    			    let blob = new Blob([res.data], {type: imageType});
    			    return (window.URL || window.webkitURL).createObjectURL(blob);
    			  });
    			};
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
	
	$scope.izmenaInfHotela=function(){
		$location.path("/hoteli/editHotel/1")
	}
});

webApp.controller('hoteliController', function($scope, $location, hotelFactory) {
	
    function init() {
    	hotelFactory.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaHotela=function(id){
		$location.path("/hoteli/"+id);
	};
});

webApp.controller('hotelProfilController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($routeParams.id).then(function success(response) {
    		$scope.hotel=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazSoba=function(from,to){
		hotelFactory.getFreeRooms($routeParams.id,from,to).then(function success(response) {
    		$scope.freeSobe=response.data;
		}, function error(response) {
			$scope.errorSobe="Greska";
		});
	}
});

webApp.controller('hotelIzmenaInfController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($routeParams.id).then(function success(response) {
    		$scope.hotel=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaHotela=function(h){
		hotelFactory.updateHotel(h).then(function success(response) {
    		$scope.updatedHotel=response.data;
    		$location.path("/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('avioKompanijeController', function($scope, $location, avioKompanijeFactory) {
	
	function init() {
    	avioKompanijeFactory.getAll().then(function success(response) {
    		$scope.avioKompanije=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
});

webApp.controller('rentacarController', function($scope, $location, rentacarFactory) {
	
	function init() {
		rentacarFactory.getAll().then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
});