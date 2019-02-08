webApp.controller('loginController', ['$scope', '$rootScope', '$http', '$location', 'AuthService','korisnikFactory','$log',
  function($scope, $rootScope, $http, $location, authService,korisnikFactory,$log) {
  $scope.error = false;
  $rootScope.selectedTab = $location.path() || '/';

  $scope.credentials = {};

  $scope.login = function() {
    // We are using formLogin in our backend, so here we need to serialize our form data
	  $location.path("/");
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
    	 if(response.data.hotel!=undefined){
    		 $rootScope.hotel=response.data.hotel;
    		 $log.log($rootScope.hotel);
    		 $location.path("/hoteli/editHotel/"+response.data.hotel.id); 
    	 };
    	 if(response.data.rentacar!=undefined){
    		 $rootScope.rentacar=response.data.rentacar;
    		 $location.path("/rentacar/editRentacar/"+response.data.rentacar.id); 
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
	
	$scope.confirmRequest=function(id){
		korisnikFactory.answerFriend(id,true).then(function success(response){
			toast(response.data);
		});
	};
	
	$scope.declineRequest=function(id){
		korisnikFactory.answerFriend(id,false).then(function success(response){
			toast(response.data);
		});
	}
	
	
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
		
    		$rootScope.locations=[];
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
        		    	$rootScope.locations.push(results);
        		    	$rootScope.$apply();
        		    }
        		);

   
        });
	});
	
	
	$scope.confirmEdit=function(){
		$rootScope.avioKompanija.destinacijePoslovanja=$rootScope.locations;
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



webApp.controller('gmapsController', ['$scope', '$log', 'uiGmapGoogleMapApi','$rootScope', function ($scope, $log, GoogleMapApi,$rootScope) {
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
		$rootScope.locations.push($scope.location);
		$('.modal').modal('hide');
		
	};
	
      GoogleMapApi.then(function(maps) {
        maps.visualRefresh = true;
      });
  }]);



webApp.filter('range', function() {
	  return function(input, total) {
	    total = parseInt(total);

	    for (var i=0; i<total; i++) {
	      input.push(i);
	    }

	    return input;
	  };
	});


webApp.controller('avioKompanijaNoviLetController', function($scope,$rootScope, $location,$routeParams,$window,$log, korisnikFactory,$log,akFactory) {
	
	function init(){
		akFactory.getNewFlight().then(function success(response){
			$scope.flight=response.data;
			$scope.cities=$rootScope.locations.slice();
			$scope.flight.presedanja.push({name:"Izaberi"});
			$scope.flight.presedanja.push({name:"Izaberi"});
			$log.log($scope.flight);
		});
		
		var canvas = new fabric.Canvas('canvas');
		var canvasWidth = document.getElementById('canvas').width;
		var canvasHeight = document.getElementById('canvas').height;
		var counter = 0;
		rectLeft = 0;
		snap = 20; //Pixels to snap

		canvas.selection = false;
		

		

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
		$scope.discount=0;
		
		
	};
	
	init();
	
	$scope.addStart=function(x){
		$scope.flight.presedanja[0]=x;
	};
	
	$scope.addPresedanje=function(){
		$scope.flight.presedanja.splice($scope.flight.presedanja.length-2, 0, {name:"Izaberi"});
	};
	
	$scope.selectPresedanje=function(x,i){
		$scope.flight.presedanja[i]=x;
		//$scope.$apply();
	};
	
	$scope.addFinish=function(x){
		$scope.flight.presedanja[$scope.flight.presedanja.length - 1]=x;
	};
	
	$scope.addSegment=function(){
		
		if($scope.discount>0)
			$scope.color='yellow';
		else
			$scope.color='white';
		
		
		var rect = new fabric.Rect({
		  left: 0,
		  top: 0,
		  fill: $scope.color,
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
		
		
		var t1 = new fabric.Textbox($scope.rbr.toString()+"\n"+$scope.rows+"x"+$scope.columns, {
			height: 30*$scope.rows,
		    width: 20*$scope.columns,
		    top: 0,
		    left: 0,
		    fontSize: 16,
		    textAlign: 'center',
		    backgroundColor: $scope.color,
		    editable: false, 
		    cursorWidth: 0,
		    originX: 'center',
			originY: 'center'
		});
		
		var group=new fabric.Group([rect,t1],{top:0,left:0,
			  redovi: $scope.rows,
			  kolone: $scope.columns,
			  cena: $scope.price,
			  popust: $scope.discount,
			  rbr:$scope.rbr});
		
		group.on('mousedown',function(){
			$scope.rowsMod=this.redovi;
			$scope.columnsMod=this.kolone;
			$scope.priceMod=this.cena;
			$scope.discountMod=this.popust;
			$scope.$apply();
		});
		
		group.lockScalingX=true;
		group.lockScalingY=true;
		group.lockUniScaling=true;
		group.lockRotation=true;
		
		var flag=true;
		var obj = $scope.canvas._objects;
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
		
		
		
		
	};
	
	$scope.addFlight=function(){
		var obj = $scope.canvas._objects;
		if(obj!=undefined){
			obj.forEach(function(i,x) {
				var segment={'id':null,'rbr':x,'cena':100,'x':i.left,'y':i.top,'redovi':i.redovi,'kolone':i.kolone,'popust':i.popust};
				$scope.flight.segmenti[x]=segment;
			});
		}
		akFactory.addFlight($rootScope.avioKompanija.id,$scope.flight).then(function success(response){
			toast(response.data);
		});
	};
	
	$scope.editSegment=function(){
		
		if($scope.discountMod>0)
			$scope.color='yellow';
		else
			$scope.color='white';
		
		var activeObj=$scope.canvas._activeObject;
		
		var rect = new fabric.Rect({
			  left: activeObj._objects[0].left,
			  top: activeObj._objects[0].top,
			  fill: $scope.color,
			  width: 30*$scope.columnsMod,
			  height: 30*$scope.rowsMod,
			  originX: 'center',
			  originY: 'center'
			});
		
		var t1 = new fabric.Textbox(activeObj.rbr.toString()+"\n"+$scope.rowsMod+"x"+$scope.columnsMod, {
			height: 30*$scope.rowsMod,
		    width: 20*$scope.columnsMod,
		    top: activeObj._objects[1].top,
		    left: activeObj._objects[1].left,
		    fontSize: 16,
		    textAlign: 'center',
		    backgroundColor: $scope.color,
		    editable: false, 
		    cursorWidth: 0,
		    originX: 'center',
			originY: 'center'
		});
		var group=new fabric.Group([rect,t1],{top:activeObj.top,left:activeObj.left,
			  redovi: $scope.rowsMod,
			  kolone: $scope.columnsMod,
			  cena: $scope.priceMod,
			  popust: $scope.discountMod,
			  rbr:activeObj.rbr});
		
		group.on('mousedown',function(){
			$scope.rowsMod=this.redovi;
			$scope.columnsMod=this.kolone;
			$scope.priceMod=this.cena;
			$scope.discountMod=this.popust;
			$scope.$apply();
		});
		
		group.lockScalingX=true;
		group.lockScalingY=true;
		group.lockUniScaling=true;
		group.lockRotation=true;
		$scope.canvas.remove($scope.canvas._activeObject);
		$scope.canvas.add(group);
		$scope.canvas.setActiveObject(group);
	};
	
});


webApp.controller('avioKompanijaIzmenaLetovaController', function($scope,$rootScope, $location,$routeParams, akFactory,$log) {
	
	function init(){
		akFactory.getAllAKFlights($rootScope.avioKompanija.id).then(function success(response){
			$scope.letovi=response.data;
		});
		
	};
	
	init();
	
	$scope.formatDate=function(d){
		var date=new Date(d);
		return date.toLocaleString("sr-RS");
	};
	
});

webApp.controller('pretragaLetovaController', function($scope,$rootScope, $location,$routeParams, akFactory,$log) {
	
	function init(){
		akFactory.getAllFlights().then(function success(response){
			$scope.letovi=response.data;
		});
		
	};
	
	init();
	
	$scope.formatDate=function(d){
		return d.toLocaleString("sr-RS");
	};
	
	$scope.reserveFlight=function(id){
		$rootScope.putanja='partials/letRezervacija.html';
		$rootScope.flightid=id;
	};
});

webApp.controller('rezervacijaLetaController', function($scope,$rootScope, $location,$routeParams, akFactory,korisnikFactory,$log) {
	
	function init(){
		korisnikFactory.getFriends().then(function success(response1){
			akFactory.getFlight($rootScope.flightid).then(function success(response){
				$scope.friends=response1.data;
				$rootScope.drugariSaPuta={};
				$scope.flight=response.data;
				$scope.oznSedista={};
				$scope.numOzn=0;
				var canvas = new fabric.Canvas('canvas',{  hoverCursor: 'pointer', selection: false });
				
				canvas.selection=false;
				
				$scope.flight.segmenti.forEach(function(s,i){
					if(s.popust>0)
						$scope.color='yellow';
					else
						$scope.color='white';
					
					var group=new fabric.Group([],{top:300,left:300});
					
					group.lockScalingX=true;
					group.lockScalingY=true;
					group.lockUniScaling=true;
					group.lockRotation=true;
					group.lockMovementX=true;
					group.lockMovementY=true;
					
					
			
					var col=s.kolone;
					var row=s.redovi;
					sedista=s.sedista;
					function compare(a, b) {
						  // Use toUpperCase() to ignore character casing
						  const genreA = a.rbr;
						  const genreB = b.rbr;

						  let comparison = 0;
						  if (genreA > genreB) {
						    comparison = 1;
						  } else if (genreA < genreB) {
						    comparison = -1;
						  }
						  return comparison;
						};
					sedista.sort(compare);
					for(var x=0 ; x<row ; x++){
						for(var y=0 ; y<col ; y++){
							var sed=sedista[x*col+y];
							var rect=new fabric.Rect({
								  left: 0,
								  top: 0,
								  fill: $scope.color,
								  width: 30,
								  height: 30,
								  originX: 'center',
								  originY: 'center',
								  id: sed.id
							});
							var t1 = new fabric.Textbox(sed.rbr.toString(), {
								height: 30,
							    width: 20,
							    top: 0,
							    left: 0,
							    fontSize: 12,
							    textAlign: 'center',
							    backgroundColor: $scope.color,
							    editable: false, 
							    cursorWidth: 0,
							    originX: 'center',
								originY: 'center'
							});
							var group1=new fabric.Group([rect,t1],{top:s.y+x*30,left:s.x+y*30,sediste:sed});
							group1.lockScalingX=true;
							group1.lockScalingY=true;
							group1.lockUniScaling=true;
							group1.lockRotation=true;
							group1.lockMovementX=true;
							group1.lockMovementY=true;
							
							group1.selectable=false;
							
							group1.on('mousedown',function(){
								if(this._objects[0].fill!='yellow'){
									if(this._objects[0].fill=='white'){
										this._objects[0].set('fill','green');
										this._objects[1].set('backgroundColor','green');
										$scope.numOzn++;
										$scope.oznSedista[this.sediste.id]=this.sediste;
										if($scope.numOzn>=2){
											$rootScope.drugariSaPuta[$scope.numOzn-2]={ime:"",prezime:""};
										}
										$scope.$apply();	
										//$scope.$apply();
									}else{
										this._objects[0].set('fill','white');
										this._objects[1].set('backgroundColor','white');
										delete $scope.oznSedista[this.sediste.id];
										$scope.numOzn--;
										delete $scope.oznSedista[this.sediste.id];
										if($scope.numOzn>=2){
											delete $rootScope.drugariSaPuta[$scope.numOzn-1];
										}
										$scope.$apply();
										
									}
								}else if(this._objects[0].fill!='yellow'=='red'){
									toast('Sediste je zauzeto!');
								}else{
									toast('Ova sedista su za brzu rezervaciju!');
								}
							});
							canvas.add(group1);
							
					}
				}
					
					//group.left=s.x;
					//group.top=s.y;
					//$log.log(group);
					//canvas.add(group);
					//$scope.$apply();
					
				});
				$scope.canvas=canvas;
				
			});
		});
		
		
	};
	
	init();
	

	$scope.setSel=function(x){
		$scope.i=x;
	};
	
	$scope.setFriend=function(f){
		$rootScope.drugariSaPuta[$scope.i]=f;
	};
	
	$scope.rezervisiLet=function(){
		for(let i=0 ; i<$scope.numOzn-1 ; i++){
			if($rootScope.drugariSaPuta[i].username!=undefined){
				//broj karata!!! NEREGISTROVANI KORISNICI
				$rootScope.rezervacija.korisnici.push($rootScope.drugariSaPuta[i]);
			}
		}
		
		for(var key in $scope.oznSedista){
			$rootScope.rezervacija.karte.push($scope.oznSedista[key]);
		}
		
		$log.log($rootScope.rezervacija);
		
		$scope.karte
		
		$rootScope.datumDolaska=$scope.flight.vremePoletanja;
		
		$rootScope.putanja='partials/biranjeRezervacijaHotela.html';
		
		$rootScope.letClass = 'nav-link disabled';
		
		$rootScope.hotelClass = 'nav-link active';
		
		$rootScope.rentClass = 'nav-link disabled';
	};
});

webApp.controller('prijateljiController', function($scope,$rootScope, korisnikFactory) {
	
	function init(){
		korisnikFactory.getFriends().then(function success(response){
			$scope.korisnici=response.data;
		});
		
	};
	
	init();
	
});


