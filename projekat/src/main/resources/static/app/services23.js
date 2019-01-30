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
	
	return factory;
	
});