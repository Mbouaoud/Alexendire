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