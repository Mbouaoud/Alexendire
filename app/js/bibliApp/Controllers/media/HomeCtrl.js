angular.module('bibliApp').controller('HomeCtrl', function($scope,$location,MediaRechercheService,$timeout, $rootScope){
		
	$rootScope.typePage='MR';
	
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
		$timeout(function(){
			$scope.resultats=MediaRechercheService.get();
		},600);
		$scope.showme=true;
	}
	
})