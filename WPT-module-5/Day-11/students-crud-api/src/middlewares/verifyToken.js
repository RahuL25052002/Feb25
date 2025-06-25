export function varifyToken(request,response,next){
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