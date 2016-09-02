angular.module('bibliApp', ['ngRoute']).config(function($routeProvider){
	$routeProvider.when('/mediaCreation',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	})
});