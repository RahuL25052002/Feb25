

import express, { request, response } from 'express';
import { WELCOME_TO_HOME} from './responses';
import {SOMETHING_WENT_WRONG} from './responses';
import { INVALID_VALUE } from './responses';
const portnumber=9400;
import {StatusCodes} from  'http-status-codes';

const app=express();
app.use(express.json());

app.get("/",(request,response)=>{
    response.status(200).send({msg:WELCOME_TO_HOME});

})

app.get("/factorial/:n",(request,response)=>{
    try{
        var n=parseInt(request.params.n);
        if(n>0){
            var fact=1;
            for(let i=1;i<=n;i++){
                fact=fact*i;
            }
            response.status(200).send({msg:`Factorial of ${n} is ${fact}`});
        }else{
            response.status(400).send({msg:INVALID_VALUE});
        }

    }catch(err){
        response.status(500).send({msg:SOMETHING_WENT_WRONG});
    }
})

app.post("/product",(request,response)=>{
    try{
        const data=request.body;
        var result=data.x*data.y;
        response.status(200).send({product:result})
    }catch(err){
        response.status(500).send({msg:SOMETHING_WENT_WRONG});
    }
})

app.listen(portnumber,()=>{
    console.log(`Server is running on ${portnumber}`)
})
