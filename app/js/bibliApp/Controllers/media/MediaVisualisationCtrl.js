angular.module('bibliApp').controller(
		'MediaVisualisationCtrl',
		function($scope, $location, $http, $rootScope) {

			$rootScope.typePage='MV';
			
			$scope.nbDisplay = 20;
			
			$scope.newNomEmprunteur = undefined;
			
			$scope.newDate = undefined;

			$http.get('http://192.168.10.41:8090/resource/media.accession', {
				params : {
					id : ($location.search()).idMedia
				}
			}).then(function(response) {
				$scope.media = response.data;
			});

			$scope.emprunteurs = [ {}, {}, {} ];

			$http.get('http://192.168.10.41:8090/resource/adherent.accession',
					{
						params : {
							id : 1
						}
					}).then(function(response) {
				$scope.emprunteurs[0] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/adherent.accession',
					{
						params : {
							id : 2
						}
					}).then(function(response) {
				$scope.emprunteurs[1] = response.data;
			});
			$http.get('http://192.168.10.41:8090/resource/adherent.accession',
					{
						params : {
							id : 3
						}
					}).then(function(response) {
				$scope.emprunteurs[2] = response.data;
			});

			$scope.modify = function() {
				$location.url("/mediaCreation?idMedia=" + $scope.media.id);
			};
			
			$scope.ajouterEmprunteur = function() {
				$http.get('http://192.168.10.41:8090/resource/emprunt.creation', {
					params : {
						id : $scope.newNomEmprunteur,
						date : $scope.newDate
					}
				}).then(function(response) {
					$http.get('http://192.168.10.41:8090/resource/media.accession', {
						params : {
							id : ($location.search()).idMedia
						}
					}).then(function(response) {
						$scope.media = response.data;
					});
				});
			};
		});