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
	
	return factory;
	
});

webApp.factory('avioKompanijeFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/avioKompanije/');
	};
	
	return factory;
	
});
