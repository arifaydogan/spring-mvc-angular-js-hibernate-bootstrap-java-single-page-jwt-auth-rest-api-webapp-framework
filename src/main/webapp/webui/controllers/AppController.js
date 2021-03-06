/**
 * Created by arifaydogan on 01/08/2016.
 */
angular.module('App')
    .controller('AppController', AppController);

AppController.$inject = ['$location', '$scope', '$rootScope', 'AuthService', 'FlashMessage'];
function AppController($location, $scope, $rootScope, AuthService, FlashMessage) {
    var app = this;
    console.log("app controller");

    app.logout = function () {
        console.log('received the logout event for user: '+$scope.currentUser.email);
        AuthService.clearCredentials();
        $location.path('/');
    };
};