angular.module('bibliApp', ['ngRoute']).config(function($routeProvider){


	$routeProvider.when('/login', {
		templateUrl : 'html/login/login.html',
			controller: 'LoginCtrl'
	
	});

	$routeProvider.when('/mediaCreation',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	});
	
	$routeProvider.otherwise({
		redirectTo : '/login'
	});
});
