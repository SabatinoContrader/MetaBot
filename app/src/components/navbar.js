import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Navbar extends Component {
  render() {
    return (
      <React.Fragment>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <b className="navbar-brand" href="#">Metabot</b>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item" ><Link className="nav-link" to="/home">Home</Link></li>
              <li className="nav-item"><Link className="nav-link" to="/chatBot">Chatbot</Link></li>
              <li className="nav-item"><Link className="nav-link" to="/nodo">Nodo</Link></li>
            </ul>
            <ul className="navbar-nav">
              <li className="nav-item"><Link className="nav-link" to="/">Logout</Link></li>
            </ul>
          </div>
        </nav>
      </React.Fragment>
    );
  }
}