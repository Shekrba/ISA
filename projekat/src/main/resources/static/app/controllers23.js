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
    		 $rootScope.avioKompanija=response.data.avioKompanija;
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

webApp.controller('navController', function($scope, $location,$window,$log,$rootScope,AuthService) {
	
	function init(){
		
	};
	
	init();
	
	$scope.logout = function() {
	      AuthService.removeJwtToken();
	      $rootScope.authenticated = false;
	      $location.path("#/");
	      for (var prop in $rootScope) {

	    	   // Check is not $rootScope default properties, functions
	    	   if (typeof $rootScope[prop] !== 'function' && prop.indexOf('$') == -1 && prop.indexOf('$$') == -1) {

	    	      delete $rootScope[prop];

	    	   }
	    	}
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

//googlemaps
webApp.config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        key: 'AIzaSyDYe0ScGgppIy_3rpGBk7SVofqRFjvir08',
        v: '3.35', //defaults to latest 3.X anyhow
        libraries: 'places' // Required for SearchBox.
    });
});


webApp.controller('avioKompanijaIzmenaController', function($rootScope,$scope, $location,$routeParams, korisnikFactory,$log,uiGmapGoogleMapApi,akFactory,uiGmapIsReady) {
	
	angular.extend($scope, {
        showingMap: {center: 
          {
            latitude: 40.1451, 
            longitude: -99.6680  
          }, 
          zoom: 4,
          events: {
              tilesloaded: function (map) {
                  $scope.$apply(function () {
                      $scope.smap=map;
                  });
              }
          },
          control:{}
        }});
	
	
	function init(){
		
    		$scope.locations=[];
		//$scope.showingMap={ control : {}, };
		
		
	};
	
	init();
		
	
	uiGmapIsReady.promise(2).then(function(instances) {
        
        var map = instances[0].map;
        var service = new google.maps.places.PlacesService(map);
        $rootScope.avioKompanija.destinacijePoslovanja.forEach(function(i,x){
        	$log.log(service);
        	service.getDetails(
        		    {placeId: i.place_id},
        		    function(results, status) {
        		    	$log.log(results);
        		    	$scope.locations.push(results);
        		    	$scope.$apply();
        		    }
        		);

   
        });
	});
	
	
	$scope.confirmEdit=function(){
		$rootScope.avioKompanija.destinacijePoslovanja=$scope.locations;
		akFactory.editAk($rootScope.avioKompanija).then(function success(response){
			toast("Uspesno izmenjeno");
			$rootScope.avioKompanija=response.data;
		});
	};
	
	$scope.showPlace=function(id){
		var map=$scope.smap;
	        var geocoder = new google.maps.Geocoder;
	        var infowindow = new google.maps.InfoWindow;

	        

	      // This function is called when the user clicks the UI button requesting
	      // a geocode of a place ID.
	   
	        var placeId = id;
	        geocoder.geocode({'placeId': placeId}, function(results, status) {
	          if (status === 'OK') {
	            if (results[0]) {
	              map.setZoom(8);
	              map.setCenter(results[0].geometry.location);
	              var marker = new google.maps.Marker({
	                map: map,
	                position: results[0].geometry.location
	              });
	              infowindow.setContent(results[0].formatted_address);
	              infowindow.open(map, marker);
	            } else {
	              toast('No results found');
	            }
	          } else {
	            toast('Geocoder failed due to: ' + status);
	          }
	        });
	}
	
	
           
 
	
	
	uiGmapGoogleMapApi.then(function(maps) {
        maps.visualRefresh = true;
        
       /* var geocoder = new google.maps.Geocoder;
		$rootScope.avioKompanija.destinacijePoslovanja.forEach(function(i){
			  var placeId = i.place_id;
		      geocoder.geocode({'placeId': placeId}, function(results, status) {
		          if (status === 'OK') {
		            if (results[0]) {
		              $log.log(results[0]);
		            } else {
		              toast('No results found');
		            }
		          } else {
		            toast('Geocoder failed due to: ' + status);
		          }
		        });
		});*/
        
       
        
        
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
            place_changed: function (searchBox) {
            	var markers = [];
            	var map=$scope.gmap;
            	var place = searchBox.getPlace();

                /*if (places.length == 0) {
                  return;
                }*/

                // Clear out the old markers.
                markers.forEach(function(marker) {
                  marker.setMap(null);
                });
                markers = [];

                // For each place, get the icon, name and location.
                var bounds = new google.maps.LatLngBounds();
                /*places.forEach(function(place) {*/
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
                  $scope.location=searchBox.getPlace();
                }
               
            //}
          },
          options: {
        	  	  autocomplete: true,
        		  types: ['(cities)']
          }
        },
        options: {
          scrollwheel: false
        }
      });
    
	$scope.addLocation= function(){
		$scope.locations.push($scope.location);
		$('.modal').modal('hide');
		
	};
	
      GoogleMapApi.then(function(maps) {
        maps.visualRefresh = true;
      });
  }]);


webApp.controller('avioKompanijaIzmenaLetovaController', function($scope, $location,$routeParams,$window,$log, korisnikFactory,$log) {
	
	function init(){
		var canvas = new fabric.Canvas('canvas');
		var canvasWidth = document.getElementById('canvas').width;
		var canvasHeight = document.getElementById('canvas').height;
		var counter = 0;
		rectLeft = 0;
		snap = 20; //Pixels to snap

		canvas.selection = false;
		

		function plusrect(top, left, width, height, fill) {
			var rect = new fabric.Rect({
				top: 300,
				name: 'rectangle ' + counter,
				left: 0 + rectLeft,
				width: 100,
				height: 100,
				fill: 'rgba(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ', 0.75)',
				lockRotation: true,
				originX: 'left',
				originY: 'top',
				cornerSize: 15,
				hasRotatingPoint: false,
				perPixelTargetFind: true,
				minScaleLimit: 1,
				maxWidth: canvasWidth,
				maxHeight: canvasHeight
			});

			rect.custom = {};
			rect.custom.counter = counter;

			canvas.add(rect);
			counter++;
			rectLeft += 200;
		}

		function findNewPos(distX, distY, target, obj) {
			// See whether to focus on X or Y axis
			if(Math.abs(distX) > Math.abs(distY)) {
				if (distX > 0) {
					target.left=(obj.left - target.width);
				} else {
					target.left=obj.left + obj.width;
				}
			} else {
				if (distY > 0) {
					target.top=obj.top - target.height;
				} else {
					target.top=obj.top + obj.height;
				}
			}
		}

		canvas.on('object:moving', function (options) {
			// Sets corner position coordinates based on current angle, width and height
			options.target.setCoords();

			// Don't allow objects off the canvas
			if(options.target.left < snap) {
				options.target.left=0;
			}

			if(options.target.top < snap) {
				options.target.top=0;
			}

			if((options.target.width + options.target.left) > (canvasWidth - snap)) {
				options.target.left=canvasWidth - options.target.width;
			}

			if((options.target.height + options.target.top) > (canvasHeight - snap)) {
				options.target.top=canvasHeight - options.target.height;
			}

			// Loop through objects
			canvas.forEachObject(function (obj) {
				if (obj === options.target) return;

				// If objects intersect
				if (options.target.isContainedWithinObject(obj) || options.target.intersectsWithObject(obj) || obj.isContainedWithinObject(options.target)) {

					var distX = ((obj.left + obj.width) / 2) - ((options.target.left + options.target.width) / 2);
					var distY = ((obj.top + obj.height) / 2) - ((options.target.top + options.target.height) / 2);

					// Set new position
					findNewPos(distX, distY, options.target, obj);
				}

				// Snap objects to each other horizontally

				// If bottom points are on same Y axis
				if(Math.abs((options.target.top + options.target.height) - (obj.top + obj.height)) < snap) {
					// Snap target BL to object BR
					if(Math.abs(options.target.left - (obj.left + obj.width)) < snap) {
						options.target.left=obj.left + obj.width;
						options.target.top=obj.top + obj.height - options.target.height;
					}

					// Snap target BR to object BL
					if(Math.abs((options.target.left + options.target.width) - obj.left) < snap) {
						options.target.left=obj.left - options.target.width;
						options.target.top=obj.top + obj.height - options.target.height;
					}
				}

				// If top points are on same Y axis
				if(Math.abs(options.target.top - obj.top) < snap) {
					// Snap target TL to object TR
					if(Math.abs(options.target.left - (obj.left + obj.width)) < snap) {
						options.target.left=obj.left + obj.width;
						options.target.top=obj.top;
					}

					// Snap target TR to object TL
					if(Math.abs((options.target.left + options.target.width) - obj.left) < snap) {
						options.target.left=obj.left - options.target.width;
						options.target.top=obj.top;
					}
				}

				// Snap objects to each other vertically

				// If right points are on same X axis
				if(Math.abs((options.target.left + options.target.width) - (obj.left + obj.width)) < snap) {
					// Snap target TR to object BR
					if(Math.abs(options.target.top - (obj.top + obj.height)) < snap) {
						options.target.left=obj.left + obj.width - options.target.width;
						options.target.top=obj.top + obj.height;
					}

					// Snap target BR to object TR
					if(Math.abs((options.target.top + options.target.height) - obj.top) < snap) {
						options.target.left=obj.left + obj.width - options.target.width;
						options.target.top=obj.top - options.target.height;
					}
				}

				// If left points are on same X axis
				if(Math.abs(options.target.left - obj.left) < snap) {
					// Snap target TL to object BL
					if(Math.abs(options.target.top - (obj.top + obj.height)) < snap) {
						options.target.left=obj.left;
						options.target.top=obj.top + obj.height;
					}

					// Snap target BL to object TL
					if(Math.abs((options.target.top + options.target.height) - obj.top) < snap) {
						options.target.left=obj.left;
						options.target.top=obj.top - options.target.height;
					}
				}
			});

			options.target.setCoords();

			// If objects still overlap

			var outerAreaLeft = null,
			outerAreaTop = null,
			outerAreaRight = null,
			outerAreaBottom = null;

			canvas.forEachObject(function (obj) {
				if (obj === options.target) return;

				if (options.target.isContainedWithinObject(obj) || options.target.intersectsWithObject(obj) || obj.isContainedWithinObject(options.target)) {

					var intersectLeft = null,
					intersectTop = null,
					intersectWidth = null,
					intersectHeight = null,
					intersectSize = null,
					targetLeft = options.target.left,
					targetRight = targetLeft + options.target.width,
					targetTop = options.target.top,
					targetBottom = targetTop + options.target.height,
					objectLeft = obj.left,
					objectRight = objectLeft + obj.width,
					objectTop = obj.top,
					objectBottom = objectTop + obj.height;

					// Find intersect information for X axis
					if(targetLeft >= objectLeft && targetLeft <= objectRight) {
						intersectLeft = targetLeft;
						intersectWidth = obj.width - (intersectLeft - objectLeft);

					} else if(objectLeft >= targetLeft && objectLeft <= targetRight) {
						intersectLeft = objectLeft;
						intersectWidth = options.target.width - (intersectLeft - targetLeft);
					}

					// Find intersect information for Y axis
					if(targetTop >= objectTop && targetTop <= objectBottom) {
						intersectTop = targetTop;
						intersectHeight = obj.height - (intersectTop - objectTop);

					} else if(objectTop >= targetTop && objectTop <= targetBottom) {
						intersectTop = objectTop;
						intersectHeight = options.target.height - (intersectTop - targetTop);
					}

					// Find intersect size (this will be 0 if objects are touching but not overlapping)
					if(intersectWidth > 0 && intersectHeight > 0) {
						intersectSize = intersectWidth * intersectHeight;
					}

					// Set outer snapping area
					if(obj.left < outerAreaLeft || outerAreaLeft == null) {
						outerAreaLeft = obj.left;
					}

					if(obj.top < outerAreaTop || outerAreaTop == null) {
						outerAreaTop = obj.top;
					}

					if((obj.left + obj.width) > outerAreaRight || outerAreaRight == null) {
						outerAreaRight = obj.left + obj.width;
					}

					if((obj.top + obj.height) > outerAreaBottom || outerAreaBottom == null) {
						outerAreaBottom = obj.top + obj.height;
					}

					// If objects are intersecting, reposition outside all shapes which touch
					if(intersectSize) {
						var distX = (outerAreaRight / 2) - ((options.target.left + options.target.width) / 2);
						var distY = (outerAreaBottom / 2) - ((options.target.top + options.target.height) / 2);

						// Set new position
						findNewPos(distX, distY, options.target, obj);
					}
				}
			});
		});

		
		$scope.canvas=canvas;
		$scope.rbr=1;
		
	};
	
	init();
	
	$scope.addSegment=function(){
		
		
		var rect = new fabric.Rect({
		  left: 0,
		  top: 0,
		  fill: 'white',
		  width: 30*$scope.columns,
		  height: 30*$scope.rows,
		  originX: 'center',
		  originY: 'center'
		});
		
		/*$scope.rbr="1";
		
		var text = new fabric.Text($scope.rbr, { 
			 
			  left: 15*$scope.columns, 
			  top: 15*$scope.rows
			});
		
		
		*/
		
		
		var t1 = new fabric.Textbox($scope.rbr.toString(), {
			height: 30*$scope.rows,
		    width: 20*$scope.columns,
		    top: 0,
		    left: 0,
		    fontSize: 16,
		    textAlign: 'center',
		    backgroundColor: 'white',
		    editable: false, 
		    cursorWidth: 0,
		    originX: 'center',
			originY: 'center'
		});
		
		var group=new fabric.Group([rect,t1],{top:0,left:0});
		
		group.lockScalingX=true;
		group.lockScalingY=true;
		group.lockUniScaling=true;
		group.lockRotation=true;
		
		var flag=true;
		obj = $scope.canvas._objects;
		if(obj!=undefined){
			
			obj.forEach(function(i,x) {
					
					if (i.top<30*$scope.rows && i.left<30*$scope.columns){
						flag=false;
						toast("Postavite prvo poziciju proslog segmenta!");
						return;
					}
			});
		}
		if(flag){
			$scope.canvas.add(group);
			$scope.rbr++;
		}
		
		//$scope.$apply();
	};
	
});

