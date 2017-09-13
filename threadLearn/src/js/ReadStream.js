/**
 * Created by pengfei on 2017/8/23.
 */

var fs = require('fs');
var data=''
readStream = fs.createReadStream('d:\\save.txt');
readStream.setEncoding('UTF-8');

readStream.on('data', function (chunk) {
    data += chunk;
});


readStream.on('end', function () {
    console.log(data);
});


readStream.on('error', function (err) {
    console.error(err.stack)
});

console.log('Main program end.');
