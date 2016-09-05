angular.module('bibliApp').controller('AdherentCreationCtrl', function($scope){
	
	$scope.FinAbonnement = function(dateAbo){
		if(dateAbo == undefined){
			return null;
		}else{
			var temp = angular.copy(dateAbo);
			temp.setFullYear(temp.getFullYear()+1);
			return temp;
		}	
	}
	
	$scope.AgeAbonne = function(dateNaissance){
		return dateNaissance;
	}
		
	$scope.addAdherent = function(){
		
	};

	$scope.updateAge = function(){
		
	}

	$scope.updateAbo = function(){
		
	}
});