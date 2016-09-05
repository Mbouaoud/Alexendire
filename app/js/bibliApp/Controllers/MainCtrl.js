angular.module('bibliApp')
.controller('MainCtrl', function($scope, $location, $rootScope){
	
	$scope.menu =  function(){
		if($rootScope.typePage=='L'){
			return false;
		}else{
			return true;
		}
	}
});