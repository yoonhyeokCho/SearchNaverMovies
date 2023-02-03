const express = require("express");
const static =require("serve-static");
const bodyParser = require("body-parser");
const app = express();
const port = 3000;

app.set("port", port);
app.use(static(__dirname));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

const getdata = require("./routes/getdata.js");


app.use("/getdata",getdata);




app.all("*", (req, res, next) => {
    res.status(404).send("404 errorcheck");
});

app.listen(port, () => console.log("Listening on", port));


