angular.module('bibliApp').controller('AdherentCreationCtrl', function($scope, $rootScope, $filter){
	
	var adherent = [];
	$scope.add = false;
	$rootScope.typePage='AC';
	
	$scope.FinAbonnement = function(dateAbo){
		var temp = null;
		
		if(dateAbo != null){
			var temp = angular.copy(dateAbo);
			temp.setFullYear(temp.getFullYear()+1);
		}
		
		return temp;
	};
	
	$scope.AgeAbonne = function(dateNaissance){
		var now = new Date();
		var age = null;
		
		if(dateNaissance != null){
			if(now.getMonth() >= dateNaissance.getMonth()){
				age = now.getFullYear() - dateNaissance.getFullYear();
			}else{
				age = (now.getFullYear() - dateNaissance.getFullYear()) - 1;
			}
		}
		
		return age;
	};
		
	$scope.addAdherent = function(){
		adherent.push({
			nom : $scope.adhNom,
			prenom: $scope.adhPrenom,
			dateNaissance: $filter('date')($scope.adhNaissance, "yyyy-MM-dd"),
			email : $scope.adhEmail,
			adresse : $scope.adhAdresse,
			cp : $scope.adhCp,
			ville : $scope.adhVille,
			cotisation : $filter('date')($scope.adhCotisation, "yyyy-MM-dd"),
			cotisationMontant : $scope.adhCotisationMontant
		});
		
		$scope.addedNom = $scope.adhNom;
		$scope.addedPrenom = $scope.adhPrenom;

		$scope.add = true;
		$scope.adhNom = "";
		$scope.adhPrenom = "";
		$scope.adhNaissance = undefined;
		$scope.adhEmail = "";
		$scope.adhAdresse = "";
		$scope.adhCp = "";
		$scope.adhVille = "";
		$scope.adhCotisation = undefined;
		$scope.adhCotisationMontant = "";
			
		console.log(adherent);
	};
});