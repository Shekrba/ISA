webApp.controller('loginController', ['$scope', '$rootScope', '$http', '$location', 'AuthService',
  function($scope, $rootScope, $http, $location, authService) {
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

webApp.controller('pretragaKorisnikaController', function($scope, $location,$routeParams, korisnikFactory) {
	
	function init(){
		korisnikFactory.searchUsers($routeParams.name,1).then(function success(response){
			$scope.korisnici=response.data;
		},function error(response){
			
		});
	};
	
	init();
	
});
