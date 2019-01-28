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
	
	return factory;
	
});