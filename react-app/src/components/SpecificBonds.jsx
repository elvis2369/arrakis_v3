import axios from "axios";
import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useRef } from "react";
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function SpecificBonds() {
  const [bonds, setBond] = useState([]);
  const [dateTaken, setDateTaken] = useState([]);
  const dateRef = useRef(null);
  const nav = useNavigate();
  useEffect(() => {
    getSpecificBonds();
  }, []);

  const setDate = (e) => {
    setDateTaken(e.target.value);
  };
  const getSpecificBonds = (e) => {
    axios.get("http://localhost:8080/allSecurities").then((response) => {
      setBond(response.data);
      console.log(Date(dateTaken));
    });
  };

  function calcDate(d1, d2) {
    const date1 = new Date(d1);
    const date2 = new Date(d2);
    const diffTime = date2 - date1;
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    return diffDays;
  }
  function goToBond(bondID) {
    axios
      .get("http://localhost:8080/bondSecurity/" + bondID)
      .then((response) => {
        console.log(response.data);
        nav("/bonddetail/" + bondID);
        console.log(bondID);
      })
      .catch((err) => console.warn(err));
  }
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
      <div className="mainLogin">
        <div>
          <input type="date" onChange={setDate} ref={dateRef}></input>
        </div>
      </div>
      <div class="table-responsive mt-4">
        <table class="table">

          <tbody>
            <tr>
              <td>
                <Card style={{ width: "18rem" }} border="danger">
                  <Card.Body>
                    <Card.Title>Maturity Date -5</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === -5) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
              <td>
                <Card style={{ width: "18rem" }} border="warning">
                  <Card.Body>
                    <Card.Title>Maturity Date -4 or -3</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === -4 || valueDate === -3) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
              <td>
                <Card style={{ width: "18rem" }} border="success">
                  <Card.Body>
                    <Card.Title>Maturity Date -1 or -2</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === -2 || valueDate === -1) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
            </tr>
            <tr class="mb-3">
              <td></td>
              <td>
                <Card style={{ width: "18rem" }} border="primary">
                  <Card.Body>
                    <Card.Title>Maturity Date Today</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === 0) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
            </tr>
            <tr class="mt-2">
              <td>
                <Card style={{ width: "18rem" }} border="success">
                  <Card.Body>
                    <Card.Title>Maturity Date +1 or +2</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === 1 || valueDate === 2) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
              <td>
                <Card style={{ width: "18rem" }} border="warning">
                  <Card.Body>
                    <Card.Title>Maturity Date +3 or +4</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === 3 || valueDate === 4) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
              <td>
                <Card style={{ width: "18rem" }} border="danger">
                  <Card.Body>
                    <Card.Title>Maturity Date +5</Card.Title>
                    <Card.Text>
                      {bonds.map((bond, index) => {
                        var valueDate = calcDate(dateTaken, bond.maturity_date);
                        if (valueDate === 5) {
                          return (
                            <div>
                              <p>
                                <Link onClick={() => goToBond(bond.id)}>
                                  {"Bond-ID(" + bond.id + "): " + bond.issuer_name}
                                </Link>
                              </p>
                            </div>
                          );
                        }
                      })}
                    </Card.Text>
                  </Card.Body>
                </Card>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default SpecificBonds;
