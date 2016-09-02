angular.module('bibliApp')
.controller('LoginCtrl', function($scope, $location, Authentification) {
	$scope.validLogin = function(){
		if($scope.formLogin.$valid){
			Authentification.connexion($scope.user, $scope.password).then(function(response){
				if (response===true) {
					$location.url("/home/" + "?" + $scope.user); 
				}else {
					console.log('Connexion invalide !!!')
					// erreur partie
				}
				
			});
		} else {
			console.log('Form invalide !!!')
		}
	}
});