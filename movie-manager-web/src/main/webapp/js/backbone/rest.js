function RestInteractor() {
	_this = this;
	this.rootUrl = location.origin + "/movie/rest/movies/";
	this.setResponder = function(resultsResponder) {
		_this.resultsResponder = resultsResponder;
	};
	this.search = function(query) {
		$.ajax({
			type: 'GET',
			url: _this.rootUrl + "search/" + query,
			dataType: "json",
			success: function(movie) {
				if (movie) {
					_this.resultsResponder(movie.title);
				} else {
					_this.resultsResponder("No such movie.");
				}
			}
		});
	};
}