

const zod=require('zod');
const express=require('express');
const app=express();
function validateInput(obj){
    // const schema=zod.array(zod.number())

    const schema=zod.object({
        email:zod.string().email(),
        password:zod.string().min(5)
    })

    const response=schema.safeParse(obj)
    console.log(response);
    return response;
}

app.post("/login",(req,res)=>{
    const Valid=validateInput(req.body);
    if(!Valid.success){
        res.status(411).send({
            msg:"Invalid inputs"
        })
    }else{
        res.status(200).send({
            msg:"Valid credintials"
        })
    }
})

app.listen(3000,()=>{
    console.log("Server is running..")
})
// validateInput({
//     email:"Rahul@123",
//     password:"123456786"
// })

