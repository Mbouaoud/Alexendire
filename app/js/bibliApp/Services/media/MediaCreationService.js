angular.module('bibliApp').factory('MediaCreationService',function($http){
	return {
		addMedia: function(media){	
			 return $http.post('http://192.168.10.41:8090/resource/media.creation',media).success(function(data){
				console.log('Media ajouté avec succes');
			}).error(function(){
				console.log('Erreur lors de la creation du media');
			})
		}
	}
});