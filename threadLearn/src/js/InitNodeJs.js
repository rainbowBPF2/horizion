
var http = require('http');

http.createServer(function (reqest, response) {
    response.writeHead(200, {'Content-Type': 'text/html'});
    response.write('<h1>helldddo</h1>');
    response.end('<p>Hello f</p>')
}).listen(2048);

console.log('Server running on local port:2048 ');