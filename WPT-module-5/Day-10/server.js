
// const http=require('http');
import {createServer} from 'http';

import {sum,product} from './myModule'
var server=createServer((req,res)=>{
    res.write("Hello world")
    // var x=5;
    // var z=10;
    // var y=x+z;
    var s=sum(2,3);
    var p=product(3,4);
    res.write(`sum is ${s} and product is ${p}`);
    res.write("Bhaii tuze karna hai ajj ke aj DOM manipulation")
    res.end();
});
// var server=http.createServer((req,res)=>{
//     res.write("Hello world")
//     var x=5;
//     var z=10;
//     var y=x+z;
//     res.write(`sum is ${y}`);
//     res.write("Bhaii tuze karna hai ajj ke aj DOM manipulation")
//     res.end();
// });//create the new server on local machine

server.listen(3000,()=>{
    console.log("Server started");
});//start listening on the request