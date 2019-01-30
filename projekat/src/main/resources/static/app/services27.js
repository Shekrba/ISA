/**
 *  MainPage za registrovanog korisnika
 */

webApp.factory('hotelFactoryRegUser', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/regUserHoteli/');
	};
	
	factory.getHotel = function(id) {
		return $http.get('/PutujIgumane/api/regUserHoteli/'+id);
	};
	
	factory.getFreeRooms = function(id,from,to) {
		return $http.get('/PutujIgumane/api/regUserHoteli/freeRooms/'+id,{params: {from:from, to:to}});
	};
	
	return factory;
	
});

webApp.factory('rentacarFactoryRegUser', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/regUserRentacar/');
	};
	
	factory.getRentACar = function(id) {
		return $http.get('/PutujIgumane/api/regUserRentacar/'+id);
	};
	
	factory.getFreeCars = function(id,from,to) {
		return $http.get('/PutujIgumane/api/regUserRentacar/freeCars/'+id,{params: {from:from, to:to}});
	};
	
	return factory;
	
});

webApp.factory('avioKompanijeFactoryRegUser', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/regUserAvioKompanije/');
	};
	
	return factory;
	
});

