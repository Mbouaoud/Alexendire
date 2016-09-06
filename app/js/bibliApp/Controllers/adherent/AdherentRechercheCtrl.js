angular.module('bibliApp').controller('AdherentRechercheCtrl', function($scope,$location, $rootScope,AdherentRechercheService){
	
	$rootScope.typePage='AR';
	$scope.nbElmtByPage = 20;
	var recherche = [];
	
	$scope.adherentVisualisation = function(id){
		$location.url('/adherentVisualisation/'+id);
	}
	
	$scope.resultAdherent = function(page){	
		AdherentRechercheService.get($scope.idAdherent,$scope.nomAdherent)
		.then(function(result){
			recherche=result.data;
			$scope.triAdherent($scope.varTri);
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
	
	$scope.triAdherent = function($triValue) {
		
		var tri = false;
		var echange;
		do {
			tri = false;
			for (i = 1; i < recherche.length; i++) {
				if (($triValue == "id")
						&& (recherche[i].id < recherche[i - 1].id))
					tri = true;
				else if (($triValue == "nom")
						&& (recherche[i].nom < recherche[i - 1].nom))
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