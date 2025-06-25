import express, { request, response } from 'express';

const app=express();


app.get("/",(request,response)=>{
    response.send("welcome!!");
});

app.get("/fact/:num",(request,response)=>{
    var num=request.params.num;

    var fact=1;
    for(let i=1;i<=num;i++){
        fact=fact*i;
    }

    if(fact<0){
        response.status(400).send("Error: Wrong inputs!!");
    }else{
        response.status(200).send(`Factorail of ${num} is ${fact}`);
    }
});
app.listen(3000,()=>{
    console.log("Server is running...");

})