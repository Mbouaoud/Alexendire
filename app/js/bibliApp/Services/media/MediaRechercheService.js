angular.module('bibliApp').factory('MediaRechercheService',function($http, UrlService){
		
	return {
		get: function(titre,auteur,type){
			 return $http({method:'GET',url:UrlService.getRechercheMedia(),params:{'titre':titre,'auteur':auteur,'type':type}}).success(function(data){
				console.log('Je fais la recherche media');
			}).error(function(){
				console.log('Erreur lors du chargement du fichier media recherche');
			})
		}
	};
	
});