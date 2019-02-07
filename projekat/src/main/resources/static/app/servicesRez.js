webApp.factory('rezFactory', function($http) {
	
	var factory = {};	
	
	factory.getEmptyRez = function(){
		return $http.get('/PutujIgumane/api/korisnik/newRez');
	};
	
	factory.makeRez = function(rezervacija){
		return $http.put('/PutujIgumane/api/korisnik/makeRez',rezervacija);
	};
	
	return factory;
	
});