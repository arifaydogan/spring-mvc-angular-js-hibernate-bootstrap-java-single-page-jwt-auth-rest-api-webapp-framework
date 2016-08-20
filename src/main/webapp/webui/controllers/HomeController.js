/**
 * Created by arifaydogan on 01/08/2016.
 */
angular.module('App')
    .controller('HomeController', HomeController);

function HomeController($scope, $location) {
    var home = this;
    home.currentUser = null;
};