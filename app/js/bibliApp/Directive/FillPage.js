angular.module('bibliApp').directive('fillPage', function(){
	return function(scope, element, attrs){
		
		var h = $(window).height();
		var hdr = $('#header-div').height();
		/*var ftr = $('#footer-div').height();
		var fnl = Math.floor(h - (ftr?ftr:0) - (hdr?hdr:0));
		console.log(h,hdr,ftr,fnl);
		element.css('min-height', fnl +'px');*/
		var fnl = (h - 226);
		element.css('min-height', fnl +'px');
	};
});