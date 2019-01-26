
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
});

webApp.controller('hoteliController', function($scope, $location, hotelFactory) {
	
    function init() {
    	hotelFactory.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.hoteli="Greska";
		});
    	
    	hotelFactory.getHotel().then(function success(response) {
    		$scope.hotel=response.data;
		}, function error(response) {
			$scope.hotel="Greska";
		});
    };

	init();
	
	$scope.prikazProfilaHotela=function(id,from,to){
		$location.path("/hoteli/"+id+'/'+from+'/'+to);
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