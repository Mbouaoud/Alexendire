angular.module('bibliApp').controller('AdherentVisualisationCtrl', function($scope, $location, $http, $rootScope, $routeParams, UrlService) {

	$rootScope.typePage = 'AV';
	$scope.nbDisplay = 20;
	$scope.newTitre = undefined;
	$scope.newDate = undefined;
	$scope.newType = undefined;
	$scope.mediaNotFound = false;
	$scope.mediaTooMuchFound = false;
	$scope.listeTypes = ["Livre","CD","DVD"];

	$http.get(UrlService.getAccessionAdherent(), {params : {id : $routeParams.idAdherent}})
		.then(function(response) {
			$scope.adherent = response.data;
			$scope.medias = response.data.emprunt;
		});

	$scope.modifierAdherent = function() {
		$location.url("/adherentCreation/" + $scope.adherent.id);
	};

	$scope.triMedia = function($triValue) {

		var tri = false;
		var echange;
		
		do {
			tri = false;
			for (i = 1; i < $scope.medias.length; i++) {
				if (($triValue == "titre") && ($scope.medias[i].media.titre < $scope.medias[i - 1].media.titre)){
					tri = true;
				}else if (($triValue == "auteur") && ($scope.medias[i].media.auteur < $scope.medias[i - 1].media.auteur)){
					tri = true;
				}else if (($triValue == "type")&& ($scope.medias[i].media.type < $scope.medias[i - 1].media.type)){
					tri = true;
				}
				
				if (tri == true) {
					echange = $scope.medias[i];
					$scope.medias[i] = $scope.medias[i - 1];
					$scope.medias[i - 1] = echange;
				}
			}
		} while (tri == true);
	};

	$scope.rechercheMedias = function() {
		
		if ($scope.newTitre != undefined) {
			$http.get(UrlService.getRechercheMedia(), {params : {titre : $scope.newTitre}})
				.then(function(response) {
					$scope.listeTypes = [];
					$scope.newTitre = response.data[0].titre;
					for( var i = 0; i< response.data.length; i++)
						$scope.listeTypes.push(response.data[i].type);
				});
		}
	};

	$scope.ajouterEmprunt = function() {

		var id_media_fetch = undefined;

		$http.get(UrlService.getRechercheMedia(), {
			params : {
				page : undefined,
				titre : $scope.newTitre,
				auteur : undefined,
				type : $scope.newType,
				tri : undefined
			}
		}).then(function(response) {
			if (response.data.length == 0){
				$scope.mediaNotFound = true;
			}
			else if (response.data.length > 1) {
				$scope.mediaTooMuchFound = true;
			}
			else {
				id_media_fetch = response.data[0].id;
				
				$http.post(UrlService.getEmpruntMedia(), {
					id_adherent : $routeParams.idAdherent,
					id_media : ""+ id_media_fetch,
					depart : $scope.newDate.toISOString().substring(0, 10)
				}).then(function(response) {
				$http.get(UrlService.getAccessionAdherent(), {params : {id : $routeParams.idAdherent}})
					.then(function(response) {
						$scope.adherent = response.data;
						$scope.medias = response.data.emprunt;
					});
				});
			}
		});
	};
});