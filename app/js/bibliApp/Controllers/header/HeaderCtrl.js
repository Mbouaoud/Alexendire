angular.module('bibliApp')
.controller('HeaderCtrl', function($scope, $location, $rootScope){
	/*********  Login *************/
	$scope.LoginPage = function(){
		if($scope.myForm.$valid){
			$location.url("/login"); 
		}
	}	
	/*********  Media *************/
	$scope.menuMedia =  function(){
		if($rootScope.typePage=='MR' || $rootScope.typePage=='MC' || $rootScope.typePage=='MV') {
			return true;
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
	/*********  Adherent **********/
	$scope.menuAdherent =  function(){
		if($rootScope.typePage=='AR' || $rootScope.typePage=='AC' || $rootScope.typePage=='AV') {
			return true;
		}
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