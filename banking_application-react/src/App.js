import {BrowserRouter , Routes , Route} from "react-router-dom"
import './App.css';
import Login from "./components/Login"
import Registration from "./components/Registration"

const App=()=>{
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Registration />} />

        </Routes>
      </BrowserRouter>
    </>
    
  )
}
export default App