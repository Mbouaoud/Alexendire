angular.module('bibliApp').controller('MediaCreationCtrl', function($scope, $rootScope, MediaCreationService, $routeParams){
		
	var idMedia = $routeParams.idMedia;
	var media = {};
	
	$scope.add = false;
	$scope.fail = false;
	$scope.up = false;
	
	if(idMedia != undefined){
		$rootScope.typePage='MV';
		MediaCreationService.getMedia(idMedia).then(function(result){
			$scope.mediaTitre = result.data.titre;
			$scope.mediaAuteur = result.data.auteur;
			$scope.mediaType = result.data.type;
			id = result.data.id;
		},function(error){
		});
	}
	else
		$rootScope.typePage='MC';
	
	$scope.mediaTypes = [
		{type : "Livre", id : "l"},
		{type : "CD", id : "c"},
		{type : "DVD", id : "d"}
	];
	
	$scope.addMedia = function(){
		if(idMedia != undefined){
			media = {
				id: idMedia,
				titre : $scope.mediaTitre,
				auteur: $scope.mediaAuteur,
				type: $scope.mediaType
			};
			
			MediaCreationService.updateMedia(media).then(function(result){
				$scope.addedTitre = $scope.mediaTitre;
				$scope.up = true;
				$scope.mediaTitre = "";
				$scope.mediaAuteur = "";
				$scope.mediaType = "";
				$scope.fail = false;
			},function(error){
				$scope.fail = true;
			});
		}else{
			media = {
				titre : $scope.mediaTitre,
				auteur: $scope.mediaAuteur,
				type: $scope.mediaType
			};
			
			MediaCreationService.addMedia(media).then(function(result){
				$scope.addedTitre = $scope.mediaTitre;
				$scope.add = true;
				$scope.mediaTitre = "";
				$scope.mediaAuteur = "";
				$scope.mediaType = "";
				$scope.fail = false;
			},function(error){
				$scope.fail = true;
			});
		}
	}
});