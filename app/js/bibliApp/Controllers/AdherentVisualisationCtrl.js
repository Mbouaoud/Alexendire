angular.module('bibliApp').controller(
		'AdherentVisualisationCtrl',
		function($scope, $location, $http) {

			$http.get('http://192.168.10.41:8090/resource/adherent.accession',
					{
						params : {
							id : 1
						}
					}).then(function(response) {
				// console.log(response.data);
				$scope.adherent = response.data;
			});

			$scope.medias = [ {
				titre : 'Ex_Titre1',
				auteur : 'Ex_Auteur1',
				type : 'Ex_Type1'
			}, {
				titre : 'Ex_Titre2',
				auteur : 'Ex_Auteur2',
				type : 'Ex_Type2'
			}, {
				titre : 'Ex_Titre3',
				auteur : 'Ex_Auteur3',
				type : 'Ex_Type3'
			}, {
				titre : 'Ex_Titre4',
				auteur : 'Ex_Auteur4',
				type : 'Ex_Type4'
			} ];

			function modify() {
				$location.url("/adherentUpdate/" + $scope.adherent.id);
			}
			;
		});