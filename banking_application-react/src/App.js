import {BrowserRouter , Routes , Route} from "react-router-dom"
import './App.css';
import Login from "./components/Login"
import Registration from "./components/Registration"
import Home from "./components/Home"
import AddAccount from "./components/AddAccount";
const App=()=>{
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Registration />} />
          <Route path="/home" element={<Home />}/>
          <Route path="/addAcc" element={<AddAccount/>}/>
        </Routes>
      </BrowserRouter>
    </>
    
  )
}
export default App