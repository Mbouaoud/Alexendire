angular.module('bibliApp').factory('AdherentRechercheService',function($http){
		
	return {
		get: function(id,nom){
			 return $http({method:'GET',url:'http://192.168.10.41:8090/resource/adherent.recherche',params:{'id':id,'nom':nom}}).success(function(data){
				console.log('Je fait la recherche adherent');
			}).error(function(){
				console.log('Erreur lors du chargement du fichier adherent recherche');
			})
		}
	};
	
});