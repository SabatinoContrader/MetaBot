import React, { Component } from "react";
import Navbar from './navbar';
import HierarchicalModel from "./../view/alberoView";

export default class VisualizzaChat extends Component {
  render() {
    return (
      <React.Fragment>
        <Navbar />
        <HierarchicalModel hierarchicalTree={this.props.location.state.listaNodo } />
      </React.Fragment>
    );
  }
}
