function App(interactor) {
	interactor.setResponder(function(results) {
		$('#searchResults').val(results);
	});
	new SearchView({el : $('#container')}).render();
	this.search = function(query) {
		interactor.search(query);
	};
};
