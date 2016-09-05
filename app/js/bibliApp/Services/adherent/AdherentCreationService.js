angular.module('bibliApp').factory('AdherentCreationService',function($http){
	return {
		addAdherent: function(adherent){	
			 return $http.post('http://192.168.10.41:8090/resource/adherent.creation',adherent).success(function(data){
				console.log('Adherent ajouté avec succes');
			}).error(function(){
				console.log('Erreur lors de la creation de l\'adherent');
			})
		}
	}
});