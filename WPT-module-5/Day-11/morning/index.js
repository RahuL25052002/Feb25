


import express, { request, response } from 'express';

const app=express();


const mymiddleware=(request,response,next)=>{
    console.log("inside middleware");
    next();
};

app.use(mymiddleware)

//this way we can write middleware also
// app.use((request,response,next)=>{
//     console.log("inside middleware");
//     next();
// });


app.use(express.json());
app.get("/",mymiddleware,(request,response)=>{
    response.send("Welconme to app!!");
});

// app.post('/sum',mymiddleware,(request,response)=>{
//     // request.params//it will give url parameters
//     var data=request.body;//it will give data pass in the request body
//    //express app dosnt know that any of the request contain the request body

//     console.log(data);
//     response.send("Sum");

// });
app.post('/sum',(request,response)=>{
    // request.params//it will give url parameters
    var data=request.body;//it will give data pass in the request body
   //express app dosnt know that any of the request contain the request body

    console.log(data);
    response.send("Sum");

});

app.listen(3000,()=>{
    console.log("Server is running....")
})