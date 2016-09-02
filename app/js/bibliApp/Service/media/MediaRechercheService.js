angular
	.module('bibliApp')
	.factory('MediaRechercheService',function($http){
		
		var media=[];
		
		$http({method:'GET',url:'http://192.168.10.41:8090/resource/media.recherche',params:{'type':"DVD"}}).success(function(data){
			media=data;			
		}).error(function(){
			console.log('Erreur lors du chargement du fichier media recherhce taille');
		})
		
		return {
		get: function(){
			console.log(media);
			return media;
		}
	};
});