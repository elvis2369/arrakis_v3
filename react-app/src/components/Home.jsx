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
        <div class='table-responsive'>
            <table class='table'>
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
                        security.map((res => {
                            return (
                                <tr>
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
    );
}

export default Home;