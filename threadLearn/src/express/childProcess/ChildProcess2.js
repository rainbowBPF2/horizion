/**
 * Created by pengfei on 2017/8/28.
 */

var fs = require('fs');
var childProcess = require('child_process');

for (var i = 0; i < 100; i++) {
    var worker = childProcess.spawn('node', ['Support.js',i]);

    worker.stdout.on('data', function (data) {
        console.log('Stdout data:' + data);
    });

    worker.stderr.on('data', function (data) {
        console.log('Stderr data:' + data);
    });

    worker.on('close', function (code) {
        console.log('Close code:' + code);
    });
}