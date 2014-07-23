// var rootUrl = document.URL + "rest/movies/";

var ws = new WebSocket("ws://" + location.hostname + ':' + location.port + location.pathname + "/ws", ['soap', 'xmpp']);

ws.onmessage = function (e) {
  console.log('from server: ' + e.data);
  $('#searchResults').val(e.data);
};

ws.onconnect = function(e) {
  console.log("connected");
};

ws.onerror = function (error) {
  console.log('WebSocket Error ' + error);
};

ws.onclose = function(event){
     console.log("Remote host closed or refused WebSocket connection");
     console.log(event);
};

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
	ws.send(searchQuery);
//	$.ajax({
//		type: 'GET',
//		url: rootUrl + "search/" + searchQuery,
//		dataType: "json",
//		success: function(movie) {
//			if (movie) {
//				$('#searchResults').val(movie.title);
//			} else {
//				alert("No such movie.");
//			}
//		}
//	});
}
