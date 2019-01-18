webApp.factory('hotelFactory', function($http,$routeParams) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/hoteli/');
	};
	
	factory.getHotel = function() {
		return $http.get('/PutujIgumane/api/hoteli/'+$routeParams.id+'/'+$routeParams.from+'/'+$routeParams.to);
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