angular.module('bibliApp', ['ngRoute', 'ngMessages', 'ngCookies']).config(function($routeProvider, UrlServiceProvider){
	$routeProvider.when('/home',{
		templateUrl:'html/bibliApp/media/home.html',
		controller:'HomeCtrl'
	});	
		
	$routeProvider.when('/adherentRecherche', {
			templateUrl : 'html/bibliApp/adherent/adherentRecherche.html',
			controller: 'AdherentRechercheCtrl'
	});

	$routeProvider.when('/mediaCreation/:idMedia',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	});
	
	$routeProvider.when('/mediaCreation',{
		templateUrl: '/html/bibliApp/media/mediaCreation.html',
		controller: 'MediaCreationCtrl'
	});

	$routeProvider.when('/adherentCreation/:idAdherent',{
		templateUrl: '/html/bibliApp/adherent/adherentCreation.html',
		controller: 'AdherentCreationCtrl',
		params: {
			name : 'idAdherent'
		}
	});

	$routeProvider.when('/adherentCreation',{
		templateUrl: '/html/bibliApp/adherent/adherentCreation.html',
		controller: 'AdherentCreationCtrl'
	});
	
	$routeProvider.when('/mediaVisualisation/:idMedia',{
		templateUrl: '/html/bibliApp/media/mediaVisualisation.html',
		controller: 'MediaVisualisationCtrl'
	});

	$routeProvider.when('/adherentVisualisation/:idAdherent',{
		templateUrl: '/html/bibliApp/adherent/adherentVisualisation.html',
		controller: 'AdherentVisualisationCtrl',
			params: {
				name : 'idAdherent'
			}
	});

//	$routeProvider.when('/login', {
//		templateUrl : 'html/login/login.html',
//		controller: 'LoginCtrl'
//	});
	
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
	
	UrlServiceProvider.setDefaut('http', '192.168.10.41', '8090');

});