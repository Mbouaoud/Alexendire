angular.module('bibliApp').factory('AdherentCreationService',function($http, UrlService){
	return {
		addAdherent: function(adherent){	
			 return $http.post(UrlService.getCreationAdherent(),adherent).success(function(data){
				console.log('Adherent ajouté avec succes');
			}).error(function(){
				console.log('Erreur lors de la creation de l\'adherent');
			})
		},
		
		modifAdherent: function(adherent){	
			 return $http.post(UrlService.getModificationAdherent(),adherent).success(function(data){
				console.log('Adherent modifié avec succes');
			}).error(function(){
				console.log('Erreur lors de la modification de l\'adherent');
			})
		}
	}
});