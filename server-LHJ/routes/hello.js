/**
 * Created by LG on 2016-12-21.
 */

var express = require('express');
var request = require('request');
var router = express.Router();
//var serialport=require('serialport');

//var serialPort = new serialport.SerialPort("COM4", { baudrate: 9600});

/*
serialPort.on("open",function(){
    console.log("open success")
});
*/

router.get("/", (req, res, next) => {
    res.json({"hi":"hello"});

});


router.post("/", (req, res, next) => {

    console.log("aaaa");

    var x = req.body.x
    var y= req.body.y;
    var z= req.body.z;
    var l= req.body.l;

  //  var c= a + b;
    console.log(x);
    console.log(y);
    console.log(z);
    console.log(l);
    var data={"x":x, "y":y, "z":z, "l":l};

    //
    request({
        url: "http://localhost:3000/robot",
        method: "POST",
        json:true,
        body: data
    }, function (error, response, body) {
        console.log(response.body);
        res.json(
            {
                comment:response.body
            }
        );
    });
    //

    //var key= x*1000+y*100+z*10+l;
    //console.log(key);

    /*
    serialPort.write(key,function (){});
    console.log("기계전달OK");


    serialPort.on('data', function(data) {
        console.log('data received: ' + data);
    });
    */
    /*
    res.json(
        {"Hi": "OK",
            "response_x":x,
            "response_y":y,
            "response_z":z,
            "response_l":l
    });
    */

});


module.exports = router;