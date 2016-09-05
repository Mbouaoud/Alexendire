angular.module('bibliApp').controller('MediaCreationCtrl', function($scope){
	
	var media = [];
	$scope.add = false;
	
	$scope.mediaTypes = [
		{type : "Livre", id : "l"},
		{type : "CD", id : "c"},
		{type : "DVD", id : "d"}
	];
	
	$scope.addMedia = function(){
		media.push({
			titre : $scope.mediaTitre,
			auteur: $scope.mediaAuteur,
			type: $scope.mediaType
		});
		
		$scope.addedTitre = $scope.mediaTitre;
		$scope.add = true;
		$scope.mediaTitre = "";
		$scope.mediaAuteur = "";
		$scope.mediaType = "";
	}
});