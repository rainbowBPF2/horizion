/**
 * Created by pengfei on 2017/8/23.
 */


/*
var fs = require('fs');
var zlib = require('zlib');

fs.createReadStream('d:\\save.txt')
    .pipe(zlib.createGzip())
    .pipe(fs.createWriteStream('save.txt.gz'));

console.log('Main end');*/


console.log(__filename);
console.log(__dirname);

function helloWorld() {
    console.log("hello world");
}

// setTimeout(helloWorld,3000);
// setInterval(helloWorld,4000)

console.time();
console.info("info using");
console.error("error using");

process.on('exit', function(code) {

    // Following code will never execute.
    setTimeout(function() {
        console.log("This will not run");
    }, 3);

    console.log('About to exit with code:', code);
});
console.log("Program Ended");

var use=process.memoryUsage();
console.log(use);

console.log(process.hrtime());
console.log(process.cwd());