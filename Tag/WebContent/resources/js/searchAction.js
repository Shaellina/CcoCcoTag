/*function loadJQuery() {
	var oScript = document.createElement("script");
	oScript.type = "text/javascript";
	oScript.charset = "utf-8";
	oScript.src = "http://code.jquery.com/jquery-3.2.1.min.js";
	document.getElementsByTagName("head")[0].appendChild(oScript);
}*/
$(function() {
	$('#btn_search').click(function() {
		var tag = $('#tag').val();
		var search = $('#search').val();

		$.ajax({
			method : 'POST',
			url : 'SearchAction',
			data : {
				tag : tag,
				search : search
			}
		}).done(function(data) {
			var 
		})
	})
})