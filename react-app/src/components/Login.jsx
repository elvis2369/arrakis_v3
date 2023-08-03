import React from "react";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
  });
  const navigate = useNavigate();
  const takeInput = (e) => {
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });
  };

  const submitLogin = (e) =>{
    e.preventDefault()
    console.log(credentials)
    axios.post("http://localhost:8080/login",null,{params:{
      ...credentials
    }}).then(async (response)=>{
          if(response.status == 200){
            console.log('test')
            // const user = await axios.get("http://localhost:5000/api/users/"+credentials.email)
            // console.log(user.data[0])
            // localStorage.setItem("userEmail",user.data[0].Email)
            // localStorage.setItem("userType",user.data[0].Tip_user)
            // localStorage.setItem("userID",user.data[0].Utilizator_ID)
            navigate('/home')
          }
        }).catch(err => console.warn(err));
  }
  return (
    <div className="mainLogin">
      <div class="container d-flex align-items-center justify-content-center pt-5">
        <div class="row">
          <div class="col-sm-12 px-5">
            <h1 class="text-center my-5"> Login</h1>
            <form>
              <div class="mb-3 mt-3">
                <label htmlFor="username" class="form-label">
                  Username:
                </label>
                <input
                  type="username"
                  class="form-control"
                  id="username"
                  placeholder="Enter username"
                  name="username"
                  value={credentials.username}
                  onChange={takeInput}
                />
              </div>
              <div className="mb-4 mt-3">
                <label htmlFor="password" class="form-label">
                  Password:
                </label>
                <input
                  type="password"
                  class="form-control"
                  id="userPassword"
                  placeholder="Enter password"
                  name="password"
                  value={credentials.password}
                  onChange={takeInput}
                  ></input>
              </div>
              <div class="text-center">
                <button type='submit' class="btn btn-dark mb-3 " onClick={submitLogin}>Submit Login</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
