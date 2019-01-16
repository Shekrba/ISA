webApp.factory('hotelFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/hoteli/');
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

webApp.factory('hotelProfilFactory', function($http,$routeParams) {
	
	var factory = {};
	factory.getHotel = function() {
		return $http.get('/PutujIgumane/api/hoteli/'+$routeParams.id);
	};
	
	return factory;
	
});