angular.module('bibliApp').factory('MediaRechercheService',function($http){
		
	return {
		get: function(titre,auteur,type){
			 return $http({method:'GET',url:'http://192.168.10.41:8090/resource/media.recherche',params:{'titre':titre,'auteur':auteur,'type':type}}).success(function(data){
				console.log('Je fais la recherche media');
			}).error(function(){
				console.log('Erreur lors du chargement du fichier media recherche');
			})
		}
	};
	
});