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
	
	return factory;
	
});

webApp.factory('avioKompanijeFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/avioKompanije/');
	};
	
	return factory;
	
});