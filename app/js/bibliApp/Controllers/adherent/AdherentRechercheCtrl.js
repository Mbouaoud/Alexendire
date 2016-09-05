angular.module('bibliApp').controller('AdherentRechercheCtrl', function($scope,$location, $rootScope){
	
	$rootScope.typePage='A';
	
	$scope.adherentVisualisation = function(){
		$location.url('/');
	}
	
})