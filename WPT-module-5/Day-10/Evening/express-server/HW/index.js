
import express, { request, response } from 'express';// "type": "module", we have to add this in the json file so it ecma standard thats why

const app=express();

app.get("/",(request,response)=>{
    response.send("Welcome to app");
});

app.get("/:age",(request,response)=>{
    if(request.params.age>=18){
        response.status(200).send("validate user for voting");
    }else{
        response.status(404).send("Baccha hai abhi to !!");
    }
});

app.get("/candidate/:age",(request,response)=>{
    var age=request.params.age;
    if(age<21){
        response.status(404).send("Not applicablle Candidate For Election....")
    }else{
        response.status(200).send("Appicable candidate for Election");
    }
})
app.listen(3000,()=>{
    console.log("Server is running....");
});

//we install nodemon for not start server again and again after installing nodemon it can automatically restart server if any update done