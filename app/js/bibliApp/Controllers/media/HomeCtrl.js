angular.module('bibliApp').controller('HomeCtrl', function($scope,$location,MediaRechercheService,$rootScope){
		
	$rootScope.typePage='MR';
	var recherche = [];
	
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
		$location.url('/mediaVisualisation');
	}
	
	$scope.resultMedia = function(page){	
		MediaRechercheService.get($scope.titre,$scope.auteur,$scope.type)
		.then(function(result){
			recherche=result.data;
			console.log(recherche);
			$scope.resultats=recherche.slice((page-1)*10,page*10);
			$scope.pageMax = Math.ceil(recherche.length/10);
		},function(error){
			this.error=error;
		});

		$scope.showme=true;
	}
	
	$scope.getNumber = function(num) {
	    return new Array(num);   
	}
})