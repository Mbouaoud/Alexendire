angular
		.module('bibliApp')
		.controller(
				'AdherentVisualisationCtrl',
				function($scope, $location, $http, $rootScope) {

					$rootScope.typePage = 'AV';

					$scope.nbDisplay = 20;

					$scope.newTitre = undefined;

					$scope.newDate = undefined;

					$scope.newType = undefined;

					$http
							.get(
									'http://192.168.10.41:8090/resource/adherent.accession',
									{
										params : {
											id : ($location.search()).idAdherent
										}
									}).then(function(response) {
								$scope.adherent = response.data;
								$scope.medias = response.data.emprunt;
							});

					$scope.modify = function() {
						$location.url("/adherentCreation?idAdherent="
								+ $scope.adherent.id);
					};

					$scope.ajouterEmprunt = function() {

						var id_media_fetch = undefined;

						$http
								.get(
										'http://192.168.10.41:8090/resource/media.recherche',
										{
											params : {
												page : undefined,
												titre : $scope.newTitre,
												auteur : undefined,
												type : $scope.newType,
												tri : undefined
											}
										})
								.then(
										function(response) {
											id_media_fetch = response.data[0].id;
											$http
													.post(
															'http://192.168.10.41:8090/resource/emprunt.ajout',
															{
																id_adherent : ($location
																		.search()).idAdherent,
																id_media : ""
																		+ id_media_fetch,
																depart : $scope.newDate
																		.toISOString()
																		.substring(
																				0,
																				10)
															})
													.then(
															function(response) {
																$http
																		.get(
																				'http://192.168.10.41:8090/resource/adherent.accession',
																				{
																					params : {
																						id : ($location
																								.search()).idAdherent
																					}
																				})
																		.then(
																				function(
																						response) {
																					$scope.adherent = response.data;
																					$scope.medias = response.data.emprunt;
																				});
															});
										});
					};
				});