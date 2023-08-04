import axios from "axios";
import React from "react";
import { useState } from "react";
import { useEffect } from "react";

function SpecificBonds() {

    const [bonds, setBond] = useState([]);
    useEffect(()=>{
        getSpecificBonds();
    },[])

    const getSpecificBonds = (e) =>{
        e.preventDefault();
        axios.get("http://localhost:8080/allSecurities")
        .then((response)=>{
            setBond(response.data);
        })
    }
  return (
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
                  All Bonds
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
              <th>ISIN</th>
              <th>Issuer Name</th>
              <th>Coupon</th>
              <th>Matur Date</th>
            </tr>
          </thead>
          <tbody>
            {
                bonds.filter((bond) =>{
                    if(bond.maturity_date){

                    }
                }).map((bond) =>{
                    return(
                        <tr>
                            <td>{bond.maturity_date}</td>
                        </tr>
                    )
                })
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default SpecificBonds;
