

const express=require('express');

const app=express();

function userMiddleware(req,res,next){
    var username=req.headers.username;
    var password=req.headers.password;

    if(username!="Rahul" || password!="123"){
        res.status(404).send({
            msg:"Username and password required..."
        })
        return;
    }else{
        next();
    }
}

function kidneyMiddleware(req,res,next){

    var kidney=req.query.kidney;
    if(kidney!=1 && kidney!=2){
        res.status(404).send({
            msg:"Kidney invalid."
        })
        return;
    }else{
        next();
    }
}


//BY using middlewares we minmize the code in very small way
app.get("/health",userMiddleware,kidneyMiddleware,(req,res)=>{
    // var kidney=req.query.kidney;
    // var username=req.headers.username;
    // var password=req.headers.password;

    // if(username!="Rahul" || password!="123"){
    //     res.status(404).send({
    //         msg:"Username and password required..."
    //     })
    //     return;
    // }
    // if(kidney!=1 && kidney!=2){
    //     res.status(404).send({
    //         msg:"Kidney invalid."
    //     })
    //     return;
    // }
    res.status(200).send({
        msg:"Kidney is valid"
    })
})
app.listen(3000,()=>{
    console.log("Server is running...")
})