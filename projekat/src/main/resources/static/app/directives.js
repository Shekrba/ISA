webApp.directive('restaurantItems', function() {
        return {
            restrict: 'E',
            templateUrl: 'directives/restaurantItems.html'
        };
});

webApp.directive('menu', function() {
    return {
        restrict: 'E',
        templateUrl: 'directives/menu.html'
    };
});