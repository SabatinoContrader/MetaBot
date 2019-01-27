import React, { Component } from "react";
import Navbar from './navbar';
import HierarchicalModel from "./../view/alberoView";

const APINODO = "http://localhost:8080/Nodo";
export default class VisualizzaChat extends Component {

  constructor(props) {
    super(props)
    this.state = { nuovaLista: [] , checkStatistiche: false }

  }
  componentDidMount(){
    this.setState({ nuovaLista: this.props.location.state.listaNodo })
  }

  azzeraStatistiche = (e) => {

    fetch(APINODO + "/azzeraStatisticaNodiChatcorrente/?idNodoRoot=" + (this.state.checkStatistiche === false ? this.props.location.state.listaNodo[0].idNodo: this.state.nuovaLista[0].idNodo), {
      method: "GET"
    }).then(response => response.json())
      .then(result => {
       
        this.setState({ checkStatistiche: true , nuovaLista : result})

      });
  }
  render() {
    return (
      <React.Fragment>
        <Navbar />
        <button className="btn btn-primary" onClick={() => this.azzeraStatistiche()}>Azzera statistiche chat corrente</button>
        <HierarchicalModel contatoreNodoPadre={this.state.checkStatistiche === false ? this.props.location.state.listaNodo[0].contatore: this.state.nuovaLista[0].contatore}
         hierarchicalTree= {this.state.checkStatistiche === false ? this.props.location.state.listaNodo: this.state.nuovaLista}  />
      </React.Fragment>
    );
  }
}
