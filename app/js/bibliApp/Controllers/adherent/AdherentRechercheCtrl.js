angular.module('bibliApp').controller('AdherentRechercheCtrl', function($scope,$location){
	
	$scope.adherentVisualisation = function(){
		$location.url('/');
	}
	
})