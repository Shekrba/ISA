/**
 * 
 */
webApp.factory('korisnikFactory', function($http) {
	
	var factory = {};

factory.addKorisnik = function(korisnik){
		return $http.put('/PutujIgumane/api/korisnik/addKorisnik/',korisnik);
	}

return factory;

});