webApp.factory('rentacarFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/rentacar/');
	};
	
	factory.getRentACar = function(id) {
		return $http.get('/PutujIgumane/api/rentacar/'+id);
	};
	
	factory.getFreeCars = function(id,from,to) {
		return $http.get('/PutujIgumane/api/rentacar/freeCars/'+id,{params: {from:from, to:to}});
	};
	
	factory.updateRentacar = function(rentacar){
		return $http.put('/PutujIgumane/api/rentacar/editRentacar/',rentacar);
	}
	
	factory.getSpisakFilijala = function(rentacarId){
		return $http.get('/PutujIgumane/api/rentacar/spisakFilijala/'+rentacarId);
	}
	
	factory.getFilijala = function(filijalaId){
		return $http.get('/PutujIgumane/api/rentacar/editFilijala/'+filijalaId);
	}
	
	factory.updateFilijala = function(filijala){
		return $http.put('/PutujIgumane/api/rentacar/updateFilijala/',filijala);
	}
	
	factory.addFilijala = function(filijala,rentacarId){
		return $http.put('/PutujIgumane/api/rentacar/addFilijala/'+rentacarId,filijala);
	}
	factory.deleteFilijala = function(id,rentacarId){
		return $http.delete('/PutujIgumane/api/rentacar/delete/filijala/',{params: {id:id, rentacarId:rentacarId}});
	}
	
	factory.getVozilaJednogServisa = function(voziloId){
		return $http.get('/PutujIgumane/api/rentacar/vozila/'+voziloId);
	}
	
	factory.getVozilo = function(voziloId){
		return $http.get('/PutujIgumane/api/rentacar/editVozilo/'+voziloId);
	}
	
	factory.updateVozilo = function(vozilo){
		return $http.put('/PutujIgumane/api/rentacar/updateVozilo/',vozilo);
	}
	
	factory.addVozilo = function(vozilo,rentacarId){
		return $http.put('/PutujIgumane/api/rentacar/addVozilo/'+rentacarId,vozilo);
	}
	
	factory.deleteVozilo = function(id,rentacarId){
		return $http.delete('/PutujIgumane/api/rentacar/delete/vozilo/',{params: {id:id, rentacarId:rentacarId}});
	}
	
	factory.getOceneRentacar = function(rentacarId){
		return $http.get('/PutujIgumane/api/rentacar/ocene/rentacar/'+rentacarId);
	};
	
	factory.getOceneVozilo = function(voziloId){
		return $http.get('/PutujIgumane/api/rentacar/ocene/vozilo/'+voziloId);
	};
	
	factory.getPrihode = function(rentacarId,from,to) {
		return $http.get('/PutujIgumane/api/rentacar/prihodi/'+rentacarId,{params: {from:from, to:to}});
	};
	
	factory.setStatuse = function(voziloId,cena,popust,from,to){
		return $http.put('/PutujIgumane/api/rentacar/setStatusi/'+voziloId,{},{params: {cena:cena, popust:popust, from:from, to:to}});
	};
	
	factory.getVoziloZaRez = function(cenaFrom,cenaTo,datumFrom,datumTo,brojSedista){
		return $http({
		    url: '/PutujIgumane/api/rentacar/vozilo/rez/', 
		    method: "GET",
		    params: {cenaFrom:cenaFrom,cenaTo:cenaTo,datumFrom:datumFrom,datumTo:datumTo,brojSedista:brojSedista}
		 });
	};
	
	factory.getVozilaBrza = function(rentacarId,from,to){
		return $http.get('/PutujIgumane/api/rentacar/vozilo/brza/',{params: {rentacarId:rentacarId, from:from, to:to}});
	};
	
	return factory;
	
});