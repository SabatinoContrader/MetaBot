// import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import Login from "./components/login";
import Home from "./components/home";
import Registration from "./components/registration";
// import Chatbot from "./components/Chatbot";
import history from './components/history';

import {Router,Route, HashRouter} from 'react-router-dom';
import ListChatbot from './components/listChatbot';

ReactDOM.render(
  <Router history={history}>
  <div>
  <div className="content">
  <Route exact path="/" component={Home}/>
  <Route path="/login" component={Login}/>
  <Route path="/listChatbot" component={ListChatbot}/>
  <Route path="/registration" component={Registration}/>
  </div>
  </div>
  </Router>



  , document.getElementById('root'));
