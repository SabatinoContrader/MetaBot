import React, { Component } from 'react';
import { Link } from 'react-router-dom';



export default class Navbar extends Component {

generaFormNav = () =>{
    let userReq = JSON.parse(localStorage.getItem("currentUser"));
    let ruoloInput;
    switch (userReq.ruolo.toUpperCase()){
    case "ADMIN":
    {
      ruoloInput =
      <React.Fragment>
      <li className="nav-item" ><Link className="nav-link" to="/home">Home</Link></li>
      <li className="nav-item"><Link className="nav-link" to="/chatBot">Chatbot</Link></li>
      <li className="nav-item"><Link className="nav-link" to="/nodo">Nodo</Link></li>
      <li className="nav-item"><Link className="nav-link" to="/user">Utenti</Link></li>
      </React.Fragment>;
       break;
    }
    case "CHATMASTER":
    {
      ruoloInput =
      <React.Fragment>
      <li className="nav-item" ><Link className="nav-link" to="/home">Home</Link></li>
      <li className="nav-item"><Link className="nav-link" to="/chatBot">Chatbot</Link></li>      
      <li className="nav-item"><Link className="nav-link" to="/user">Utenti</Link></li>
      </React.Fragment>;
       break;
    }
    case "UTENTE":{
      ruoloInput =
      <React.Fragment>
      <li className="nav-item" ><Link className="nav-link" to="/home">Home</Link></li>
      <li className="nav-item" ><Link className="nav-link" to="/chatSimulaUtente">Simula Chat</Link></li>
      
      </React.Fragment>;
       break;
    }
    default:{
      ruoloInput =
      <React.Fragment>
      <li className="nav-item" ><Link className="nav-link" to="/home">Home</Link></li>
      </React.Fragment>;
       break;
    }
    };
     return(ruoloInput);
 }

  render() {
    let form = this.generaFormNav();
    return (
      <React.Fragment>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <b className="navbar-brand" href="#">Metabot</b>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav mr-auto">
              {form}
            </ul>
            <ul className="navbar-nav">
              <li className="nav-item"><Link onClick={() => localStorage.clear()} className="nav-link" to="/">Logout</Link></li>
            </ul>
          </div>
        </nav>
      </React.Fragment>
    );
  }
}