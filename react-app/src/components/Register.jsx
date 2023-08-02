import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Register() {
  const [credentials, setCredentials] = useState({
    firstName: "",
    email: "",
    password: "",
    role:""
  });
  const navigate = useNavigate();
  const takeInput = (e) => {
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });
  };
  function addUser() {
    console.log(credentials.email);
    navigate('/login')
  }
  return (
    <div className="mainRegister">
      <div class="container d-flex align-items-center justify-content-center  pt-5">
        <form>
          <div class="row">
            <h1 class="text-center my-5">Register</h1>
            <div class="col-sm-12 px-3">
              <div class="mb-3 mt-3">
                <label for="firstName" class="form-label">
                  First Name:
                </label>
                <input
                  type="text"
                  class="form-control"
                  id="userRegister"
                  placeholder="Enter first name"
                  name="firstName"
                  value={credentials.firstName}
                  onChange={takeInput}
                />
              </div>
              <div class="mb-4 mt-3">
                <label for="email" class="form-label">
                  Email:
                </label>
                <input
                  type="email"
                  class="form-control"
                  id="userEmail"
                  placeholder="Enter email"
                  name="email"
                  value={credentials.email}
                  onChange={takeInput}
                />
              </div>
              <div class="mb-4 ">
                <label for="password" class="form-label">
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
                />
              </div>
              <div class="mb-4 ">
                <label for="role" class="form-label">
                  Role
                </label>
                <select value={credentials.role} onChange={takeInput} id="role" name="role" class="form-select">
                    <option>Admin</option>
                    <option>User</option>
                </select>
              </div>
            </div>
            <div class="text-center">
              <button
                type="submit"
                class="btn btn-dark mb-3 "
                id="btnLogin"
                onClick={addUser}
              >
                Create account
              </button>
            </div>
            <div class="text-center">
              <span class="me-3">
                <i>Already registered?</i>
              </span>
              <a href="/login">Press here to login.</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Register;
