angular.module('bibliApp')
.controller('LoginCtrl', function($scope, $location) {
	$scope.validLogin = function() {
		if ($scope.formLogin.$valid) {
			$location.url("/home/" + $scope.user); 
		}
	}
});