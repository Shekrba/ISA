webApp.factory('hotelFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/hoteli/');
	};
	
	factory.getHotel = function(id) {
		return $http.get('/PutujIgumane/api/hoteli/'+id);
	};
	
	factory.getFreeRooms = function(id,from,to) {
		return $http.get('/PutujIgumane/api/hoteli/freeRooms/'+id,{params: {from:from, to:to}});
	};
	
	factory.updateHotel = function(hotel){
		return $http.put('/PutujIgumane/api/hoteli/editHotel/',hotel);
	}
	
	factory.getCenovnik = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/cenovnik/'+hotelId);
	}
	
	factory.getUsluga = function(uslugaId){
		return $http.get('/PutujIgumane/api/hoteli/editUsluga/'+uslugaId);
	}
	
	factory.updateUsluga = function(usluga){
		return $http.put('/PutujIgumane/api/hoteli/updateUsluga/',usluga);
	}
	
	factory.addUsluga = function(usluga,hotelId){
		return $http.put('/PutujIgumane/api/hoteli/addUsluga/'+hotelId,usluga);
	}
	factory.deleteUsluga = function(id,hotelId){
		return $http.delete('/PutujIgumane/api/hoteli/delete/usluga/',{params: {id:id, hotelId:hotelId}});
	}
	
	factory.getSobe = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/sobe/'+hotelId);
	}
	
	factory.getSoba = function(sobaId){
		return $http.get('/PutujIgumane/api/hoteli/editSoba/'+sobaId);
	}
	
	factory.updateSoba = function(soba){
		return $http.put('/PutujIgumane/api/hoteli/updateSoba/',soba);
	}
	
	factory.addSoba = function(soba,hotelId){
		return $http.put('/PutujIgumane/api/hoteli/addSoba/'+hotelId,soba);
	}
	
	factory.deleteSoba = function(id,hotelId){
		return $http.delete('/PutujIgumane/api/hoteli/delete/soba/',{params: {id:id, hotelId:hotelId}});
	}
	
	factory.getOceneHotela = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/ocene/hotel/'+hotelId);
	}
		
	factory.getSveSobe = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/oceneSoba/'+hotelId);
	}
	
	factory.getOceneSobe = function(sobaId){
		return $http.get('/PutujIgumane/api/hoteli/ocene/soba/'+sobaId);
	}
	
	return factory;
	
});

webApp.factory('avioKompanijeFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/avioKompanije/');
	};
	
	return factory;
	
});
