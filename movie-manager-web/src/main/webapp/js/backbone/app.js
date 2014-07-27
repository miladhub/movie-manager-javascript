var app = (function() {
	var ws;

	function startWebSocket(showResultsHandler) {
		ws = new WebSocket("ws://" + location.hostname + ":" + location.port + "/movie/ws", [ 'soap', 'xmpp' ]);
		ws.onmessage = function(e) {
			console.log('from server: ' + e.data);
			showResultsHandler(e.data);
		};
		ws.onconnect = function(e) {
			console.log("connected");
		};
		ws.onerror = function(error) {
			console.log('WebSocket Error ' + error);
		};
		ws.onclose = function(event) {
			console.log("Remote host closed or refused WebSocket connection: " + event);
		};
	}

	function privateSearch(query) {
		ws.send($("#searchQuery").val());
	}

	function showResults(results) {
		$('#searchResults').val(results);
	}

	startWebSocket(showResults);
	new SearchView().render();

	return {
		search : privateSearch
	};
})();
