import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router-dom";
function BondDetail(){
    const {id} = useParams();
    const [values, setValue] = useState([]);
    function getDet(){
        console.log(id)
        axios.get("http://localhost:8080/bondSecurity/"+id).then((response)=>{
            console.log(response.data)
            setValue(response.data)
        })
        .catch((err)=> console.warn(err))
    }
    useEffect(()=>{
        getDet();
    },[])
    return(
        <div class='table-responsive'>
            <table class='table'>
                <thead>
                    <tr style={{
                            backgroundColor: '#8D6E63'}}>
                        <th>ISIN</th>
                        <th>Issuer Name</th>
                        <th>Coupon</th>
                        <th>Mature Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        <tr style={{
                            backgroundColor: '#A1887F'}}>
                            <td>{values.id}</td>
                            <td>{values.isin}</td>
                            <td>{values.coupon}</td>
                            <td>{values.maturity_date}</td>
                        </tr>
                    }
                </tbody>
            </table>
        </div>
    )
}

export default BondDetail;