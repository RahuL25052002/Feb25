

const express =require('express');
// const { request } = require('http');
const zod =require('zod');

const schema=zod.array(zod.number());

const app=express();
app.use(express.json());
const PORT=5600;

app.post("/health",(req,res)=>{
    const kidney=req.body.kidney;
    const response=schema.safeParse(kidney);


    if(!response.success){
        res.status(411).send("Invalid kidney");
        return;
    }else{
        res.status(200).send("Valid kidney")
    }

})

// app.post("/health",(request,response)=>{
//     var kidney=request.body.kidneys;
//     var len=kidney.length;
//     response.send({
//         msg:`length of kidney ${len}`
//     })
// })

// //Global catche means any error or exception happen the it handel in the given middleware
// app.use(function(err,req,res,next){
//     res.json({
//         msg:"Something went wrong with the server..."
//     })
// })
app.listen(PORT,()=>{
    console.log("Server is Running..")
});