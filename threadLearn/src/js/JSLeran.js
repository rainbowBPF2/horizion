/**
 * Created by pengfei on 2017/8/22.
 */


/*var x = 3;
 var y = x + 3;
 console.log(y);

 do {
 y++;
 console.log(y)
 } while (y < 20);*/

/*var fs = require('fs');

 fs.readFile('d:\\save.txt', function (err, data) {

 if (err) return console.error(err);
 console.log(data.toString());

 });

 console.log("Program ended!");



 var data = fs.readFileSync('d:\\save.txt');
 console.log(data.toString());
 console.log('Main end2');*/

var fs = require("fs");

fs.readFile('d:\\sav1e.txt', function (err, data) {
    if (err) {
        console.log(err.stack);
        return;
    }
    console.log(data.toString());
});
console.log("Program Ended");