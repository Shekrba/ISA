
webApp.controller('mainController', function($rootScope,$scope, $location) {
	
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

webApp.controller('izmenaCenovnikaController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getCenovnik($routeParams.hotelId).then(function success(response) {
    		$scope.cenovnik=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaUsluge=function(id){
		$location.path("/hoteli/editUsluga/"+id);
	}
	
	$scope.dodavanjeUsluge=function(){
		$location.path("/hoteli/addUsluga/"+1);
	}
	
	$scope.brisanjeUsluge=function(id){
		hotelFactory.deleteUsluga(id,$routeParams.hotelId).then(function success(response) {
    		$scope.cenovnik=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('cenovnikIzmenaUslugeController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getUsluga($routeParams.uslugaId).then(function success(response) {
    		$scope.usluga=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaUsluge=function(u){
		hotelFactory.updateUsluga(u).then(function success(response) {
    		$scope.updatedUsluga=response.data;
    		$location.path("/hoteli/cenovnik/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('cenovnikDodajUsluguController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeUsluge=function(u){
		hotelFactory.addUsluga(u,1).then(function success(response) {
    		$scope.addedUsluga=response.data;
    		$location.path("/hoteli/cenovnik/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('konfSobaController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getSobe($routeParams.hotelId).then(function success(response) {
    		$scope.sobe=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaSobe=function(id){
		$location.path("/hoteli/editSoba/"+id);
	}
	
	$scope.dodavanjeSobe=function(){
		$location.path("/hoteli/addSoba/"+$routeParams.hotelId);
	}
	
	$scope.brisanjeSobe=function(id){
		hotelFactory.deleteSoba(id,$routeParams.hotelId).then(function success(response) {
    		$scope.sobe[0]=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izmenaSobeController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getSoba($routeParams.sobaId).then(function success(response) {
    		$scope.soba=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaSobe=function(s){
		hotelFactory.updateSoba(s).then(function success(response) {
    		$scope.updatedUsluga=response.data;
    		$location.path("/hoteli/sobe/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodavanjeSobeController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeSobe=function(s){
		hotelFactory.addSoba(s,1).then(function success(response) {
    		$scope.addedSoba=response.data;
    		$location.path("/hoteli/sobe/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izvestajOcenaHotelaController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($routeParams.hotelId).then(function success(response) {
    		$scope.hotel=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	hotelFactory.getOceneHotela($routeParams.hotelId).then(function success(response) {
    		$scope.ocene=response.data;
    	}, function error(response) {
    		$scope.error="Greska";
    	});
    };

	init();
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
