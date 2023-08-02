import React from "react";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  const [credentials, setCredentials] = useState({
    email: "",
    password: "",
  });
  const navigate = useNavigate();
  const takeInput = (e) => {
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });
  };

  function submitLogin(){
    navigate('/register')
  }
  return (
    <div className="mainLogin">
      <div class="container d-flex align-items-center justify-content-center pt-5">
        <div class="row">
          <div class="col-sm-12 px-5">
            <h1 class="text-center my-5"> Login</h1>
            <form>
              <div class="mb-3 mt-3">
                <label htmlfor="email" class="form-label">
                  Email:
                </label>
                <input
                  type="email"
                  class="form-control"
                  placeholder="Email"
                  id="userEmail"
                  required
                  value={credentials.email}
                  onChange={takeInput}
                />
              </div>
              <div className="mb-4 mt-3">
                <label htmlFor="pwd" class="form-label">
                  Password:
                </label>
                <input
                  type="password"
                  id="userPass"
                  class="form-control"
                  placeholder="Password"
                  required
                  value={credentials.password}
                  onChange={takeInput}/>
              </div>
              <div class="text-center">
                <button type='submit' class="btn btn-dark mb-3 " onClick={submitLogin}>Submit Login</button>
              </div>
            </form>
            <span class="me-3">
              <i>Don't have an account?</i>
            </span>
            <a href="/register">Press here to register.</a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
