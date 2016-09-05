angular.module('bibliApp')
	.factory('MediaRechercheService',function($http){
		
		return {
		get: function(titre,auteur,type){
			
			 return $http({method:'GET',url:'http://192.168.10.41:8090/resource/media.recherche',params:{'page':"1",'titre':titre,'auteur':auteur,'type':type,'tri':"titre"}}).success(function(data){
				console.log('Je fait la recherche');
			}).error(function(){
				console.log('Erreur lors du chargement du fichier media recherche');
			})

		}
	};
});