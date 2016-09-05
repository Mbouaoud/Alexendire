angular.module('bibliApp')
.controller('LoginCtrl', function($scope, $location, Authentification, $rootScope) {
	$rootScope.typePage='L';
	var req = "0";
	$scope.validLogin = function(){
		if($scope.formLogin.$valid){
			Authentification.connexion($scope.user, $scope.password).then(function(response){
				if (response===true) {
					$location.url("/home/" ); 
				}else {
					console.log('Connexion invalide !!!')
					req = "1";
				}
				
			});
		} else {
			req = "2";
			console.log('Form invalide !!!')
		}
	}
	$scope.required = function(){
		if(req=="2") return "Merci de remplir les conditions nécessaires pour vous connecter !";
		if(req=="1") return "Login ou mot de passe invalide"; 
	}
});