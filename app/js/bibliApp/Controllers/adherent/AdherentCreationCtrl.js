angular.module('bibliApp').controller('AdherentCreationCtrl', function($scope, $rootScope, $filter, AdherentCreationService){
	
	var adherent = {};
	var click = false;
	
	$scope.add = false;
	$scope.fail = false;
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
		click = true;
		if($scope.adcrForm.$valid){
			adherent = {
				nom : $scope.adhNom,
				prenom: $scope.adhPrenom,
				date_naissance: $filter('date')($scope.adhNaissance, "yyyy-MM-dd"),
				email : $scope.adhEmail,
				adresse : {
					ligne1 : $scope.adhAdresse,
					ligne2 : '',
					codepostal : $scope.adhCp,
					ville : $scope.adhVille
				},
				cotisation : {
					debut : $filter('date')($scope.adhCotisation, "yyyy-MM-dd"),
					montant : $scope.adhCotisationMontant
				}
			};
			
			console.log(adherent);
			
			AdherentCreationService.addAdherent(adherent).then(function(result){
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
				$scope.fail = false;
			},function(error){
				$scope.fail = true;
			});
		}
	};
	
	$scope.validationForm = function(){
		if(click==true) return true;
	}
	
	
});