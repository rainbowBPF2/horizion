/**
 * Created by pengfei on 2017/8/23.
 */

var http = require('http');

var options = {
    host: '127.0.0.1',
    port: '8081',
    path: '/index.html'
};

var callback = function (response) {
    var body = '';
    response.on('data', function (data) {
        body += data;
    });

    response.on('end', function () {
        console.log('body end');
        console.log(body);
    });
}

var request = http.request(options, callback);
console.log('Main end');

request.end();