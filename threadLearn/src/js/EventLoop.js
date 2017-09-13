/**
 * Created by pengfei on 2017/8/23.
 */

var events = require('events');

var emitter = new events.EventEmitter();

var connectHandler = function connected() {
    console.log('connection successful');
    emitter.emit('data_received');
}

emitter.on('connection', connectHandler);

var dataHandler = function dataReceiveHandler() {
    console.log('data received');
}

emitter.on('data_received', dataHandler);

emitter.emit('connection');
console.log('Main end');


var buffer = new Buffer("this is a buffer");
var buffer2 = new Buffer('another buffer');
console.log(buffer.length);
console.log(buffer.toString());
console.log(buffer.compare(buffer2));