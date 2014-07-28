var SearchView = Backbone.View.extend({
	template : _.template(
		"<label>Query:</label>\
		<input id='searchQuery' type='text' />\
		<button id='searchButton'>Search</button>\
		<output id='searchResults' name='searchResults' for='searchQuery' />"),
	render : function() {
		$(this.el).html(this.template({}));
	},
	events: {
	    "click #searchButton": "appSearch",
	    "keypress #searchQuery": "filterOnEnter"
    },
    filterOnEnter: function( event ) {
      if (event.keyCode != 13) return;
      this.appSearch(event);
	},
	appSearch: function( event ){
		app.search($("#searchQuery").val());
	}
});