//1 
var http = require('http')
//2 create server
http.createServer(function(request,response){

	response.writeHead("200",{'Content-Type': 'text/plain'})
	response.end('hellow world\n')
}).listen(8888)

// 终端打印如下信息
console.log('Server running at http://127.0.0.1:8888/');