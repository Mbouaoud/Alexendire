angular.module('bibliApp').controller('MediaVisualisationCtrl', function($scope, $location, $http, $rootScope,$routeParams, UrlService) {

	$rootScope.typePage = 'MV';
	$scope.nbDisplay = 20;
	$scope.newNomEmprunteur = undefined;
	$scope.newDate = undefined;
	$scope.fail = false;
	$scope.rechercheNom = undefined;
	$scope.listePrenoms = undefined;
	$scope.selectedPrenom = undefined;

	$http.get(UrlService.getAccessionMedia(), {params : {id : $routeParams.idMedia}})
		.then(function(response) {
				$scope.media = response.data;
				$scope.emprunteurs = response.data.emprunteurs;
			});

	$scope.modifierMedia = function() {
		$location.url("/mediaCreation/" + $scope.media.id);
	};

	$scope.triAdherent = function($triValue) {

		var tri = false;
		var echange;
		
		do {
			tri = false;
			for (i = 1; i < $scope.emprunteurs.length; i++) {
				if (($triValue == "id") && ($scope.emprunteurs[i].adherent.id < $scope.emprunteurs[i - 1].adherent.id)){
					tri = true;
				} else if (($triValue == "nom") && ($scope.emprunteurs[i].adherent.nom < $scope.emprunteurs[i - 1].adherent.nom)){
					tri = true;
				};
			
				if (tri == true) {
					echange = $scope.emprunteurs[i];
					$scope.emprunteurs[i] = $scope.emprunteurs[i - 1];
					$scope.emprunteurs[i - 1] = echange;
				};
			}
		} while (tri == true);
	};

	$scope.recherchePrenoms = function() {
		
		if ($scope.newNomEmprunteur != undefined) {

			$http.get(UrlService.getRechercheAdherent(), {params : {nom : $scope.newNomEmprunteur, prenom : undefined, email : undefined}})
				.then(function(response) {
					$scope.listePrenoms = [];
					$scope.newNomEmprunteur = response.data[0].nom;
					for( var i = 0; i< response.data.length; i++)
						$scope.listePrenoms.push(response.data[i].prenom);
				});
		}
	};

	$scope.ajouterEmprunt = function() {

		var id_adherent_fetch = undefined;

		$http.get(UrlService.getRechercheAdherent(), {params : {nom : $scope.newNomEmprunteur,
																prenom : $scope.selectedPrenom,
																email : undefined}})
			.then(function(response) {
				if(response.data[0]==undefined || $scope.selectedPrenom == '') {
					$scope.fail = true;
				} else {
					id_adherent_fetch = ""+ response.data[0].id;
					
					$http.post(UrlService.getEmpruntMedia(), {
						"id_adherent" : id_adherent_fetch,
						"id_media" : $routeParams.idMedia,
						"depart" : $scope.newDate.toISOString().substring(0, 10)
					})
						.then(function(response) {
							$http.get(UrlService.getAccessionMedia(), {params : {id : $routeParams.idMedia}})
								.then(function(response) {
									$scope.media = response.data;
									$scope.emprunteurs = response.data.emprunteurs;
								});
							$scope.fail=false;
						},function(error){
							$scope.fail = true;
						});
					}
				});
		};

});