import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router-dom";
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
                        </ul>
                    </div>
                </div>
            </nav>
            <div class='table-responsive'>
                <table class='table'>
                    <thead>
                        <tr style={{
                            backgroundColor: '#8D6E63'
                        }}>
                            <th>ISIN</th>
                            <th>Issuer Name</th>
                            <th>Coupon</th>
                            <th>Mature Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            <tr style={{
                                backgroundColor: '#A1887F'
                            }}>
                                <td>{values.id}</td>
                                <td>{values.isin}</td>
                                <td>{values.coupon}</td>
                                <td>{values.maturity_date}</td>
                            </tr>
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default BondDetail;