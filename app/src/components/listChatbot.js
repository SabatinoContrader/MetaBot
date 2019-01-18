import React from 'react';
import Navbar from './navbar';

const API = 'http://localhost:8080/Chatbot/';

export default class ListChatbot extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      'u' : []
    };
    this.getAllChatbots = this.getAllChatbots.bind(this);
  }

  componentDidMount() {
    this.getAllChatbots()
  }

  render() {
    return (

      <React.Fragment>

        <Navbar />
        <div>
          <h2>Lista Chatbot</h2>

          <div classname="stampa">

// ciclo this.state. (map) per stampare le chatbot

          <h2> {this.state.u.nomeChatbot}</h2>


          </div>
        </div>

      </React.Fragment>

    );

  }
  getAllChatbots() {
    fetch(API + "/allChatbots", {
      method: 'GET',
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ u: result })
      })
  }
}
