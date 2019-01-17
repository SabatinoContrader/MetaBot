// import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import Login from "./components/login";
import Home from "./components/home";
// import Chatbot from "./components/Chatbot";
import history from './components/history';

import {Router,Route, HashRouter} from 'react-router-dom';

ReactDOM.render(
  <Router history={history}>
  <div>
  <div className="content">
  <Route exact path="/" component={Login}/>
  <Route exact path="/home" component={Home}/>
  <Route path="/logout" component={Login}/>
  </div>
  </div>
  </Router>



  , document.getElementById('root'));
