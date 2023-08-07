import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function MyBonds(){

    const [security, setSecuirty] = useState([])
    const userName = localStorage.getItem("username");
    const nav = useNavigate();
    
    function getSecurity(){
      console.log(userName)
        axios.get("http://localhost:8080/myBonds", {
          params:{
            username:userName
          }
        }).then((response)=>{
        setSecuirty(response.data);
        console.log(response.data);

        })
        .catch((err)=>console.log(err))
    }
    useEffect(()=>{
        getSecurity();
    },[])

    function goToBond(bondID) {
      axios.get("http://localhost:8080/bondSecurity/" + bondID).then((response) => {
        console.log(response.data)
        nav('/bonddetail/' + bondID)
        console.log(bondID)
      })
        .catch((err) => console.warn(err))
    }

    return(
        <div>
         <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
          <div className="container-fluid">
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#mynavbar"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="mynavbar">
              <ul className="navbar-nav me-auto">
                <li className="nav-item">
                  <div className="btn-group">
                    <ul className="dropdown-menu">
                      <li>
                        <a className="dropdown-item" href="/login">
                          Login
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/home">
                    Home
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/allBonds">
                    All Bonds
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/mybonds">
                    My Bonds
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/specificbonds">
                    Specific Bond
                  </a>
                </li>
                <li className="nav-item">
                <a className="nav-link " href="/">
                  Logout
                </a>
              </li>
              </ul>
            </div>
          </div>
        </nav>

        {/* <marquee scrollAmount='20' style={{
                            backgroundColor: '#FFCCBC'}}>Welcome to MyBonds section!</marquee> */}

        <div class='table-responsive' >
            <table class='table' >
                <thead>
                    <tr style={{
        backgroundColor: '#969996'}}>
                        <th>ISIN</th>
                        <th>Issuer Name</th>
                        <th>Coupon</th>
                        <th>Mature Date</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    {
                      security.map((sec) =>{
                        return(
                          <tr style={{
                            backgroundColor: '#969996'}} >
                          <td>{sec.isin}</td>
                          <td>{sec.issuer_name}</td>
                          <td>{sec.coupon}</td>
                          <td>{sec.maturity_date}</td>
                          <td>

                      <button type="button" class="btn" onClick={() => {
                        goToBond(sec.id)
                        console.log(sec.id)
                      }
                      }>
                        <i class="fa fa-info"></i>
                      </button>
                    </td>

                        </tr>
                      )})
                        
                        
                    }
                  
                </tbody>
            </table>
        </div>
        
    </div>
    );
}

export default MyBonds;