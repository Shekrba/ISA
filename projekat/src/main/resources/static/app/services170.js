webApp.factory('hotelFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/hoteli/');
	};
	
	factory.getHotelsNull = function() {
		return $http.get('/PutujIgumane/api/hoteli/null/h');
	};
	
	factory.getHotel = function(id) {
		return $http.get('/PutujIgumane/api/hoteli/'+id);
	};
	
	factory.getFreeRooms = function(id,from,to) {
		return $http.get('/PutujIgumane/api/hoteli/freeRooms/'+id,{params: {from:from, to:to}});
	};
	
	factory.updateHotel = function(hotel){
		return $http.put('/PutujIgumane/api/hoteli/editHotel/',hotel);
	};
	
	factory.getCenovnik = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/cenovnik/'+hotelId);
	};
	
	factory.getUsluga = function(uslugaId){
		return $http.get('/PutujIgumane/api/hoteli/editUsluga/'+uslugaId);
	};
	
	factory.updateUsluga = function(usluga){
		return $http.put('/PutujIgumane/api/hoteli/updateUsluga/',usluga);
	};
	
	factory.addUsluga = function(usluga,hotelId){
		return $http.put('/PutujIgumane/api/hoteli/addUsluga/'+hotelId,usluga);
	};
	factory.deleteUsluga = function(id,hotelId){
		return $http.delete('/PutujIgumane/api/hoteli/delete/usluga/',{params: {id:id, hotelId:hotelId}});
	};
	
	factory.getSobe = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/sobe/'+hotelId);
	};
	
	factory.getSoba = function(sobaId){
		return $http.get('/PutujIgumane/api/hoteli/editSoba/'+sobaId);
	};
	
	factory.updateSoba = function(soba){
		return $http.put('/PutujIgumane/api/hoteli/updateSoba/',soba);
	};
	
	factory.addSoba = function(soba,hotelId){
		return $http.put('/PutujIgumane/api/hoteli/addSoba/'+hotelId,soba);
	};
	
	factory.deleteSoba = function(id,hotelId){
		return $http.delete('/PutujIgumane/api/hoteli/delete/soba/',{params: {id:id, hotelId:hotelId}});
	};
	
	factory.getOceneHotela = function(hotelId){
		return $http.get('/PutujIgumane/api/hoteli/ocene/hotel/'+hotelId);
	};
	
	factory.getOceneSobe = function(sobaId){
		return $http.get('/PutujIgumane/api/hoteli/ocene/soba/'+sobaId);
	};
	
	factory.getPrihode = function(hotelId,from,to) {
		return $http.get('/PutujIgumane/api/hoteli/prihodi/'+hotelId,{params: {from:from, to:to}});
	};
	
	factory.setStatuse = function(sobaId,cena,popust,from,to){
		return $http.put('/PutujIgumane/api/hoteli/setStatusi/'+sobaId,{},{params: {cena:cena, popust:popust, from:from, to:to}});
	};
	
	factory.addHotel = function(hotel){
		return $http.put('/PutujIgumane/api/hoteli/add/hotel/',hotel);
	};
	
	factory.addAdminHotel = function(admin){
		return $http.put('/PutujIgumane/api/korisnik/add/admin/hotel',admin);
	};
	
	factory.getSobeZaRez = function(hotelId,cenaFrom,cenaTo,datumFrom,datumTo,kreveti){
		return $http({
		    url: '/PutujIgumane/api/hoteli/sobe/rez/', 
		    method: "GET",
		    params: {hotelId:hotelId,cenaFrom:cenaFrom,cenaTo:cenaTo,datumFrom:datumFrom,datumTo:datumTo,kreveti:kreveti}
		 });
	};
	
	factory.getSobeBrza = function(hotelId,from,to){
		return $http.get('/PutujIgumane/api/hoteli/sobe/brza/',{params: {hotelId:hotelId, from:from, to:to}});
	};
	
	
	
	return factory;
	
});

webApp.factory('avioKompanijeFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/PutujIgumane/api/avioKompanije/');
	};
	
	factory.addAvio = function(avio){
		return $http.put('/PutujIgumane/api/aviokompanije/add/aviokompanija/',avio);
	};
	
	factory.getAvioNull = function() {
		return $http.get('/PutujIgumane/api/aviokompanije/null/a');
	};
	
	factory.addAdminAvio = function(admin){
		return $http.put('/PutujIgumane/api/korisnik/add/admin/aviokompanija',admin);
	};
	
	return factory;
	
});

webApp.factory('rentFactory', function($http) {
		
	var factory = {};	
	factory.addRentacar = function(rentacar){
		return $http.put('/PutujIgumane/api/rentacar/add/rent/',rentacar);
	};

	factory.getRentNull = function() {
		return $http.get('/PutujIgumane/api/rentacar/null/r');
	};
	
	factory.addAdminRent = function(admin){
		return $http.put('/PutujIgumane/api/korisnik/add/admin/rentacar',admin);
	};
	
	return factory;
	
});

webApp.factory('sisFactory', function($http) {
	
	var factory = {};	
	
	/*
	factory.addAdminSis = function(admin){
		return $http.put('/PutujIgumane/api/korisnik/add/admin/sistem',admin);
	};*/
	
	return factory;
	
});
