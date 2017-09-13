/**
 * Created by pengfei on 2017/8/23.
 */

var express = require('express');
var fs = require('fs');
var bodyParse = require('body-parser');
var multer = require('multer');
var cookieParse = require('cookie-parser');


var app = express();


app.use(express.static('public'));
app.use(express.static('user'));
app.use(bodyParse.urlencoded({extended: false}));
app.use(multer({dest: './temp'}).single('file'));
app.use(cookieParse());

app.get('/', function (request, response) {
    var temp = request;
    console.log("Cookies: ", request.cookies)
    response.send('Hello world');
});

app.get('/index.html', function (reqest, response) {

    response.sendFile(__dirname + "/" + 'index.html');
});

app.get('/process_get', function (request, response) {
    result = {
        fn: request.query.firstName,
        ln: request.query.lastName
    };
    console.log(result);
    response.send(JSON.stringify(result));
    response.end();

});

app.post('/upload_file', function (request, response) {

    console.log(request.file.originalname);
    console.log(request.file.path);
    console.log(request.file.size);

    var filePath = __dirname + "\\temp\\" + request.file.originalname;
    var newFilePath = __dirname + "\\" + request.file.path;
    console.log(filePath);

    fs.readFile(request.file.path, function (err, data) {
        fs.writeFile(filePath, data, function (err) {
            if (err) {
                console.error(err.stack())
            } else {
                result = {
                    message: 'File upload successfully',
                    fileName: request.file.originalname
                }

                console.log(result);
                fs.unlink(newFilePath); //delete the unwanted file.
                response.end(JSON.stringify(result));
            }
        });
    });
});


app.get('/listUsers', function (request, response) {
    fs.readFile(__dirname + "/" + "user.json", "UTF-8", function (err, data) {
        console.log(data);
        response.end(data);
    });
});

var user = {
    "user4": {
        "name": "mohit",
        "password": "password4",
        "profession": "teacher",
        "id": 4
    }
}

app.post('/addUser', function (request, response) {
    fs.readFile(__dirname + "/" + "user.json", "UTF-8", function (err, data) {
        data_info = JSON.parse(data);
        data_info['user4'] = user['user4'];
        console.log(data_info);
        response.end(JSON.stringify(data_info));
    });
});

app.get('/:id', function (request, response) {
    fs.readFile(__dirname + "/" + "user.json", "UTF-8", function (err, data) {
        userInfo = JSON.parse(data);
        var result = userInfo['user' + request.params.id];

        console.log('Find user:' + result);
        response.end(JSON.stringify(result));
    });
});

app.delete('/deleteUser', function (request, response) {
    fs.readFile(__dirname + "/" + "user.json", "UTF-8", function (err, data) {
        userInfo = JSON.parse(data);
        delete userInfo['user2'];
        console.log(userInfo);
        response.end(JSON.stringify(userInfo));
    })
})

var server = app.listen(8082, function () {
    var host = server.address().address;
    var port = server.address().port;
    console.log('APP listening:' + host + port);
})

