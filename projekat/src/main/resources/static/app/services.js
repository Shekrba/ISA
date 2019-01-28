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
	
	return factory;
	
});

webApp.factory('avioKompanijeFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/avioKompanije/');
	};
	
	return factory;
	
});

webApp.factory('rentacarFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/rentacar/');
	};
	
	return factory;
	
});