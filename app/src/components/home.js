import React from "react";
import Navbar from './navbar';

export default class Home extends React.Component{
  //   constructor(props){
	// 	super(props);
	// }

	render(){

    return(
<React.Fragment>
<Navbar/>
      <div>
         <h2>Benvenuto!</h2>
         <p>Qui puoi creare la tua ChatBot Personale.</p>
      </div>
</React.Fragment>
		);
	}
}
