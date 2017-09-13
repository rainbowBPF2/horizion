/**
 * Created by pengfei on 2017/8/27.
 */

var fs = require('fs');
var childProcess = require('child_process');

for(var j=0;j<10;j++) {
    for (var i = 0; i < 10; i++) {
        // var worker = childProcess.exec("node Support.js " + (j*10+i), function (error, stdout, stderr) {
        //     if (error) {
        //         console.log(error.stack);
        //         console.log(error.code);
        //         console.log(error.signal);
        //     }
        //
        //     console.log("stdout:" + stdout);
        //     console.log("stderr:" + stderr);
        // });
        //
        // worker.on('exit', function (code) {
        //     console.log('Code received:' + code);
        // })
        console.log('Test child process');
    }
    sleep(300);
}

function sleep(sleepTime) {
    for(var start = +new Date; +new Date - start <= sleepTime; ) { }
    console.log('Sleep running');
}
