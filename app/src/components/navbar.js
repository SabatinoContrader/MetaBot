import React from 'react';
import { NavLink } from 'react-router-dom'

export default class Navbar extends React.Component {

  constructor(props){
    super(props);
  }

  render() {
    return (

         <ul className="header">
           <li><NavLink to="/home">Home</NavLink></li>
           <li><NavLink to="/Chatbot">Chatbot</NavLink></li>
           <li><NavLink to="/">logout</NavLink></li>
         </ul>
);

  }

}
