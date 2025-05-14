
const mongoose=require("mongoose");
import {CONNECTION_STRING} from "./.env"
mongoose.connect(CONNECTION_STRING)

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
