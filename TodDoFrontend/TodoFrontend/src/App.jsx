import { useState,useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Todos } from './Components/Todos'
import { CreateTodo } from './Components/CreateTodo'
function App() {
  // const [count, setCount] = useState(0)
  const [todos,setTodos] = useState([])
  const fetchTodos = async () => {

      const response = await fetch('http://localhost:8080/auth/todos');
      if (!response.ok) {
        throw new Error('Failed to fetch todos');
      }
      const json = await response.json();
      setTodos(json);
   
  };
  useEffect(() => {
    fetchTodos().then(function (res){
     console.log(res)
    })
  } , []);
  
  return (
    <>
      {/* <p>Hid</p> */}
      <CreateTodo refreshTodos={fetchTodos}/>
      <Todos todos = {todos} refreshToDoList={fetchTodos}></Todos>
    </>
  )
}

export default App
