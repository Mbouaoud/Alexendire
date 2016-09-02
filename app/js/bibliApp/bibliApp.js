angular
	.module('bibliApp', ['ngRoute', 'ngMessages']).config(function($routeProvider){
		
	$routeProvider.when('/home',{
			templateUrl:'html/bibliApp/media/home.html',
			controller:'HomeCtrl'
	});		
		
	$routeProvider.when('/adherentRecherche', {
			templateUrl : 'html/bibliApp/adherent/adherent_recherche.html',
			controller: 'AdherentRechercheCtrl'
	});

	$routeProvider.when('/mediaCreation',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	});

	$routeProvider.when('/mediaVisualisation',{
		templateUrl: '/html/bibliApp/media/mediaVisualisation.html',
		controller: 'MediaVisualisationCtrl'
	});

	$routeProvider.when('/adherentVisualisation',{
		templateUrl: '/html/bibliApp/adherent/adherentVisualisation.html',
		controller: 'AdherentVisualisationCtrl'
	});

	$routeProvider.when('/login', {
		templateUrl : 'html/login/login.html',
		controller: 'LoginCtrl'
	});
	
	$routeProvider.otherwise({
		redirectTo : '/login'
	});

});
	


