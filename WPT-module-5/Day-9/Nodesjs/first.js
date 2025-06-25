// const express=require('express');
const fs=require("fs");

// // fs.read('abc.txt');
// fs.writeFile("Myfile.txt","Hello world",(error)=>{
//     if(!error){
//         console.log("Write operation completed!");

//     }else{
//         console.log("Write operation failed!");
//     }
// })
// ;
// console.log("After write operation")

fs.readFile("Myfile.txt",(error,data)=>{

        if(!error){
            console.log(data.toString());
        }else{
            console.log(error);
        }

});
console.log("After reading file")