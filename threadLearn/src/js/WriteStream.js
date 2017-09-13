/**
 * Created by pengfei on 2017/8/23.
 */

var fs = require('fs');
var data = 'simple test here';

var writeStream = fs.createWriteStream('out.txt');

writeStream.write(data, 'UTF-8');
writeStream.end();

writeStream.on('finish', function () {
    console.log('Write end')
});

writeStream.on('error', function (err) {
    console.log(err.stack)
});

console.log('Main end');