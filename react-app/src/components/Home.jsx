import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
function Home(){

    const [security, setSecuirty] = useState([])
    const nav = useNavigate();
    function getSecurity(){
        axios.get("http://localhost:8080/allSecurities").then((response)=>{
        setSecuirty(response.data);
        })
        .catch((err)=>console.log(err))
    }
    useEffect(()=>{
        getSecurity();
    },[])

    function goToBond(bondID){
        axios.get("http://localhost:8080/bondSecurity/"+bondID).then((response)=>{
            console.log(response.data)
            nav('/bonddetail/'+bondID)
            console.log(bondID)
        })
        .catch((err)=> console.warn(err))
    }
    function funcDate(d1, d2){

    }
    return(
        <div>
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark my-3">
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
                  <a className="nav-link " href="/home">
                    Home
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link " href="/allbonds">
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
                <thead style={{
                                  width: 100+'%'}}>
                    <tr style={{
                            backgroundColor: '#969996'}}>
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
                                  backgroundColor: '#969996'}}>
                                    <td>{res.id}</td>
                                    <td>{res.issuer_name}</td>
                                    <td>{res.coupon}</td>
                                    <td>{res.maturity_date}</td>
                                <td style={{
                            backgroundColor: '#969996'}}>
                                <button type="button" class="btn" onClick={() =>{
                                    goToBond(res.id)
                                    console.log(res.id)
                                }
                                    }>
                                  <i class="fa fa-info"></i>
                                </button>
                              </td>
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