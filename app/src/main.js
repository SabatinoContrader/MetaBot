import React, { Component } from "react";
import { Route, NavLink, HashRouter } from "react-router-dom";
import Home from "./components/home";
import Login from "./components/login";
import Contact from "./components/contact";


class Main extends Component {


render() {

    return (

      <HashRouter>
       <div>
         <h1>MetaBot</h1>
         <ul className="header">
           <li><NavLink exact to="/">Home</NavLink></li>
           <li><NavLink to="/components/contact">Contact</NavLink></li>
           <li><NavLink to="/components/login">Login</NavLink></li>
         </ul>
         <div className="content">
           <Route exact path="/" component={Home}/>
           <Route path="/components/contact" component={Contact}/>
           <Route path="/components/login" component={Login}/>
        </div>
        </div>
       </HashRouter>

   );
 }
}

export default Main;
