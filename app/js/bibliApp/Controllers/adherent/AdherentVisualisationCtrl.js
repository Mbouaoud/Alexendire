angular.module('bibliApp').controller(
		'AdherentVisualisationCtrl',
		function($scope, $location, $http, $rootScope) {

			$rootScope.typePage='AV';
			
			$scope.nbDisplay = 20;

			$scope.newTitre = undefined;
			
			$scope.newDate = undefined;

			$scope.newType = undefined;
			
			$http.get('http://192.168.10.41:8090/resource/adherent.accession',
					{
						params : {
							id : ($location.search()).idAdherent
						}
					}).then(function(response) {
				$scope.adherent = response.data;
				$scope.medias = response.data.emprunt;
				console.log(response.data.emprunt);
			});
			
/*
			$scope.medias = [{},{},{},{},{},{},{}];
			
			$http.get('http://192.168.10.41:8090/resource/media.accession',
					{
						params : {
							id : 1
						}
					}).then(function(response) {
				$scope.medias[0] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/media.accession',
					{
						params : {
							id : 2
						}
					}).then(function(response) {
				$scope.medias[1] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/media.accession',
					{
						params : {
							id : 3
						}
					}).then(function(response) {
				$scope.medias[2] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/media.accession',
					{
						params : {
							id : 4
						}
					}).then(function(response) {
				$scope.medias[3] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/media.accession',
					{
						params : {
							id : 5
						}
					}).then(function(response) {
				$scope.medias[4] = response.data;
			});*/

			$scope.modify = function() {
				$location.url("/adherentCreation?idAdherent=" + $scope.adherent.id);
			};
			
			$scope.ajouterEmprunt = function() {
				
				var id_media_fetch = undefined;
				
				$http.get('http://192.168.10.41:8090/resource/media.recherche', {
					params : {
						page : undefined,
						titre : $scope.newTitre,
						auteur : undefined,
						type : $scope.newType,
						tri : undefined
					}
				}).then(function(response) {
					id_media_fetch = response.data[0].id;
					console.log(id_media_fetch);
				});
				$http.get('http://192.168.10.41:8090/resource/emprunt.ajout', {
					params : {
						id_adherent : ($location.search()).idAdherent,
						id_media : id_media_fetch,
						depart : $scope.newDate
					}
				}).then(function(response) {
					$http.get('http://192.168.10.41:8090/resource/adherent.accession',
							{
								params : {
									id : ($location.search()).idAdherent
								}
							}).then(function(response) {
						$scope.adherent = response.data;
					});
				});
			};
		});