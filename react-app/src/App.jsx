import React from "react";
import { BrowserRouter,Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import BondDetail from "./components/BondDetail";
import AllBonds from "./components/AllBonds";
import MyBonds from "./components/MyBonds";

function App() {
  return(
   <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route index element={<Login />} />
          <Route path="/login" element={<Login />}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/bonddetail/:id" element={<BondDetail/>}/>
          <Route path="/allbonds" element={<AllBonds/>}/>
          <Route path="/mybonds" element={<MyBonds/>}/>
        </Route>
      </Routes>
   </BrowserRouter> 
  );
};

export default App;
