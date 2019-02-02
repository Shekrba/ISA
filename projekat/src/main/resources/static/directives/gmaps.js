webApp.directive('editkeyvalue', function() {
    return {
        restrict: 'E',
        replace: true,
        scope: {
            key: '=',
            value: '=',
            accept: "&"
        },
        template : '<div><label class="control-label">{{key}}</label>' +
        '<label class="control-label">{{key}}</label>' +
          '<input type="text" ng-model="value" />'+
        '<button type="button" x-ng-click="cancel()">CANCEL</button>' +
        '<button type="submit" x-ng-click="save()">SAVE</button></div>',

      controller: function($scope, $element, $attrs, $location) {        
        $scope.save= function() {
          console.log('from directive', $scope.key, $scope.value);    
          $scope.accept()
        };
      }
    }
});