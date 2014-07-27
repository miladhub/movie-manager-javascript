function TestInteractor() {
	this.searched = "";
	this.setResponder = function(resultsResponder) {
		this.resultsResponder = resultsResponder;
	};
	this.search = function(query) {
		this.searched = query;
	};
}

var app;

describe("Movie manager Backbone suite", function() {
	beforeEach(function() {
		$('body').append('<div id="container">Loading...</div>');
	});

	afterEach(function() {
		$('#container').remove();
	});

	it("query is initially presented to the user", function() {
		app = new App(new TestInteractor());
		expect($("#searchButton").length).toBeGreaterThan(0);
	});

	it("query is looked up when clicking button", function() {
		var interactor = new TestInteractor();
		app = new App(interactor);
		$('#searchQuery').val("asd");
		$('#searchButton').trigger("click");
		expect(interactor.searched).toEqual("asd")
	});
});