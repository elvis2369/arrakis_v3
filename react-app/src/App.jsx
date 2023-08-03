import React from "react";
import { BrowserRouter,Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
function App() {
  return(
   <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route index element={<Login />} />
          <Route path="/login" element={<Login />}/>
          <Route path="/home" element={<Home/>}/>
        </Route>
      </Routes>
   </BrowserRouter> 
  );
};

export default App;
