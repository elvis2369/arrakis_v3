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
                    <tr>
                        <th>ISIN</th>
                        <th>Issuer Name</th>
                        <th>Coupon</th>
                        <th>Matur Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        <tr>
                            <td>{values.id}</td>
                            <td>{values.isin}</td>
                            <td>{values.status}</td>
                            <td>{values.coupon}</td>
                        </tr>
                    }
                </tbody>
            </table>
        </div>
    )
}

export default BondDetail;