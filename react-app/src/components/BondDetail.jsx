import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router-dom";
import "../App.css"

function BondDetail() {

    const { id } = useParams();
    const [values, setValue] = useState([]);

    function getDet() {
        console.log(id)
        axios.get("http://localhost:8080/bondSecurity/" + id).then((response) => {
            console.log(response.data)
            setValue(response.data)
        })
            .catch((err) => console.warn(err))
    }

    useEffect(() => {
        getDet();
    }, [])

    return (
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

            {/* <div class='table-responsive'>
                <table class='table'>
                    <thead>
            <tr style={{
              backgroundColor: '#969996'
            }}>
                            <th>ID</th>
                            <th>ISIN</th>
                            <th>CUSIP</th>
                            <th>Issuer Name</th>
                            <th>Coupon</th>
                            <th>Maturity Date</th>
                            <th>Type</th>
                            <th>Face Value</th>
                            <th>Currency</th>
                            <th>Status</th>
                            <th>Bond Holder</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            <tr class="table-row-styling">
                                <td>{values.id}</td>
                                <td>{values.isin}</td>
                                <td>{values.cusip}</td>
                                <td>{values.issuer_name}</td>
                                <td>{values.coupon}</td>
                                <td>{values.maturity_date}</td>
                                <td>{values.type}</td>
                                <td>{values.face_value}</td>
                                <td>{values.currency}</td>
                                <td>{values.status}</td>
                                <td>{values.bond_holder}</td>
                            </tr>
                        }
                    </tbody>
                </table>
            </div> */}

<div className="centered-div-bond"> 
<h3>Details of Bond  {values.id}</h3>
<p>ISIN: {values.isin}</p>
<p>CUSIP: {values.cusip}</p>
<p>Issuer Name: {values.issuer_name}</p>
<p>Coupon: {values.coupon}</p>
<p>Maturity Date: {values.maturity_date}</p>
<p>Type: {values.type}</p>
<p>Face Value: {values.face_value}</p>
<p>Currency: {values.currency}</p>
<p>Status: {values.status}</p>
<p>Bond Holder: {values.bond_holder}</p>
</div>

        </div>
    )
}

export default BondDetail;