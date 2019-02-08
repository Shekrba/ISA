webApp.factory('AuthService', function($http) {
	var user = null;
	var TOKEN_KEY = 'jwtToken';

  var getJwtToken = function() {
    return localStorage.getItem(TOKEN_KEY);
  };

  var setJwtToken = function(token) {
      localStorage.setItem(TOKEN_KEY, token);
  };

  var removeJwtToken = function() {
      localStorage.removeItem(TOKEN_KEY);
  };

  var createAuthorizationTokenHeader = function() {
      var token = getJwtToken();
      if (token) {
          return {
            "Authorization": "Bearer " + token,
            'Content-Type': 'application/json'
          };
      } else {
          return {
            'Content-Type': 'application/json'
          };
      }
  }

  var getUser = function() {
    return $http({
      headers: createAuthorizationTokenHeader(),
      method: 'GET',
      url: 'api/whoami'
    });
  };

  return {
    getUser: getUser,
    getJwtToken: getJwtToken,
    setJwtToken: setJwtToken,
    removeJwtToken: removeJwtToken,
    createAuthorizationTokenHeader: createAuthorizationTokenHeader
  };
});


webApp.factory('httpRequestInterceptor', function () {
	  return {
	    request: function (config) {
	    	var TOKEN_KEY = 'jwtToken';

	    	  var getJwtToken = function() {
	    	    return localStorage.getItem(TOKEN_KEY);
	    	  };
	      var token = getJwtToken();
	      if (token) {	
	    	  config.headers['Authorization'] = "Bearer " + token,
	    	  config.headers['Content-Type'] = 'application/json';
	      }
	      return config;
	    }
	  };
});


webApp.config(function ($httpProvider) {
	  $httpProvider.interceptors.push('httpRequestInterceptor');
	});



webApp.factory('korisnikFactory', function($http) {
	
	var factory = {};
	factory.searchUsers = function(name,page) {
		return $http.get('/PutujIgumane/api/korisnik/search',{params:{name:name,page:page}});
	};
	factory.addFriend = function(id) {
		return $http.post('/PutujIgumane/api/korisnik/friend/'+id);
	};
	factory.getFriendsAndRequests = function() {
		return $http.get('/PutujIgumane/api/korisnik/friendship');
	};
	factory.getFriendRequests = function() {
		return $http.get('/PutujIgumane/api/korisnik/requests');
	};
	factory.getUserData = function() {
		return $http.get('/PutujIgumane/api/korisnik/data');
	};
	factory.answerFriend = function(id,flag) {
		return $http.put('/PutujIgumane/api/korisnik/answer/request',{},              
		          { params: { id: id, flag : flag } } );
	};
	factory.getFriends = function() {
		return $http.get('/PutujIgumane/api/korisnik/friends/all');
	};
	
	return factory;
	
});

webApp.factory('akFactory', function($http) {
	
	var factory = {};
	factory.editAk = function(ak) {
		return $http.put('/PutujIgumane/api/aviokompanije/edit',ak);
	};
	factory.getNewFlight = function() {
		return $http.get('/PutujIgumane/api/aviokompanije/new/flight');
	};
	factory.addFlight = function(id,flight) {
		return $http.post('/PutujIgumane/api/aviokompanije/add/flight/'+id,flight);
	};
	factory.getAllAKFlights = function(id) {
		return $http.get('/PutujIgumane/api/aviokompanije/flights/'+id);
	};
	factory.getAllFlights = function() {
		return $http.get('/PutujIgumane/api/aviokompanije/flights');
	};
	factory.getFlight = function(id) {
		return $http.get('/PutujIgumane/api/aviokompanije/flight/'+id);
	};
	factory.getKarteBrza = function() {
		return $http.get('/PutujIgumane/api/aviokompanije/karte/brza');
	};
	factory.getOceneAK = function(akId){
		return $http.get('/PutujIgumane/api/aviokompanije/ocene/ak/'+hotelId);
	};

	factory.getOceneLet = function(letId){
		return $http.get('/PutujIgumane/api/aviokompanije/ocene/let/'+letId);
	};
	
	return factory;
	
});

