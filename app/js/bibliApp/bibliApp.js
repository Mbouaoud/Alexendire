angular.module('bibliApp', ['ngRoute']).config(function($routeProvider){
	$routeProvider.when('/home',{
		templateUrl:'html/bibliApp/media/home.html',
		controller:'HomeCtrl'
	});
	
	$routeProvider.when('/mediaCreation',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	});
	
	$routeProvider.when('/adherentCreation',{
		templateUrl: '/html/bibliApp/adherent/adherentCreation.html',
		controller: 'AdherentCreationCtrl'
	});
	
	$routeProvider.when('/login', {
		templateUrl : 'html/login/login.html',
		controller: 'LoginCtrl'
	});
});