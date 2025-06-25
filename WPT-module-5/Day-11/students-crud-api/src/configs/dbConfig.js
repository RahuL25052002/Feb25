import mysql from 'mysql2';
export const  var1=function createDbConnection(){
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
