angular.module('bibliApp').controller('AdherentRechercheCtrl', function($scope,$location, $rootScope){
	
	$rootScope.typePage='AR';
	
	$scope.adherentVisualisation = function(){
		$location.url('/');
	}
	
})