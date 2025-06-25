
import express from 'express';
//const express =require('express'); same as above

//create an application
const app=express();//it return object of newly created express app;
//and assign object to app varible

app.get("/",(req,res)=>{

    res.send("Welcome to your first app");
})
app.get("/login",(req,res)=>{

    res.send("Welcome to login")
})
app.get("/sum/:x/:y",(req,res)=>{
    // console.log(req.params)//{x:3,y:5}
    var z=parseInt(req.params.x)+parseInt(req.params.y);
    res.send(`sum is ${z} `);
    res.status(200).send("Welcome to sum");
})
// app.get("/sum",(req,res)=>{
    
//     var x=req.query.num1;
//     var y=req.query.num2;
//     res.send(`sum is ${x+y} `);
// })

app.get('/success', (req, res) => {
    res.status(200).send("Request successful");
  });
  
app.listen(3500,()=>{
    console.log("Server is running...");
});