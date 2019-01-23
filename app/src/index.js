import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import Login from "./components/login";
import Registrazione from "./components/registrazione";
import Home from "./components/home";
import history from './components/history';


import { Router, Route } from 'react-router-dom';
import Chatbot from './components/chatBot';
import Nodo from './components/nodo';
import VisualizzaChat from './components/visualizzaChat';

ReactDOM.render(
    <Router history={history}>
      <div className="content">
        <Route exact path="/" component={Login} />
        <Route path="/home" component={Home} />
        <Route path="/chatBot" component={Chatbot} />
        <Route path="/nodo" component={Nodo} />
        <Route path="/registrazione" component={Registrazione} />
        <Route path="/visualizzaChat" component={VisualizzaChat} />
      </div>
    </Router>
  , document.getElementById('root'));
