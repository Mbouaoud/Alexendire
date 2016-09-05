angular
		.module('bibliApp')
		.controller(
				'MediaVisualisationCtrl',
				function($scope, $location, $http, $rootScope) {

					$rootScope.typePage = 'MV';

					$scope.nbDisplay = 20;

					$scope.newNomEmprunteur = undefined;

					$scope.newDate = undefined;

					$http
							.get(
									'http://192.168.10.41:8090/resource/media.accession',
									{
										params : {
											id : ($location.search()).idMedia
										}
									}).then(function(response) {
								$scope.media = response.data;
								$scope.emprunteurs = response.data.emprunteurs;
							});

					$scope.modifierMedia = function() {
						$location.url("/mediaCreation?idMedia="
								+ $scope.media.id);
					};

					$scope.triAdherent = function($triValue) {
						
						var tri = false;
						var echange;
						do {
							tri = false;
							for (i = 1; i < $scope.emprunteurs.length; i++) {
								if (($triValue == "id")
										&& ($scope.emprunteurs[i].adherent.id < $scope.emprunteurs[i - 1].adherent.id))
									tri = true;
								else if (($triValue == "nom")
										&& ($scope.emprunteurs[i].adherent.nom < $scope.emprunteurs[i - 1].adherent.nom))
									tri = true;
								if (tri == true) {
									echange = $scope.emprunteurs[i];
									$scope.emprunteurs[i] = $scope.emprunteurs[i - 1];
									$scope.emprunteurs[i - 1] = echange;
								}
							}
						} while (tri == true);
					};

					$scope.ajouterEmprunt = function() {

						var id_adherent_fetch = undefined;

						$http
								.get(
										'http://192.168.10.41:8090/resource/adherent.recherche',
										{
											params : {
												nom : $scope.newNomEmprunteur,
												prenom : undefined,
												email : undefined
											}
										})
								.then(
										function(response) {
											id_adherent_fetch = ""
													+ response.data[0].id;
											$http
													.post(
															'http://192.168.10.41:8090/resource/emprunt.ajout',
															{
																"id_adherent" : id_adherent_fetch,
																"id_media" : ($location
																		.search()).idMedia,
																"depart" : $scope.newDate
																		.toISOString()
																		.substring(
																				0,
																				10)
															})
													.then(
															function(response) {
																$http
																		.get(
																				'http://192.168.10.41:8090/resource/media.accession',
																				{
																					params : {
																						id : ($location
																								.search()).idMedia
																					}
																				})
																		.then(
																				function(
																						response) {
																					$scope.media = response.data;
																					$scope.emprunteurs = response.data.emprunteurs;
																				});
															});
										});
					};

				});