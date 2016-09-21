angular.module('bibliApp').factory('MediaCreationService',function($http,UrlService){
	return {
		addMedia: function(media){	
			 return $http.post(UrlService.getCreationMedia(),media).success(function(data){
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
			 return $http.post(UrlService.getModificationMedia(),media).success(function(data){
				console.log('Media mis à jour avec succes');
			}).error(function(){
				console.log('Erreur lors de la mise à jour du media');
			})
		}
	}
});