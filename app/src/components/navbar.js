import React from 'react';
import { NavLink } from 'react-router-dom'

export default class Navbar extends React.Component {

  constructor(props){
    super(props);
  }

  render() {
    return (

         <ul className="header">
           <li><NavLink exact to="/">Home</NavLink></li>
           <li><NavLink to="/listChatbot">Chatbot</NavLink></li>
           <li><NavLink to="/Login">Login</NavLink></li>
         </ul>
);

  }

}
