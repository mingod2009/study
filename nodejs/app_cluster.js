var http = require('http');
var cluster = require('cluster');

var os = require('os');

var PORT = 1234;
var CPUS = os.cpus().length;

if(cluster.isMaster) {
	for (var i =0; i < CPUS; i++) {
		cluster.fork();
	}
} else {
	var app = http.createServer(function(req, res) {
		res.writeHead(200, {'Content-Type': 'text/html'});
		res.write('<h1>hello cluster</h1>');
		res.end();
	});

	app.listen(PORT, function(){
		console.log('server is running at %d', PORT);
	});
}

