angular.module('bibliApp').factory('AdherentRechercheService',function($http, UrlService){
		
	return {
		get: function(id,nom){
			 return $http({method:'GET',url:UrlService.getRechercheAdherent(),params:{'id':id,'nom':nom}}).success(function(data){
				console.log('Je fais la recherche adherent');
				console.log(data);
			}).error(function(){
				console.log('Erreur lors du chargement du fichier adherent recherche');
			})
		}
	};
	
});