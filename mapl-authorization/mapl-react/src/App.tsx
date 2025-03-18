import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import NavigatorComponent from './component/NavigatorComponent';
import PostCreate from "./PostCreate";
import PostList from "./PostList";

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className="container">
      
      <h1>Create Post</h1>
      <PostCreate />
      <hr />
      <h1>Posts</h1>
      <PostList />
 
      <NavigatorComponent />
 
      </div>
    </>
  )
}

export default App
