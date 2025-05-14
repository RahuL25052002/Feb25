import {useEffect,useState } from 'react'
import './App.css'
import { CreateTodo} from './Components/CreateTodo'
import { Todos } from './Components/Todos'
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  const [todos,setTodos] =useState([]);

  // fetch("http://localhost:3000/todos").then(async function(res){
  //   const json=await res.json();
  //   setTodos(json.todos)
  // })

  useEffect(() => {
    fetch("http://localhost:3000/todos")
      .then(async (res) => {
        const json = await res.json();
        setTodos(json.todos);
      })
      .catch((err) => console.error("Error fetching todos:", err));
  }, []);

  return (
    <div>
      <CreateTodo></CreateTodo>
      <Todos todos={todos}></Todos>
    </div>
  )
}

export default App