angular.module('bibliApp').factory('Authentification', function($http, $rootScope, Base64Service, $cookies, UrlService) {
	
		var service = {};
		var connexion = false;
		
		// On vérifie si la personne n'était pas déjà connectée à xce PC avant :
		var cookie = $cookies.get('bibliAppCookie');
		
		if(cookie != null){
			connexion = true;
			$http.defaults.headers.common['Authorization'] = cookie;
		} else {
			connexion = false;
			$http.defaults.headers.common['Authorization'] = 'Basic';
		}

		service.connexion = function(login, password) {
			var authdata = Base64Service.encode(login + ':' + password);
			var config = {
				headers : {
					'Authorization' : 'Basic ' + authdata
				}
			};
//			return $http.get('http://192.168.10.41:1977/resource/connexion.rights', config).then(function(){
//			console.log(UrlService.getRightConnexion());
			
//			$http.get(  URL , CONFIG, body ) => erreur : un get n'a pas de body 
//			$http.get(  URL ,        CONFIG ) => oui, mais notre service est en POST
//			$http.post( URL , BODY , CONFIG ) => post prend en param2 un BODY et en param3 les config
//			$http.post( URL , BODY , CONFIG ) => post prend en param2 un BODY et en param3 les config
//			$http.post( URL , {}   , CONFIG ) => dans notre cas, les parametre LOGIN et PASSWORD sont des @RequestParam et pas de @BodyParam, donc le body est vide, mais l'attribut params de CONFIG ne l'ai pas...
			
			return $http.post(UrlService.getRightConnexion(), {'login':login,'password':password}, config).then(function(){
				// connexion ok
				$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
				// Setting a cookie
				$cookies.put('bibliAppCookie',  'Basic ' + authdata);
				connexion = true;
				return true;
				
			}, function(){
				// connexion ko
				service.deconnexion();
				return false;
			});
		}
		
		service.deconnexion = function() {
			$http.defaults.headers.common['Authorization'] = 'Basic';
			connexion = false;
			$cookies.remove('bibliAppCookie');
		}
		
		service.isConnected = function(){
			return connexion;
		}
		
		return service;
		
//	}).value('Base64Service',{
//		keyStr : 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',
//		encode : function(input) {
//			var output = "";
//			var chr1, chr2, chr3 = "";
//			var enc1, enc2, enc3, enc4 = "";
//			var i = 0;
//
//			do {
//				chr1 = input.charCodeAt(i++);
//				chr2 = input.charCodeAt(i++);
//				chr3 = input.charCodeAt(i++);
//
//				enc1 = chr1 >> 2;
//				enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
//				enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
//				enc4 = chr3 & 63;
//
//				if (isNaN(chr2)) {
//					enc3 = enc4 = 64;
//				} else if (isNaN(chr3)) {
//					enc4 = 64;
//				}
//
//				output = output + this.keyStr.charAt(enc1)
//						+ this.keyStr.charAt(enc2)
//						+ this.keyStr.charAt(enc3)
//						+ this.keyStr.charAt(enc4);
//				chr1 = chr2 = chr3 = "";
//				enc1 = enc2 = enc3 = enc4 = "";
//			} while (i < input.length);
//
//			return output;
//		}
		
	}).value('Base64Service',{
		keyStr : 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',
		encode : function(input) {
			return btoa(input);
		}
});