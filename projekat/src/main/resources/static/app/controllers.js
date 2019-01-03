
webApp.controller('mainController', function($scope, $location) {
	
    function init() {
    	
    };

	init();
	
	$scope.prikaz=function(){
		$location.path("/hoteli");
	};
	
});

webApp.controller('hoteliController', function($scope, $location, hotelFactory) {
	
    function init() {
    	hotelFactory.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.hoteli="Greska";
		});
    };

	init();
	
});




