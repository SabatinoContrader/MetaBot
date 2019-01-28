import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import Login from "./components/login";
import Registrazione from "./components/registrazione";
import Home from "./components/home";
import history from './components/history';
import SimulazioneChat from "./components/simulazioneChat"


import { Router, Route } from 'react-router-dom';
import Chatbot from './components/chatBot';
import Nodo from './components/nodo';
import VisualizzaChat from './components/visualizzaChat';
import ImportaChat from './components/importaChat';
import User from './components/user';
import ChatSimulaUtente from './components/chatsimulautente';

ReactDOM.render(
    <Router history={history}>
      <div className="content">
        <Route exact path="/" component={Login} />
        <Route path="/home" component={Home} />
        <Route path="/chatBot" component={Chatbot} />
        <Route path="/nodo" component={Nodo} />
        <Route path="/user" component={User}/>
        <Route path="/registrazione" component={Registrazione} />
        <Route path="/visualizzaChat" component={VisualizzaChat} />
        <Route path="/simulazioneChat" component={SimulazioneChat} />
        <Route path="/importaChat" component={ImportaChat} />
        <Route path="/chatSimulaUtente" component={ChatSimulaUtente} />
      </div>
    </Router>
  , document.getElementById('root'));
