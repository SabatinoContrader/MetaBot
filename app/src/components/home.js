import React from "react";
import Navbar from './navbar';

export default class Home extends React.Component{
  //   constructor(props){
	// 	super(props);
	// }

	render(){
let userReq = JSON.parse(localStorage.getItem("currentUser"));
    return(
<React.Fragment>
<Navbar/>
      <div>
         <h2>Benvenuto! {userReq.username}</h2>
         <p>Qui puoi creare la tua ChatBot Personale.</p>
      </div>
</React.Fragment>
		);
	}
}
