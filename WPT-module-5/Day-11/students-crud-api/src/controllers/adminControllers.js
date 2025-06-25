
import { hashSync } from "bcrypt";
import { StatusCodes } from "http-status-codes";
import {getConnectionObject} from '../configs/dbConfig.js'
const conn=getConnectionObject();

import jwt from 'jsonwebtoken';
export function RegisteredAdmin(){
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
}
