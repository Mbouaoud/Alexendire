angular
	.module('bibliApp', ['ngRoute']).config(function($routeProvider){
		
	$routeProvider.when('/home',{
			templateUrl:'html/bibliApp/media/home.html',
			controller:'HomeCtrl'
	});

	$routeProvider.when('/mediaCreation',{
	templateUrl: '/html/bibliApp/media/mediaCreation.html',
	controller: 'MediaCreationCtrl'
	});

	$routeProvider.when('/login', {
	templateUrl : 'html/login/login.html',
	controller: 'LoginCtrl'
	});
	
	$routeProvider.otherwise({
		redirectTo : '/login'
	});

});
	


