//write basic express boilerplate 
//with express.json()  middleware
const express=require("express");
const { createTodo, updateTodo } = require("./type");
const {todo}=require("./db");
const cors=require("cors")
const app=express();

app.use(express.json());
app.use(cors());

//body{
    //title string
    //descrption string
//}
app.post("/todo",async function(req,res){
    const createPayload= req.body;
    const parsedPayload=createTodo.safeParse(createPayload);
    if(!parsedPayload.success){
        res.status(411).json({
            msg:"You sent the wrong inputs"
        })
        return;
    }
    //put it in mongodb
    await todo.create({   //here await because we try to first completed the creation then response will be send
        title: createPayload.title,
        description: createPayload.description,
        completed: false
    })
    res.json({
        msg:"Todo created"
    })
})

app.get("/todos",async function(req,res){
    const todos=await todo.find({//await because wait to first data get from database
});
    res.json({
        todos
    })

})

app.put("/completed",async function(req,res){
    const updatePayload= req.body;
    const parsedPayload=updateTodo.safeParse(updatePayload);
    if(!parsedPayload.success){
        res.status(411).json({
            msg:"You sent the wrong inputs"
        })
        return;
    }

    await todo.updte({
        _id: req.body._id//_id present in mongodb 
    },{
        completed: true
    })

    res.json({
        msg:"Todo marked as completed"
    })
});

app.delete("/todo/:id", async (req, res) => {
    const id = req.params.id;

    try {
        await Todo.findByIdAndDelete(id);
        res.status(200).json({ message: "Todo deleted" });
    } catch (err) {
        res.status(500).json({ error: "Failed to delete todo" });
    }
});

app.listen(3000,()=>{
    console.log("Sever is running");
})