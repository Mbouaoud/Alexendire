angular.module('bibliApp', ['ngRoute']).config(function($routeProvider){

$routeProvider.when('/login', {
	templateUrl : 'html/login/login.html',
		controller: 'LoginCtrl'
});

});
