
import express, { response } from 'express';
import { request } from 'http';
import {StatusCodes} from 'http-status-codes';
import { hashSync } from 'bcrypt';
import jwt from 'jsonwebtoken';
const app=express();
const PORT=3000;
// const mysql=require('mysql2');
import mysql from 'mysql2';

function createDbConnection(){
    const con=mysql.createConnection({
        host:"localhost",
        user:"root",
        password:"cdac",
        database:"april_end"
    });
    con.connect(function(err){
        if(err){
            console.log(err);
        }else{
            console.log("Connected db...")
        }
    });
    return con;
}

const conn=createDbConnection();




app.use(express.json());//for process the request body




function varifyToken(request,response,next){
    const authHeader=request.get('Authorization');
    if(authHeader){
        const token=authHeader.split(" ")[1];
        jwt.verify(token,"hello123",(error,payload)=>{
            if(error){
                response.status(StatusCodes.UNAUTHORIZED).send({
                    msg:"Token is inValid"
                })
            }else{
                next();
            }
        });
        next();
    }else{
        response.status(StatusCodes.UNAUTHORIZED).send({
            msg:"Token is missing"
        })
    }
}


app.post("/admin",(request,response)=>{
    try{
        const data=request.body;
        const encryptPassword=hashSync(data.password,10);
        data.password="";
        const qry=`insert into admin values(${data.id},'${data.name}','${data.username}','${encryptPassword}')`;
        conn.query(qry,function(err,result){
            if(err){
                response.status(400).send({
                    msg:"Something went wrong"
                });
            }else{
                response.status(200).send({
                    msg:"admin Registered"
                });
            }
        })
    }catch(err){
        response.status(500).send({
            msg:"Something went wrong"
        });
    }
})


app.post("/admin/login",(request,response)=>{
    try{
        const requesData=request.body;
        const  qry=`select * from admin where username='${requesData.username}'`;
        conn.query(qry,(error,result)=>{
            if(error){
                response.status(400).send({
                    msg:"Something went wrong"
                });
            }else{
                response.status(200).send({
                    msg:"Get the data"
                });
                response.status(200).send(result);
            }
        })
    }catch(err){
        response.status(500).send({
            msg:"Something went wrong"
        });
    }
})

app.post("/student",varifyToken,(request,response)=>{
    try{
        const data=request.body;
        const qry=`insert into student values(${data.id},'${data.name}','${data.phone}',${data.marks})`;
        conn.query(qry,function(err,result){
            if(err){
                response.status(400).send({
                    msg:"Something went wrong"
                });
            }else{
                response.status(200).send({
                    msg:"Student Registered"
                });
            }
        })
    }catch(err){
        response.status(500).send({
            msg:"Something went wrong"
        });
    }
})

app.get("/student",varifyToken,(request,response)=>{
    try{
        const  qry='select * from student';
        conn.query(qry,(error,result)=>{
            if(error){
                response.status(400).send({
                    msg:"Something went wrong"
                });
            }else{
                response.status(200).send({
                    msg:"Get the data"
                });
                response.status(200).send(result);
            }
        })
    }catch(err){
        response.status(500).send({
            msg:"Something went wrong"
        });
    }
});
app.get("/student/:id",(request,response)=>{
    try{
        const id=parseInt(request.params.id);
        const  qry=`select * from student where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                response.status(400).send({
                    msg:"Something went wrong"
                });
            }else{
                // response.status(200).send({
                //     msg:"Get the data"
                // });
                if(result.length===0){
                    response.status(400).send({msg:`student with id ${id} not found`});
                }else{
                    response.status(200).send(result);
                }

            }
        })
    }catch(err){
        response.status(500).send({
            msg:"Something went wrong"
        });
    }
});

app.get("/",(request,response)=>{
    response
    .status(200)
    .send({
        msg:"Welcome to student CRUD"
    });
})


app.delete("/student/:id",(req,res)=>{
    try {
        const id = parseInt(request.params.id);
        const qry =`delete from student where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in fetching data'});
            }
            else{
                response.status(StatusCodes.OK).send({message:'Student Deleted!'}); 
                
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }

});

app.put("/student/:id",(request,response)=>{
    try {
        const id = parseInt(request.params.id);
        const data = request.body;
        const qry =`update student set name='${data.name}', phone='${data.phone}', marks='${data.marks}' where id=${id}`;
        conn.query(qry,(error,result)=>{
            if(error){
                console.log(error);
                response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Problem in updating data'});
            }
            else{
                response.status(StatusCodes.OK).send({message:'Student Updated!'}); 
                
            }
        });
    } catch (error) {
        response.status(StatusCodes.INTERNAL_SERVER_ERROR).send({message:'Something went wrong'});
    }
});


app.listen(PORT,()=>{
    console.log(`Server is running on ${PORT}`)
    ;
});

