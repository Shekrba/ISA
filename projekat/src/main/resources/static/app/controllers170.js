
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

webApp.controller('hotelIzmenaInfController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($rootScope.hotel.id).then(function success(response) {
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

webApp.controller('izmenaCenovnikaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getCenovnik($rootScope.hotel.id).then(function success(response) {
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
		hotelFactory.deleteUsluga(id,$rootScope.hotel.id).then(function success(response) {
    		$scope.cenovnik=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('cenovnikIzmenaUslugeController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
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
    		$location.path("/hoteli/cenovnik/"+$rootScope.hotel.id);
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('cenovnikDodajUsluguController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeUsluge=function(u){
		hotelFactory.addUsluga(u,$rootScope.hotel.id).then(function success(response) {
    		$scope.addedUsluga=response.data;
    		$location.path("/hoteli/cenovnik/"+$rootScope.hotel.id);
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('konfSobaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
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
		$location.path("/hoteli/addSoba/"+$rootScope.hotel.id);
	}
	
	$scope.brisanjeSobe=function(id){
		hotelFactory.deleteSoba(id,$rootScope.hotel.id).then(function success(response) {
    		$scope.sobe[0]=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
	
	$scope.podesiCene=function(id){
		$location.path("/hoteli/setStatuse/"+id);
	}
});

webApp.controller('izmenaSobeController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
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
    		$location.path("/hoteli/sobe/"+$rootScope.hotel.id);
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodavanjeSobeController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeSobe=function(s){
		hotelFactory.addSoba(s,$rootScope.hotel.id).then(function success(response) {
    		$scope.addedSoba=response.data;
    		$location.path("/hoteli/sobe/"+$rootScope.hotel.id);
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('izvestajOcenaHotelaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($rootScope.hotel.id).then(function success(response) {
    		$scope.hotel=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	hotelFactory.getOceneHotela($rootScope.hotel.id).then(function success(response) {
    		$scope.ocene=response.data;
    	}, function error(response) {
    		$scope.error="Greska";
    	});
    };

	init();
});

webApp.controller('oceneSobaHotelaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($rootScope.hotel.id).then(function success(response) {
    		$scope.hotel=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikaziOceneSobe=function(id){
		$location.path("/hoteli/oceneSobe/"+id);
	};
});

webApp.controller('izvestajOcenaSobeController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getSoba($routeParams.sobaId).then(function success(response) {
    		$scope.soba=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	hotelFactory.getOceneSobe($routeParams.sobaId).then(function success(response) {
    		$scope.ocene=response.data;
    	}, function error(response) {
    		$scope.error="Greska";
    	});
    };

	init();
});

webApp.controller('uvidPrihodaHotelaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotel($rootScope.hotel.id).then(function success(response) {
    		$scope.hotel=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.prikazPrihoda=function(from,to){
		hotelFactory.getPrihode($rootScope.hotel.id,from,to).then(function success(response) {
    		$scope.prihodi=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
	};
});

webApp.controller('podesavanjeCeneSobeController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getSoba($routeParams.sobaId).then(function success(response) {
    		$scope.soba=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.podesiSobu=function(cena,popust,from,to){
		hotelFactory.setStatuse($routeParams.sobaId,cena,popust,from,to).then(function success(response) {
    		$scope.statusi=response.data;
    	}, function error(response) {
			$scope.error="Greska";
    	});
		$location.path("/hoteli/sobe/"+$rootScope.hotel.id);
	};
});

webApp.controller('biranjeRezervacijeHotelaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.regularna=function(){
		
		$rootScope.hotelBrza=false;
		$rootScope.putanja='partials/rezervacijaHotel.html'
	};
	
	$scope.brza=function(){
		
		$rootScope.hotelBrza=true;
		$rootScope.putanja='partials/rezervacijaHotel.html'
	};
	
	$scope.preskoci=function(){
		$rootScope.rezervacijaSobe=null;
		
		$rootScope.letClass = 'nav-link disabled';
		
		$rootScope.hotelClass = 'nav-link disabled';
		
		$rootScope.rentClass = 'nav-link active';
		
		$rootScope.putanja='partials/biranjeRezervacijeRentacara.html'
	};
});

webApp.controller('rezervacijaHotelaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
	function init() {
    	hotelFactory.getAll().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.izaberiHotel=function(hotel){
		$rootScope.hotelRezervacija=hotel;
		if($rootScope.hotelBrza){
			if($rootScope.datumPovratka!=null){
				$rootScope.putanja='partials/rezervacijaSobaBrza.html'
			}else{
				$rootScope.putanja='partials/izaberiDatum.html'
			}
		}else{
			$rootScope.putanja='partials/rezervacijaSoba.html'
		}
	};
});

webApp.controller('izaberiDatumController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
	function init() {
    	$rootScope.datumDolaska = '2019-02-01';
    };

	init();
	
	$scope.nastavi=function(){
		$rootScope.putanja='partials/rezervacijaSobaBrza.html'
	};
});

webApp.controller('rezervacijaSobaController', function($rootScope,$scope, $location, hotelFactory,$routeParams) {
	
	function init() {
		$rootScope.jed=false;
		$rootScope.dvo=false;
		$rootScope.tro=false;
		$rootScope.cet=false;
    };

	init();
	
	$scope.prikazi=function(){
		$rootScope.putanja='partials/rezervacijaSoba2.html'
	};
});

webApp.controller('rezervacijaSobaBrzaController', function($rootScope,$scope, $location, hotelFactory,$routeParams,rezFactory) {
	
	function init() {
		hotelFactory.getSobeBrza($rootScope.hotelRezervacija['id'],$rootScope.datumDolaska,$rootScope.datumPovratka)
		.then(function success(response) {
			$scope.sobeBrza=response.data
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.rezervisi=function(s){
		
		var rs = {'id':null,'soba':{'id':s.id,'brojSobe':s.brojSobe,'sprat':s.sprat,'brojKreveta':s.brojKreveta},'datumDolaska':$rootScope.datumDolaska,'cenovnici':[] ,'datumOdlaska':$rootScope.datumPovratka};
    	
    	$rootScope.rezervacija.rezervacijaSobe.push(rs);
		
    	rezFactory.makeRez($rootScope.rezervacija).then(function success(response) {
    		$scope.madeRez=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
    	
    	$location.path("/#/");
	};
});

webApp.controller('rezervacijaSoba2Controller', function($route,$rootScope,$scope, $location, hotelFactory,$routeParams,$log) {
	
	function init() {
		
		$scope.selektovaneSobe = 0;
		$scope.selektovaniKreveti = 0;
		
		$scope.classSobe = 'fa fa-times-circle';
		$scope.styleSobe = {color:'#CA2727'};
		$scope.classKreveti = 'fa fa-times-circle';
		$scope.styleKreveti = {color:'#CA2727'};
		$scope.disabledButton = true;
		
		
		var kreveti = [$rootScope.jed,$rootScope.dvo,$rootScope.tro,$rootScope.cet]
		
		hotelFactory.getSobeZaRez($rootScope.hotelRezervacija['id'],$rootScope.cenaOd,$rootScope.cenaDo,$rootScope.datumDolaskaHotel,$rootScope.datumOdlaskaHotel,kreveti)
		.then(function success(response) {
			$scope.sobeZaRez=(response.data)
		}, function error(response) {
			$scope.error="Greska";
		});
		
    };
    
    init();
    
    $scope.dodajSobu=function(s){
    	$scope.selektovaneSobe++;
    	$scope.selektovaniKreveti+= 1 * s['brojKreveta'];
    	$log.log(s);
    	var rs = {'id':null,'soba':s,'cenovnici':[],'datumDolaska':$rootScope.datumDolaskaHotel,'datumOdlaska':$rootScope.datumOdlaskaHotel};
    	
    	$rootScope.rezervacija.rezervacijaSobe.push(rs);
    	
    	if($scope.selektovaneSobe == $rootScope.brSoba){
    		$scope.classSobe = 'fa fa-check-circle';
    		$scope.styleSobe = {color:'#99CA27'};
    	}else{
    		$scope.classSobe = 'fa fa-times-circle';
    		$scope.styleSobe = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaniKreveti == $rootScope.brojGostijuHotel){
    		$scope.classKreveti = 'fa fa-check-circle';
    		$scope.styleKreveti = {color:'#99CA27'};
    	}else{
    		$scope.classKreveti = 'fa fa-times-circle';
    		$scope.styleKreveti = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaniKreveti*1 == $rootScope.brojGostijuHotel*1 && $scope.selektovaneSobe == $rootScope.brSoba){
    		$scope.disabledButton = false;
    	}else{
    		$scope.disabledButton = true;
    	}
    	
    	return true;
    }
    
    $scope.izbaciSobu=function(s){
    	$scope.selektovaneSobe--;
    	$scope.selektovaniKreveti-= 1 * s['brojKreveta'];
    	
    	var i = 0;
    	for ( var rs of $rootScope.rezervacija.rezervacijaSobe) {
			if(rs.soba.id == s.id){
				$rootScope.rezervacija.rezervacijaSobe.splice(i, 1);
				break;
			}
    		$log.log(rs.soba);
			i++;
		}
    	
    	if($scope.selektovaneSobe == $rootScope.brSoba){
    		$scope.classSobe = 'fa fa-check-circle';
    		$scope.styleSobe = {color:'#99CA27'};
    	}else{
    		$scope.classSobe = 'fa fa-times-circle';
    		$scope.styleSobe = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaniKreveti*1 == $rootScope.brojGostijuHotel*1){
    		$scope.classKreveti = 'fa fa-check-circle';
    		$scope.styleKreveti = {color:'#99CA27'};
    	}else{
    		$scope.classKreveti = 'fa fa-times-circle';
    		$scope.styleKreveti = {color:'#CA2727'};
    	}
    	
    	if($scope.selektovaniKreveti*1 == $rootScope.brojGostijuHotel*1 && $scope.selektovaneSobe == $rootScope.brSoba){
    		$scope.disabledButton = false;
    	}else{
    		$scope.disabledButton = true;
    	}
    	
    	return false;
    }
    
    $scope.finishRez = function(){
    	$rootScope.putanja='partials/rezUslugeHotela.html'
    }
	
});

webApp.controller('rezUslugaController', function($route,$rootScope,$scope, $location, hotelFactory,$routeParams) {
	
	function init() {
		
		hotelFactory.getCenovnik($rootScope.hotelRezervacija['id']).then(function success(response) {
    		$scope.cenovnik=response.data;
    	}, function error(response) {
			$scope.error="Greska";
		});
		
    };
    
    init();
    
    $scope.dodajUslugu=function(c){
   
    	for ( var rs of $rootScope.rezervacija.rezervacijaSobe) {
			rs.cenovnici.push(c)
		}
    	
    	return true;
    }
    
    $scope.izbaciUslugu=function(c){
    	
    	for ( var rs of $rootScope.rezervacija.rezervacijaSobe) {
    		var i = 0;
        	for ( var cenovnik of rs.cenovnici) {
    			if(cenovnik.id == c.id){
    				rs.cenovnici.splice(i, 1);
    				break;
    			}
    			i++;
    		}
		}
    	
    	return false;
    }
    
    $scope.finishRez = function(){
    	
    	$rootScope.putanja='partials/hotelFinishRez.html'
    }
	
});

webApp.controller('hotelFinishRezController', function($rootScope,$scope, $location, hotelFactory,$routeParams,rezFactory) {
	
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
	
	$scope.rezervisiRent=function(){
		
		$rootScope.letClass = 'nav-link disabled';
		
		$rootScope.hotelClass = 'nav-link disabled';
		
		$rootScope.rentClass = 'nav-link active';
		
		$rootScope.putanja='partials/biranjeRezervacijeRentacara.html'
	};
});

webApp.controller('dodavanjeHotelaController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeHotela=function(h){
		hotelFactory.addHotel(h).then(function success(response) {
    		$scope.addedHotel=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodavanjeAvioController', function($scope, $location, avioKompanijeFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeAvio=function(a){
		avioKompanijeFactory.addAvio(a).then(function success(response) {
    		$scope.addedAvio=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('dodavanjeRentacarController', function($scope, $location, rentFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.dodavanjeRentacar=function(r){
		rentFactory.addRentacar(r).then(function success(response) {
    		$scope.addedRentacar=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('regAdminHotelController', function($scope, $location, hotelFactory,$routeParams) {
	
    function init() {
    	hotelFactory.getHotelsNull().then(function success(response) {
			$scope.hoteli=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.regAdmin=function(a){
		a['hotelNaz'] = $scope.nazivHotela;
		hotelFactory.addAdminHotel(a).then(function success(response) {
    		$scope.addedAdmin=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('regAdminAvioController', function($scope, $location, avioKompanijeFactory,$routeParams) {
	
    function init() {
    	avioKompanijeFactory.getAvioNull().then(function success(response) {
			$scope.aviokompanije=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.regAdmin=function(a){
		a['avioNaz'] = $scope.nazivAvio;
		avioKompanijeFactory.addAdminAvio(a).then(function success(response) {
    		$scope.addedAdmin=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('regAdminRentController', function($scope, $location, rentFactory,$routeParams) {
	
    function init() {
    	rentFactory.getRentNull().then(function success(response) {
			$scope.rentacar=response.data;
		}, function error(response) {
			$scope.error="Greska";
		});
    };

	init();
	
	$scope.regAdmin=function(a){
		a['rentNaz'] = $scope.nazivRent;
		rentFactory.addAdminRent(a).then(function success(response) {
    		$scope.addedAdmin=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});
	}
});

webApp.controller('regAdminSisController', function($scope, $location, sisFactory,$routeParams) {
	
    function init() {
    	
    };

	init();
	
	$scope.regAdmin=function(a){
		/*sisFactory.addAdminSis(a).then(function success(response) {
    		$scope.addedAdmin=response.data;
    		$location.path("/#/");
    	}, function error(response) {
			$scope.error="Greska";
		});*/
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
