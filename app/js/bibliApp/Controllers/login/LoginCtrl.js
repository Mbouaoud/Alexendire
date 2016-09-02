angular.module('bibliApp')
.controller('LoginCtrl', function($scope, $location, Authentification) {
    this.login = login;
    (function initController() {
        Authentication.service.deconnexion();
    })();
    function login() {
        this.dataLoading = true;
        AuthenticationService.Login(this.login, this.password, function (response) {
            if (response.success) {
                Authentication.service.connexion(this.username, this.password);
                $scope.validLogin = function() {
            		if ($scope.formLogin.$valid) {
            			$location.url("/home/" + $scope.user);
                	} else {
                		FlashService.Error(response.message);
                		this.dataLoading = false;
                	}
            	};
        	};
    	});
	};	
});