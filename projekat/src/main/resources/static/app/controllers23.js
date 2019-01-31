webApp.controller('loginController', ['$scope', '$rootScope', '$http', '$location', 'AuthService','korisnikFactory','$log',
  function($scope, $rootScope, $http, $location, authService,korisnikFactory,$log) {
  $scope.error = false;
  $rootScope.selectedTab = $location.path() || '/';

  $scope.credentials = {};

  $scope.login = function() {
    // We are using formLogin in our backend, so here we need to serialize our form data
    $http({
      url: 'auth/login',
      method: 'POST',
      data: $scope.credentials,
      headers: authService.createAuthorizationTokenHeader()
    })
    .success(function(res) {
      $rootScope.authenticated = true;
      authService.setJwtToken(res.accessToken);
     
      $scope.error = false;
      korisnikFactory.getUserData().then(function success(response){
    	 $rootScope.userData=response.data; 
    	 $log.log(response.data);
    	 if(response.data.avioKompanija!=undefined){
    		 $location.path("/izmena/ak"); 
    	 };
      });
    })
    .catch(function() {
      authService.removeJwtToken();
      $rootScope.authenticated = false;
      $scope.error = true;
    });
  };
}]);

webApp.controller('navController', function($scope, $location,$rootScope,AuthService) {
	
	function init(){
		
	};
	
	init();
	
	$scope.logout = function() {
	      AuthService.removeJwtToken();
	      $rootScope.authenticated = false;
	      $location.path("#/");
	}
	
	$scope.searchUsers = function(name){
		var replaced = name.split(' ').join('+');
		$location.path("/users/"+replaced);
	}
});

webApp.controller('pretragaKorisnikaController', function($scope, $location,$routeParams, korisnikFactory,$log) {
	
	function init(){
		korisnikFactory.getFriendsAndRequests().then(function success(response){
			$scope.friendships=response.data;
			korisnikFactory.searchUsers($routeParams.name,1).then(function success(response){
				$scope.korisnici=response.data;
				$scope.buttonText={};
				$scope.sent={};
				for(let k of $scope.korisnici){
					$log.log($scope.friendships);
					if($scope.friendships.includes(k.id)){
						$scope.buttonText[k.id]="Prijatelj ili čekate na odgovor";
						$scope.sent[k.id]=true;
					}else{
						$scope.buttonText[k.id]="Dodaj za prijatelja";
						$scope.sent[k.id]=false;
					}
				}
			},function error(response){
				
			});
		});
		
	};
	
	init();
	
	$scope.addFriend = function(id){
		korisnikFactory.addFriend(id).then(function success(response){
			toast(response.data);
			$scope.buttonText[id]="Prijatelj ili čekate na odgovor";
			$scope.sent[id]=true;
		}, function error(response){
			toast(response.data);
		});
	}
});

webApp.controller('zahteviController', function($scope, $location,$routeParams, korisnikFactory,$log) {
	
	function init(){
		korisnikFactory.getFriendRequests().then(function success(response){
			$scope.zahtevi=response.data;
		});
		
	};
	
	init();
	
	
});

webApp.controller('avioKompanijaIzmenaController', function($scope, $location,$routeParams, korisnikFactory,$log) {
	
	function init(){
		$scope.locations=[];
	};
	
	init();
	
	
});

//googlemaps
webApp.config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        key: 'AIzaSyDYe0ScGgppIy_3rpGBk7SVofqRFjvir08',
        v: '3.20', //defaults to latest 3.X anyhow
        libraries: 'places' // Required for SearchBox.
    });
});

webApp.controller('gmapsController', ['$scope', '$log', 'uiGmapGoogleMapApi', function ($scope, $log, GoogleMapApi) {
	angular.extend($scope, {
        map: {center: 
          {
            latitude: 40.1451, 
            longitude: -99.6680  
          }, 
          zoom: 4,
          events: {
              tilesloaded: function (map) {
                  $scope.$apply(function () {
                      $scope.gmap=map;
                  });
              }
          }
        },
        searchbox: { 
          template:'searchbox.tpl.html', 
          events:{
            places_changed: function (searchBox) {
            	var markers = [];
            	var map=$scope.gmap;
            	var places = searchBox.getPlaces();

                if (places.length == 0) {
                  return;
                }

                // Clear out the old markers.
                markers.forEach(function(marker) {
                  marker.setMap(null);
                });
                markers = [];

                // For each place, get the icon, name and location.
                var bounds = new google.maps.LatLngBounds();
                places.forEach(function(place) {
                  if (!place.geometry) {
                    console.log("Returned place contains no geometry");
                    return;
                  }
                  var icon = {
                    url: place.icon,
                    size: new google.maps.Size(71, 71),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(25, 25)
                  };

                  // Create a marker for each place.
                  markers.push(new google.maps.Marker({
                    map: map,
                    icon: icon,
                    title: place.name,
                    position: place.geometry.location
                  }));

                  if (place.geometry.viewport) {
                    // Only geocodes have viewport.
                    bounds.union(place.geometry.viewport);
                  } else {
                    bounds.extend(place.geometry.location);
                  }
                  map.fitBounds(bounds);
                  $scope.location=searchBox.getPlaces()[0];
                });
               
            }
          }
        },
        options: {
          scrollwheel: false
        }
      });
    
	$scope.addLocation= function(){
		$scope.locations.push($scope.location);
		$('.modal').modal('hide');
	}
	
      GoogleMapApi.then(function(maps) {
        maps.visualRefresh = true;
      });
  }]);