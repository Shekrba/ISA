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
      $location.path("#/");
      $scope.error = false;
      korisnikFactory.getUserData().then(function success(response){
    	 $rootScope.userData=response.data; 
    	 $log.log(response.data);
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
