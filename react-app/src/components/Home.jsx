import React from "react";
import "../App.css";

function Home() {

  const userName = localStorage.getItem("username");




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

      <marquee scrollAmount='20' style={{
                            backgroundColor: '#FFCCBC'}}>Welcome {userName} to our page!</marquee>

      <div className="centered-div"><h1>Welcome {userName}!</h1></div>
    
    
    </div>
  );
}

export default Home;