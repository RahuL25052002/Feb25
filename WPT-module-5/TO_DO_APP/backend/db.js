
const mongoose=require("mongoose");

mongoose.connect("mongodb+srv://rahul:Rahul%40123456789@cluster0.warq1.mongodb.net/todos");
//mongodb+srv://rahul:Rahul%40123456789@cluster0.warq1.mongodb.net/

const  todoSchema=mongoose.Schema({
    title: String,
    description: String,
    completed: {
        type:Boolean,
        default: false
    }
})

const todo=mongoose.model('todos', todoSchema)

module.exports={
    todo
}