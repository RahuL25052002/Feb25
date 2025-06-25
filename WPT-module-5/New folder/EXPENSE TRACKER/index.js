import express from 'express';
import jwt from 'jsonwebtoken';
import cors from 'cors';
import mysql from 'mysql2';
import { compareSync, hashSync } from 'bcrypt';
import { verifyToken } from './verifyToken.js';
const PORT=9800;

const SECRET_KEY="rahul123"

const app=express();

app.use(express.json())


const conn=mysql.createConnection({
    host:"localhost",
    user:"rahul",
    password:"cdac",
    database:"Expense"
})
conn.connect((err)=>{
    if(err){
        console.log(err);
    }else{
        console.log("Db connected....")
    }
})


app.post("/user",(req,res)=>{
    try{
        const reqdata=req.body;
        const hasPass=hashSync(reqdata.password,10);
        const qry=`insert into user values(${reqdata.id},'${reqdata.name}','${reqdata.phone}','${reqdata.email}','${hasPass}')`;

        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in registraiton"})
            }else{
                res.status(200).send({msg:"User register"});
            }
        })

    }catch(err){
        res.status(500).send({msg:"Server side error"})
    }
})
app.post("/user/login",(req,res)=>{
    try{
        const reqdata=req.body;
        const qry=`select * from user where email='${reqdata.email}'`;

        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in registraiton"})
            }else{
                if(result.length===0){
                    res.status(400).send({msg:"Username or passowrd invalid"})
                }else{
                   if(compareSync(reqdata.password,result[0].password)){
                        const token=jwt.sign({userId:result[0].id},"rahul123");
                        res.status(200).send({msg:"Login ",token})
                   }else{
                    res.status(400).send({msg:"Invalid passowrd"});
                   }
                  
                }
               
            }
        })

    }catch(err){
        res.status(500).send({msg:"Server side error"})
    }
})


app.post("/income",verifyToken,(req,res)=>{
    try{
        const data=req.body;
        const loggedInUSerId=req.userId;
        // res.status(200).send({msg:"Hello"})
        const qry=`insert into income values(${data.id},${data.amount},'${data.tx_date}','${data.source}',${loggedInUSerId})`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in saving income record"});
            }else{
                res.status(200).send({msg:"Income record saved"})
            }
        })

    }catch(error){
        res.status(500).send({msg:"Server side error"})
    }
})
app.post("/expense",verifyToken,(req,res)=>{
    try{
        const data=req.body;
        const loggedInUSerId=req.userId;
        // res.status(200).send({msg:"Hello"})
        const qry=`insert into expense values(${data.id},${data.amount},'${data.tx_date}','${data.source}',${loggedInUSerId})`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in saving income record"});
            }else{
                res.status(200).send({msg:"expense record saved"})
            }
        })

    }catch(error){
        res.status(500).send({msg:"Server side error"})
    }
})


app.get("/income",verifyToken,(req,res)=>{
    try{
        const data=req.body;
        const loggedInUSerId=req.userId;
        // res.status(200).send({msg:"Hello"})
        const qry=`select * from income where id:${loggedInUSerId}`;
        conn.query(qry,(err,result)=>{
            if(err){
                res.status(400).send({msg:"Error in saving income record"});
            }else{
                res.status(200).send({msg:"expense record saved"})
            }
        })

    }catch(error){
        res.status(500).send({msg:"Server side error"})
    }
})

app.listen(PORT,()=>{
    console.log("Server is running....")
})
