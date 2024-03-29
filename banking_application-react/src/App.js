import {BrowserRouter , Routes , Route} from "react-router-dom"
import './App.css';

import Login from "./components/Login"
import Registration from "./components/Registration"
import Home from "./components/Home"
import AddAccount from "./components/AddAccount";
import AddMoney from "./components/AddMoney";
import SendMoney from "./components/SendMoney";
import Statement from "./components/Statement";
 import Navbar from "./components/Navbar";
const App=()=>{
  return (
    <>
    <Navbar/>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Registration />} />
          <Route path="/home" element={<Home />}/>
          <Route path="/addAcc" element={<AddAccount/>}/>
          <Route path="/addMoney/:accountId" element={<AddMoney/>}/>
          <Route path="/sendMoney/:accountNumber" element={<SendMoney/>}/>
          <Route path="/statement/:accountNumber" element={<Statement/>}/>
        </Routes>
      </BrowserRouter>
    </>
    
  )
}
export default App