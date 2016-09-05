angular.module('bibliApp').controller('MediaCreationCtrl', function($scope, $rootScope, MediaCreationService){
		
	$rootScope.typePage='MC';
	var media = {};
	$scope.add = false;
	$scope.fail = false;
	
	$scope.mediaTypes = [
		{type : "Livre", id : "l"},
		{type : "CD", id : "c"},
		{type : "DVD", id : "d"}
	];
	
	$scope.addMedia = function(){
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
});