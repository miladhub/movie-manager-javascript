(function() {
	var app = angular.module("movie", []);
	app.controller("MovieController", function() {
		this.movies = movies;
	});

	app.controller('TabController', function() {
		this.tab = 1;

		this.setTab = function(newValue) {
			this.tab = newValue;
		};

		this.isSet = function(tabName) {
			return this.tab === tabName;
		};
	});

	app.controller('ReviewController', function() {
		this.review = {};
		this.addReview = function(movie) {
			movie.reviews.push(this.review);
			this.review = {};
		};
	});

	var movies = [ {
		title : "blade runner",
		year : 1982,
		author : "ridley scott",
		reviews: [{
			body: "so cool",
			author: "milad",
			stars: 5
		}, {
			body: "so so",
			author: "stefano",
			stars: 1
		}]
	}, {
		title : "a scanner darkly",
		year : 2006,
		author : "philip dick",
		reviews: [{
			body: "even cooler",
			author: "milad",
			stars: 5
		}, {
			body: "sucks",
			author: "stefano",
			stars: 1
		}]
	} ];
})();