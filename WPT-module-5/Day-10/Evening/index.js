
import {createServer} from 'http';

var server=createServer((req,res)=>{
    res.write("Hello world");
    res.write("Kya chal raha hai");
    res.write("Dom ata hai kya ?");
 
    res.end();
});


server.listen(3000,()=>{
    console.log("Server started");
});