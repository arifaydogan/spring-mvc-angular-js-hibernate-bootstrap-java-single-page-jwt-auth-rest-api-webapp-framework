/**
 * Created by arifaydogan on 01/08/2016.
 */
angular.module('App.Admin')
    .controller('AdminController', ['$rootScope', '$location', AdminController]);

function AdminController($rootScope, $location) {
    var admin = this;
    admin.currentUser = null;
};