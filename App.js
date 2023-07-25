import React from "react" 
import Homepage from "./pages/HomePage";
import UserSignupPage from "./pages/UserSignUpPage";
import {Routes,Route,Redirect} from 'react-router-dom'
function App() {
  return (
      
        <Routes>
          <Route exact path="/" element={<Homepage/>}/>
          <Route path="/signup" element={<UserSignupPage/>}/>
          
        </Routes>
      
 
  
  );
}

export default App;
