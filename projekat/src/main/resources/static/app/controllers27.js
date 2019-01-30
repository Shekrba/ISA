/**
 * Main page za registrovanog korisnika
 */


webApp.controller('mainControllerRegUser', function($rootScope,$scope, $location) {
	
    function init() {
    	$rootScope.getImage= (url, imageType = 'image/jpeg') => {
    		  return $http.get(url, {responseType: 'arraybuffer'}).then((res) => {
    			    let blob = new Blob([res.data], {type: imageType});
    			    return (window.URL || window.webkitURL).createObjectURL(blob);
    			  });
    			};
    };

	init();
	
	$scope.prikazHotelaRegUser=function(){
		$location.path("/regUserHoteli");
	};
	
	$scope.prikazAvioKompanijaRegUser=function(){
		$location.path("/regUserAvioKompanije");
	};
	
	$scope.prikazRentacarRegUser=function(){
		$location.path("/regUserRentacar");
	};
});

webApp.controller('hoteliControllerRegUser', function($scope, $location, hotelFactoryRegUser) {
	
    function init() {
    	hotelFactoryRegUser.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaHotelaRegUser=function(id){
		$location.path("/regUserHoteli/"+id);
	};
});

webApp.controller('hotelProfilControllerRegUser', function($scope, $location, hotelFactoryRegUser,$routeParams) {
	
    function init() {
    	hotelFactoryRegUser.getHotel($routeParams.id).then(function success(response) {
    		$scope.hotel=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazSoba=function(from,to){
		hotelFactoryRegUser.getFreeRooms($routeParams.id,from,to).then(function success(response) {
    		$scope.freeSobe=response.data;
		}, function error(response) {
			$scope.errorSobe="Greska";
		});
	}
});

webApp.controller('avioKompanijeControllerRegUser', function($scope, $location, avioKompanijeFactoryRegUser) {
	
	function init() {
    	avioKompanijeFactoryRegUser.getAll().then(function success(response) {
    		$scope.avioKompanije=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
});
webApp.controller('rentacarControllerRegUser', function($scope, $location, rentacarFactoryRegUser) {
	
	function init() {
		rentacarFactoryRegUser.getAll().then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaRentacaraRegUser=function(id){
		$location.path("/regUserRentacar/"+id);
	};
	
});

webApp.controller('rentacarProfilControllerRegUser', function($scope, $location, rentacarFactoryRegUser,$routeParams) {
	
    function init() {
    	rentacarFactoryRegUser.getRentACar($routeParams.id).then(function success(response) {
    		$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazVozila=function(from,to){
		rentacarFactoryRegUser.getFreeCars($routeParams.id,from,to).then(function success(response) {
    		$scope.freeVozila=response.data;
		}, function error(response) {
			$scope.errorVozila="Greska";
		});
	}
});