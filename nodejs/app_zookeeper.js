var zookeeper = require('node-zookeeper-client');

var CONNECTION_STRING = '192,168.0.107:2181,192.168.0.108:2181,192.168.0.109:2181';

var OPTIONS = {
	sessionTimeout : 5000
};

var zk = zookeeper.createClient(CONNECTION_STRING, OPTIONS);
zk.on('connected', function(){
	console.log("zookeeper is ok")
	//console.log(zk);
	zk.close();
});

zk.connect();

zk.getChildren('/', function(error, children, stat){
	console.log(children);
});

zk.exists("/foo", function(error, stat) {
	if (stat) {
		console.log("node exists");
	} else {
		console.log('node does not exist');
	}
});

//zk.create("/f1", new Buffer('f1=hello'), function(error, path) {
//	console.log(path);
//});

zk.getData('/f2', function(error, data, stat) {
	console.log(data.toString());
})

zk.setData('/f2', new Buffer('f1=f1'), function(error, stat) {
	console.log(stat);
})

zk.remove('/foo', function(error) {
	if (error) {
		console.log('node is deleted error');
	}  else {
		console.log('node is deleted');
	}
});