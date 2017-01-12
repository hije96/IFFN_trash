/**
 * Created by LG on 2016-12-21.
 */

var express = require('express');
var router = express.Router();

/*
router.get("/", (req, res, next) => {
    res.json({"hi":"hello"});

});
*/

router.post("/", (req, res, next) => {

    console.log("aaaa");
    var x = req.body.x
    var y= req.body.y;
    var z= req.body.z;
    var l= req.body.l;

  //  var c= a + b;
    console.log(x);


    res.json(
        {"Hi": "OK",
            "x":x,
            "y":y,
            "z":z,
            "l":l
    });

});


module.exports = router;