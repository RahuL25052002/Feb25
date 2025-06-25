import { DemoComponent } from './DemoComponent';
import {MyComponent} from './MyComponent';
import {Navbar} from './Navbar';
import {Home} from './Home';
import { About } from './About';
import { Contact } from './Contact';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {

  return (
    <div>
      {/* <MyComponent text='hello world' heading='welcome to My component'></MyComponent>
      <DemoComponent text="Example dummy content" heading="Welcome to demoComponent"></DemoComponent> */}
      {/* It becomes the class level property props
      in the function component its an argument but 
      in the class component its becomes the class level property 
       */}

       <Navbar></Navbar>
       <BrowserRouter>
       <Routes>
              <Route path="/" element={<Home></Home>}></Route>
              <Route path="/about" element={<About></About>}></Route>
              <Route path="/contact" element={<Contact></Contact>}></Route>
       </Routes>
       </BrowserRouter>
       
      
    </div>
  )
}

export default App
