angular.module('bibliApp').controller('HomeCtrl', function($scope,$location,MediaRechercheService,$rootScope){
		
	$rootScope.typePage='MR';
	var recherche = [];
	$scope.nbElmtByPage = 20;
	
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
	
	$scope.mediaVisualisation = function(id){
		$location.url('/mediaVisualisation/'+id);
	}
	
	$scope.resultMedia = function(page){	
		MediaRechercheService.get($scope.titre,$scope.auteur,$scope.type)
		.then(function(result){
			recherche=result.data;
			$scope.triMedia($scope.varTri);
			$scope.resultats=recherche.slice((page-1)*$scope.nbElmtByPage,page*$scope.nbElmtByPage);
			$scope.pageMax = Math.ceil(recherche.length/$scope.nbElmtByPage);
			$scope.pageActuelle = page;
		},function(error){
			this.error=error;
		});

		$scope.showme=true;
	}
	
	$scope.getNumber = function(num) {
	    return new Array(num);   
	}
	
	$scope.triMedia = function($triValue) {
		
		var tri = false;
		var echange;
		do {
			tri = false;
			for (i = 1; i < recherche.length; i++) {
				if (($triValue == "titre")
						&& (recherche[i].titre < recherche[i - 1].titre))
					tri = true;
				else if (($triValue == "auteur")
						&& (recherche[i].auteur < recherche[i - 1].auteur))
					tri = true;
				else if (($triValue == "type")
						&& (recherche[i].type < recherche[i - 1].type))
					tri = true;
				if (tri == true) {
					echange = recherche[i];
					recherche[i] = recherche[i - 1];
					recherche[i - 1] = echange;
				}
			}
		} while (tri == true);
	};
})