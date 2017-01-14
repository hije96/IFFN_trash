/**
 * Created by LG on 2016-12-21.
 */

var express = require('express');
var router = express.Router();

router.post("/", (req, res, next) => {
    console.log("bbbb");
    /*
    res.json(
        {"Hi": "OK",
            x:1,
            y:2,
            z:3,
            l:4
        });
    */
    res.send("OK");
});


module.exports = router;