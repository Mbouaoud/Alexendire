angular.module('bibliApp').factory('MediaCreationService',function($http,UrlService){
	return {
		addMedia: function(media){	
			 return $http.post('http://192.168.10.41:8090/resource/media.creation',media).success(function(data){
				console.log('Media ajouté avec succes');
			}).error(function(){
				console.log('Erreur lors de la creation du media');
			})
		},
	
		getMedia: function(idMedia){	
			 return $http({method:'GET', url:UrlService.getAccessionMedia(), params:{'id' : idMedia }})
				 .success(function(data){
					console.log('Media ajouté avec succes');
				}).error(function(){
					console.log('Erreur lors de la creation du media');
				})
		},
		
		updateMedia: function(media){	
			 return $http.post('http://192.168.10.41:8090/resource/media.modification',media).success(function(data){
				console.log('Media mis à jour avec succes');
			}).error(function(){
				console.log('Erreur lors de la mise à jour du media');
			})
		}
	}
});