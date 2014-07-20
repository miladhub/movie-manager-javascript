var rootUrl = document.URL + "rest/movies/";

$('#searchButton').click(function() {
	search($('#searchQuery').val());
	return false;
});

$('#searchQuery').keypress(function(e){
	if(e.which == 13) {
		search($('#searchQuery').val());
		e.preventDefault();
		return false;
    }
});

function search(searchQuery) {
	console.log('query: ' + searchQuery);
	$.ajax({
		type: 'GET',
		url: rootUrl + "search/" + searchQuery,
		dataType: "json",
		success: function(movie) {
			if (movie) {
				$('#searchResults').val(movie.title);
			} else {
				alert("No such movie.");
			}
		}
	});
}
