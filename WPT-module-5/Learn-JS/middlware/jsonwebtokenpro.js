
const express=require('express');

const app=express();

const jwt=require('jsonwebtoken');

const value={
    name:"Rahul",
    accountnumber:123432
}

const token=jwt.sign(value,"Secret");

const ver=jwt.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiUmFodWwiLCJhY2NvdW50bnVtYmVyIjoxMjM0MzIsImlhdCI6MTc0NjM5MzY4M30.Ctwgbt0Pnw1NDhabVo__0Ey1lTcfrBg50Ch4dIUkiQ0","Secret");
console.log(token);
console.log(ver)