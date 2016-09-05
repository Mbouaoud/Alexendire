angular.module('bibliApp')
.controller('HeaderCtrl', function($scope, $location, $rootScope){
	$scope.LoginPage = function(){
		if($scope.myForm.$valid){
			$location.url("/login"); 
		}
	}	
	
	$scope.menuHome =  function(){
		return $rootScope.typePage=='MR';
	}
	$scope.menuMediaCreation =  function(){
		return $rootScope.typePage=='MC';
	}
	$scope.menuMediaVisualisation =  function(){
		return $rootScope.typePage=='MV';
	}
	$scope.menuAdherentRecherche =  function(){
		return $rootScope.typePage=='AR';
	}
	$scope.menuAdherentCreation =  function(){
		return $rootScope.typePage=='AC';
	}
	$scope.menuAdherentVisualisation =  function(){
		return $rootScope.typePage=='AV';
	}
	
});