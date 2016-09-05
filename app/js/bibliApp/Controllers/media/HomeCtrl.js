angular.module('bibliApp').controller('HomeCtrl', function($scope,$location,MediaRechercheService){
		
	$scope.mediaType=[{
		id:1,
		label:"Livre"
	}, {
		id:2,
		label:"CD"
	}, {
		id:3,
		label:"DVD"		
	}];
	
	$scope.mediaVisualisation = function(){
		$location.url('/');
	}
	
	$scope.resultMedia = function(){	
		
		MediaRechercheService.get($scope.titre,$scope.auteur,$scope.type)
		.then(function(result){
			$scope.resultats=result.data;
		},function(error){
			this.error=error;
		});

		$scope.showme=true;
	}
	
})