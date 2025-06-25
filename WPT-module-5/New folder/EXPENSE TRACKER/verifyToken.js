import jwt from 'jsonwebtoken';
export function verifyToken(req,res,next){
    const authheader=req.get('Authorization');

  

    if(authheader){
        const token=authheader.split(" ")[1];
        jwt.verify(token,"rahul123",(err,result)=>{
            if(err){
                res.status(400).send({msg:"Token is invalid"})
            }else{
                console.log(result.userId);
                req.userId=result.userId;
                next();
            }
        });
    }else{
        res.status(500).send({msg:"Token is missing"});
    }
}