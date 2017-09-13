/**
 * Created by pengfei on 2017/8/28.
 */


var fs = require('fs');
var childProcess = require('child_process');

for (var i = 0; i < 10; i++) {
    var worker = childProcess.fork('Support.js', [i]);

    worker.on('close', function (code) {
        console.log('End code:' + code);
    });
}