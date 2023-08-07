import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
function Home(){

    const [security, setSecuirty] = useState([])
    function getSecurity(){
        axios.get("http://localhost:8080/allSecurities").then((response)=>{
        setSecuirty(response.data);
        })
        .catch((err)=>console.log(err))
    }
    useEffect(()=>{
        getSecurity();
    },[])

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
                  <a className="nav-link " href="/home">
                    All Bonds
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/mybonds">
                    My Bonds
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>



        <div class='table-responsive'>
            <table class='table'>
                <thead>
                    <tr style={{backgroundColor: '#8D6E63'}}>
                        <th>ISIN</th>
                        <th>Issuer Name</th>
                        <th>Coupon</th>
                        <th>Mature Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        security.map((res => {
                            return (
                                <tr style={{
                                  backgroundColor: '#A1887F'}}>
                                    <td>{res.isin}</td>
                                    <td>{res.issuer_name}</td>
                                    <td>{res.coupon}</td>
                                    <td>{res.maturity_date}</td>
                                </tr>
                            )
                        }))
                    }
                </tbody>
            </table>
        </div>
        
    </div>
    );
}

export default Home;