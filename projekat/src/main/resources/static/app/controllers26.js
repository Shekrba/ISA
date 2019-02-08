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
	
	$scope.oceni=function(value){
		rentacarFactory.addOcenaRentacar($routeParams.rentacarId, value).then(function success(response) {
    		$scope.ocena=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
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

webApp.controller('rentacarIzmenaInfController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getRentACar($routeParams.id).then(function success(response) {
    		$scope.rentacar=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaRentacar=function(r){
		rentacarFactory.updateRentacar(r).then(function success(response) {
    		$scope.updatedRentacar=response.data;
    		$location.path("/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izmenaSpiskaFilijalaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getSpisakFilijala($routeParams.rentacarId).then(function success(response) {
    		$scope.spisakFilijala=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaFilijale=function(id){
		$location.path("/rentacar/editFilijala/"+id);
	}
	
	$scope.dodavanjeFilijale=function(){
		$location.path("/rentacar/addFilijala/"+1);
	}
	
	$scope.brisanjeFilijale=function(id){
		rentacarFactory.deleteFilijala(id,$routeParams.rentacarId).then(function success(response) {
    		$scope.spisakFilijala=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izmenaFilijaleController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getFilijala($routeParams.filijalaId).then(function success(response) {
    		$scope.filijala=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaJedneFilijale=function(f){
		rentacarFactory.updateFilijala(f).then(function success(response) {
    		$scope.updatedFilijala=response.data;
    		$location.path("/rentacar/filijala/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodajFilijaluController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeFilijale=function(f){
		rentacarFactory.addFilijala(f,1).then(function success(response) {
    		$scope.addedFilijala=response.data;
    		$location.path("/rentacar/spisakFilijala/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('konfVozilaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getVozilaJednogServisa($routeParams.rentacarId).then(function success(response) {
    		$scope.vozila=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaVozila=function(id){
		$location.path("/rentacar/editVozilo/"+id);
	}
	
	$scope.dodavanjeVozila=function(){
		$location.path("/rentacar/addVozilo/"+$routeParams.rentacarId);
	}
	
	$scope.brisanjeVozila=function(id){
		rentacarFactory.deleteVozilo(id,$routeParams.rentacarId).then(function success(response) {
    		$scope.vozila[0]=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
	
	$scope.podesiCene=function(id){
		$location.path("/rentacar/setStatuse/"+id);
	}
});

webApp.controller('izmenaVozilaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getVozilo($routeParams.voziloId).then(function success(response) {
    		$scope.vozilo=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izmenaVozila=function(v){
		rentacarFactory.updateVozilo(v).then(function success(response) {
    		$scope.updatedVozilo=response.data;
    		$location.path("/rentacar/vozila/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodavanjeVozilaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeVozila=function(v){
		rentacarFactory.addVozilo(v,1).then(function success(response) {
    		$scope.addedVozilo=response.data;
    		$location.path("/rentacar/vozila/1");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izvestajOcenaRentacarController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getRentACar($routeParams.rentacarId).then(function success(response) {
    		$scope.rentacar=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	rentacarFactory.getOceneRentacar($routeParams.rentacarId).then(function success(response) {
    		$scope.ocene=response.data;
    	}, function error(response) {
    		$scope.error="Greska";
    	});
    };

	init();
});

webApp.controller('oceneVozilaServisaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getRentACar($routeParams.rentacarId).then(function success(response) {
    		$scope.rentacar=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikaziOceneVozila=function(id){
		$location.path("/rentacar/oceneVozila/"+id);
	};
});

webApp.controller('izvestajOcenaVozilaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getVozilo($routeParams.voziloId).then(function success(response) {
    		$scope.vozilo=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	rentacarFactory.getOceneVozila($routeParams.voziloId).then(function success(response) {
    		$scope.ocene=response.data;
    	}, function error(response) {
    		$scope.error="Greska";
    	});
    };

	init();
});

webApp.controller('uvidPrihodaRentacarController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getRentACar($routeParams.rentacarId).then(function success(response) {
    		$scope.rentacar=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazPrihoda=function(from,to){
		rentacarFactory.getPrihode($routeParams.rentacarId,from,to).then(function success(response) {
    		$scope.prihodi=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	};
});

webApp.controller('podesavanjeCeneVozilaController', function($scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	rentacarFactory.getVozilo($routeParams.voziloId).then(function success(response) {
    		$scope.vozilo=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.podesiVozilo=function(cena,popust,from,to){
		rentacarFactory.setStatuse($routeParams.voziloId,cena,popust,from,to).then(function success(response) {
    		$scope.statusi=response.data;
    	}, function error(response) {
			$scope.error="Greska";
    	});
		$location.path("/rentacar/vozilo/"+1);
	};
});

webApp.controller('biranjeRezervacijeRentacarController', function($rootScope,$scope, $location, rentacarFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.regularna=function(){
		
		$rootScope.rentacarBrza=false;
		$rootScope.putanja='partials/rezervacijaRentacar.html'
	};
	
	$scope.brza=function(){
		
		$rootScope.rentacarBrza=true;
		$rootScope.putanja='partials/rezervacijaRentacar.html'
	};
});

webApp.controller('rezervacijaRentacarController', function($rootScope,$scope, $location, rentacarFactory,$routeParams) {
	
	function init() {
		rentacarFactory.getAll().then(function success(response) {
			$scope.rentacars=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izaberiRentacar=function(rId){
		$rootScope.rentacarRezervacija=rId;
		if($rootScope.rentacarBrza){
			if($rootScope.datumPovratka!=null){
				$rootScope.putanja='partials/rezervacijaVozilaBrza.html'
			}else{
				$rootScope.putanja='partials/izaberiDatum1.html'
			}
		}else{
			$rootScope.putanja='partials/rezervacijaVozila.html'
		}
	};
});

webApp.controller('izaberiDatumController1', function($rootScope,$scope, $location, rentacarFactory,$routeParams) {
	
	function init() {
    	$rootScope.datumDolaska = '2019-02-01';
    };

	init();
	
	$scope.nastavi=function(){
		$rootScope.putanja='partials/rezervacijaVozilaBrza.html'
	};
});

webApp.controller('rezervacijaVozilaBrzaController', function($rootScope,$scope, $location, rentacarFactory,$routeParams, rezFactory) {

	function init() {
		rentacarFactory.getVozilaBrza($rootScope.rentacarRezervacija['id'],$rootScope.datumDolaska,$rootScope.datumPovratka)
		.then(function success(response) {
			$scope.vozilaBrza=response.data
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();

		$scope.rezervisi=function(v){

			var rv = {'id':null,'vozilo':{'id':v.id,'registracijaVozila':v.registracijaVozila,'brojSedista':v.brojSedista},'datumDolaska':$rootScope.datumDolaska,'datumOdlaska':$rootScope.datumPovratka};

	    	$rootScope.rezervacija.rezervacijaVozila.push(rv);

	    	rezFactory.makeRez($rootScope.rezervacija).then(function success(response) {
	    		$scope.madeRez=response.data;
	    	}, function error(response) {
				$scope.error="Greska";
			});

	    	$location.path("/#/");
	};
});

webApp.controller('rezervacijaVozilaController', function($rootScope,$scope, $location, rentacarFactory,$routeParams) {
	
	function init() {
		
    };

	init();
	
	$scope.prikazi=function(){
		$rootScope.putanja='partials/rezervacijaVozila2.html'
	};
});

webApp.controller('rezervacijaVozila2Controller', function($rootScope,$scope, $location, rentacarFactory,$routeParams) {
	
	function init() {
		
		$scope.selektovaneVozila = 0;
		$scope.classVozila = 'fa fa-times-circle';
		$scope.styleVozila = {color:'#CA2727'};
		$scope.disabledButton = true;
		
		rentacarFactory.getVoziloZaRez($rootScope.cenaOd,$rootScope.cenaDo,$rootScope.datumDolaskaRentacar,$rootScope.datumOdlaskaRentacar, $rootScope.brSedista).then(function success(response) {
			$scope.voziloZaRez=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
		
    };

	init();
	
	$scope.dodajVozilo=function(v){
    	$scope.selektovaneVozila++;
    	
    	//var rv = {'id':null,'vozilo':v,'datumDolaska':$rootScope.datumDolaskaRentacar,'datumOdlaska':$rootScope.datumOdlaskaRentacar};
    	var rv = {'id':null,'vozilo':{'id':v.id,'registracijaVozila':v.registracijaVozila,'brojSedista':v.brojSedista},'datumDolaska':$rootScope.datumDolaskaRentacar,'datumOdlaska':$rootScope.datumOdlaskaRentacar};

    	$rootScope.rezervacija.rezervacijaVozila.push(rv);
    	
    	if($scope.selektovaneVozila == 1){
    		$scope.classVozila = 'fa fa-check-circle';
    		$scope.styleVozila = {color:'#99CA27'};
    	}else{
    		$scope.classVozila = 'fa fa-times-circle';
    		$scope.styleVozila = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaneVozila >= 1){
    		$scope.disabledButton = false;
    	}else{
    		$scope.disabledButton = true;
    	}
    	
    	return true;
    }
	
	$scope.izbaciVozilo=function(v){
    	$scope.selektovaneVozila--;
    	
    	var i = 0;
    	for ( var rv of $rootScope.rezervacija.rezervacijaVozila) {
			if(rv.vozilo.id==v.id){
				$rootScope.rezervacija.rezervacijaVozila.splice(i, 1);
				break;
			}
			i++;
		}
    	
    	
    	if($scope.selektovaneVozila == 1){
    		$scope.classVozila = 'fa fa-check-circle';
    		$scope.styleVozila = {color:'#99CA27'};
    	}else{
    		$scope.classVozila = 'fa fa-times-circle';
    		$scope.styleVozila = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaneVozila >= 1){
    		$scope.disabledButton = false;
    	}else{
    		$scope.disabledButton = true;
    	}
    	
    	return false;
    }
	
	$scope.finishRez = function(){
    	$rootScope.putanja='partials/rentacarKrajRezervacije.html'
    }
	
});

webApp.controller('rentacarFinishRezController', function($rootScope,$scope, $location, rentacarFactory,$routeParams, rezFactory) {
	
    function init() {
    	
    };

	init();
	
	$scope.zavrsiRez=function(){
		rezFactory.makeRez($rootScope.rezervacija).then(function success(response) {
    		$scope.madeRez=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
		
		$location.path("/#/");
	};
});