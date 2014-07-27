function App(interactor) {
	interactor.setResponder(function(results) {
		$('#searchResults').val(results);
	});
	new SearchView().render();
	this.search = function(query) {
		interactor.search(query);
	};
};
