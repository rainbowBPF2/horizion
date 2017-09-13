/**
 * Created by pengfei on 2017/8/23.
 */

var fs = require('fs');
var readStream = fs.createReadStream('out.txt');
var writeStream = fs.createWriteStream('out2.txt');

readStream.pipe(writeStream);

console.log("Main end");
