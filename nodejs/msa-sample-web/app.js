var express = require('express');
var zookeeper = require('node-zookeeper-client');
var httpProxy = require('http-proxy');

var CONNECTION_STRING = '192.168.0.107:2181,192.168.0.108:2181,192.168.0.109:2181'
var REGISTRY_ROOT = '/registry';

var zk = zookeeper.createClient(CONNECTION_STRING);
zk.connect();

var proxy = httpProxy.createProxyServer();
proxy.on('error', function(err, req, res){
	res.end();
});

var PORT=1234

var app = express();

app.use(express.static('public'));
app.all('*', function(req, res){

	if (req.path == '/favicon.ico') {
		res.end();
		return;
	}

	var serviceName = req.get('Service-Name');
	console.log('serviceName : %s', serviceName);

	if (!serviceName) {
		console.log('Service-Name request header is not exist');
		res.end();
		return;
	}
	var servicePath = REGISTRY_ROOT + '/' + serviceName;
	console.log('servicePath : %s', servicePath);

	zk.getChildren(servicePath, function(error, addressNodes){
		if(error) {
			console.log(error.stack);
			res.end();
			return;
		}

		var size = addressNodes.length;

		if (size  == 0 ){
			console.log('address node is not exist');
			res.end();
			return;
		}

		var addressPath = servicePath + '/';
		if (size == 1) {
			addressPath += addressNodes[0];
		} else {
			addressPath += addressNodes[parseInt(Math.random() * size)];
		}
		console.log('addressPath : %s', addressPath);

		zk.getData(addressPath, function(error, serviceAddress){
			if (error) {
				console.log(error.stack);
				res.end();
				return;
			}
			console.log('serviceAddress: %s', serviceAddress);

			if (!serviceAddress) {
				console.log('service address is not exist');
				res.end();
				return;
			}

			proxy.web(req,res, {
				target: 'http://' + serviceAddress
			});
		});
	});
});


app.listen(PORT, function(){
	console.log('server is running at %d', PORT);
});

