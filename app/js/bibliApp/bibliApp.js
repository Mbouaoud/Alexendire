angular
	.module('bibliApp', ['ngRoute'])
	
	.config(function($routeProvider){
		$routeProvider.when('/home',{
			templateUrl:'html/bibliApp/media/home.html',
			controller:'HomeCtrl'
		});

	
});