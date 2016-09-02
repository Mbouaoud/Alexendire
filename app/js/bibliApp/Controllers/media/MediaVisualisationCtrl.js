angular.module('bibliApp').controller('MediaVisualisationCtrl',
		function($scope, $location, $http) {

			$http.get('http://192.168.10.41:8090/resource/media.accession', {
				params : {
					id : 1
				}
			}).then(function(response) {
				// console.log(response.data);
				$scope.media = response.data;
			});

			$scope.emprunteurs = [ {
				id : 'Ex_Id1',
				nom : 'Ex_NomEmprunteur1'
			}, {
				id : 'Ex_Id2',
				nom : 'Ex_NomEmprunteur2'
			}, {
				id : 'Ex_Id3',
				nom : 'Ex_NomEmprunteur3'
			}, {
				id : 'Ex_Id4',
				nom : 'Ex_NomEmprunteur4'
			}, {
				id : 'Ex_Id5',
				nom : 'Ex_NomEmprunteur5'
			}, {
				id : 'Ex_Id6',
				nom : 'Ex_NomEmprunteur6'
			}, {
				id : 'Ex_Id7',
				nom : 'Ex_NomEmprunteur7'
			}, {
				id : 'Ex_Id8',
				nom : 'Ex_NomEmprunteur8'
			} ];

			function modify() {
				$location.url("/mediaUpdate/" + $scope.media.id);
			}
			;
		});