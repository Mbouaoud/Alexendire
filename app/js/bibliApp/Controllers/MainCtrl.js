angular.module('bibliApp')
.controller('MainCtrl',function($scope, $location, $rootScope, Authentification){
	
	$scope.menu =  function(){
		if($rootScope.typePage=='L'){
			return false;
		}else{
			return true;
		}
	}
	
	$scope.isConnected = function(){
		return Authentification.isConnected();
	}
	
});