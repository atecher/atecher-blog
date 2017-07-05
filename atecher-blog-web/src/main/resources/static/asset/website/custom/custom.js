$(document).ready(function(){
	$(window).resize(function() {
		$.UIkit.offcanvas.hide([force = false]);
	});
	$('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
		var locationUrl=$('[data-uk-pagination]').data("base-url");
		var suffix=$('[data-uk-pagination]').data("suffix");
		if(pageIndex==0){
			locationUrl=locationUrl+"/";
		}else{
			locationUrl=locationUrl+"/page/"+(pageIndex+1);
		}
		if(suffix){
			locationUrl=locationUrl+suffix;
		}

		window.location.href=locationUrl;
	});

	$(".uk-search-field").on('keydown', function(){
		if(event.keyCode==13){
			window.location.href=$(".uk-search").attr("action")+"?s="+encodeURIComponent(this.value);
			return false;
		}
	});

});
