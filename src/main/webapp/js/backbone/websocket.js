function WebsocketInteractor() {
	_this = this;
	ws = new WebSocket("ws://" + location.hostname + ":" + location.port + "/movie/ws", [ 'soap', 'xmpp' ]);
	ws.onmessage = function(e) {
		console.log('from server: ' + e.data);
		_this.resultsResponder(e.data);
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
	this.setResponder = function(resultsResponder) {
		_this.resultsResponder = resultsResponder;
	};
	this.search = function() {
		ws.send($("#searchQuery").val());
	};
}