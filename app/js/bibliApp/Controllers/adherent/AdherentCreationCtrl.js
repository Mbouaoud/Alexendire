angular.module('bibliApp').controller('AdherentCreationCtrl', function($scope, $rootScope, $filter, $http, $routeParams, AdherentCreationService){
	
	var adherent = {};
	$scope.add = false;
	$scope.failAdd = false;
	$scope.modif = false;
	$scope.failModif = false;
	$scope.makeModif = false;
	
	$rootScope.typePage='AC';
	
	if ($routeParams.idAdherent) {
		$http.get('http://192.168.10.41:8090/resource/adherent.accession', {params : {id : $routeParams.idAdherent}})
			.then(function(response) {
				$scope.adhId = response.data.id;
				$scope.adhNom = response.data.nom;
				$scope.adhPrenom = response.data.prenom;
				$scope.adhNaissance = new Date(response.data.date_naissance);
				$scope.adhEmail = response.data.email;
				$scope.adhAdresse = response.data.adresse.ligne1 + " " + response.data.adresse.ligne2;
				$scope.adhCp = response.data.adresse.codepostal;
				$scope.adhVille = response.data.adresse.ville;
				$scope.adhCotisation = new Date(response.data.cotisation.debut);
				$scope.adhCotisationMontant = response.data.cotisation.montant;
				
				$scope.emprunt = response.data.emprunt;
				
				$scope.makeModif = true;
		});
	};
	
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
		if ($scope.makeModif) {
			adherent = {
				id : $scope.adhId,
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
				},
				emprunt : $scope.emprunt
			};
			
			$scope.failAdd = false;
			AdherentCreationService.modifAdherent(adherent).then(function(result){
				$scope.modif = true;
				$scope.modifiedNom = $scope.adhNom;
				$scope.modifiedPrenom = $scope.adhPrenom;
				
				$scope.failModif = false;
			},function(error){
				$scope.failModif = true;
			});
			
		}else {

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
			
			$scope.failModif = false;
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
				$scope.failAdd = false;
			},function(error){
				$scope.failAdd = true;
			});
		}
	};
});