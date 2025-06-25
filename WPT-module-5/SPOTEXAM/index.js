
import express from 'express';
import mysql from 'mysql2';
const app=express();

app.use(express.json());
const conn=mysql.createConnection({
    host:"localhost",
    user:"rahul",
    password:"cdac",
    database:"spot"
})

conn.connect(function(err){
    if(err){
        console.log(err);
    }else{
        console.log("Db connected..");
    }
})


app.post("/employees",(req,res)=>{
    try{
        const data=req.body;
        const qry=`insert into employee values(${data.id},'${data.name}','${data.email}',${data.sal})`;
        conn.query(qry,(err,result)=>{
            if(err){
                if(err.errno==1062){
                    res.status(400).send({msg:"Duplicate id not allowed"})
                }
                res.status(400).send({msg:"Error in adding data"});
            }else{
                console.log(result);
                res.status(200).send({msg:"Employee added"});
            }
        })
    }catch(err){
        res.status(500).send({msg:"Server error"})
    }
    
})

app.get("/employees",(req,res)=>{
    try{
        const qry=`select * from employee`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in data"});
            }else{
                console.log(result);
                res.status(200).send({msg:"Get the data"});
            }
        })

    }catch(error){
        res.status(500).send({msg:"Error in server side"})
    }
})

app.put("/employee/:id",(req,res)=>{
    try{
        const id=req.params.id;
        const data=req.body;
        const qry=`update employee set name='${data.name}' , email='${data.email}', sal=${data.sal} where id=${id}`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in data not updated"})
            }else{
                res.status(200).send({msg:"Employee value updated"});
            }
        })
    }catch(err){
        res.status(500).send({msg:"Error in server side"})
    }
})
app.delete("/employee/:id",(req,res)=>{
    try{
        const id=req.params.id;
        const qry=`delete from employee where id=${id}`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in data not deleted"})
            }else{
                res.status(200).send({msg:"Employee deleted"});
            }
        })
    }catch(err){
        res.status(500).send({msg:"Error in server side"})
    }
})
app.listen(3000,()=>{
    console.log("Server is running...")
})