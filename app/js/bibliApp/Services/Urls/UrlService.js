angular.module('bibliApp').provider('UrlService',function(){
	var protocol = 'http';
	var server = 'localhost';
	var port = '8000';
	return {
		setDefaut : function(nouveauProtocol, nouveauServer, nouveauPort){
			protocol = nouveauProtocol;
			server = nouveauServer;
			port = nouveauPort;
		},
		$get : function(){
			function getFullUrl(resource){
				return protocol + '://' + server + ':' + port + resource;
			}
			return {
				getAccessionAdherent : function(){
					return getFullUrl('/resource/adherent.accession');
				},
				getAccessionMedia : function(){
					return getFullUrl('/resource/media.accession');
				},
				getRechercheMedia : function(){
					return getFullUrl('/resource/media.recherche');
				}
			};
		}
	}
});
/*
angular.module('bibliApp').provider('UrlService',function(){
	return {
		setDefaut : function(nouveauProtocol, nouveauServer, nouveauPort){
			// Aïe , je n'ai pas accès aux variables protocol, server et port ...
		},
		$get : function(){
			var protocol = 'http';
			var server = 'localhost';
			var port = '8000';
			return {
				getAccessionAdherent : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				},
				getAccessionMedia : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				}
			};
		},
	}
});
*//*
angular.module('bibliApp').provider('UrlService',function(){
	return {
		$get : function(){
			var protocol = 'http';
			var server = 'localhost';
			var port = '8000';
			return {
				getAccessionAdherent : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				},
				getAccessionMedia : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				}
			};
		}
	}
});
*//*
angular.module('bibliApp').factory('UrlService',function(){
			var protocol = 'http';
			var server = 'localhost';
			var port = '8000';
			return {
				getAccessionAdherent : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				},
				getAccessionMedia : function(){
					return protocol + '://' + server + ':' + port + '/resource/adherent.accession';
				}
			};
});
*/