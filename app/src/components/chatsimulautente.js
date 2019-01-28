import React from "react";
import Navbar from "./navbar";
import history from "./history";

const API = "http://localhost:8080/Chatbot";

export default class ChatSimulaUtente extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lista: []
    };
    this.getAllChatbyUtente = this.getAllChatbyUtente.bind(this);
  }

  componentDidMount() {
    this.getAllChatbyUtente();
  }

  getAllChatbyUtente = () => {
    let userReq = JSON.parse(localStorage.getItem("currentUser"));
    fetch(API + "/allByUtente?idAzienda=" + userReq.aziendaDTO.idAzienda, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ lista: result });
      });
  }

  simulaChat = (idNodoPadre) => {
    history.push({ pathname: "/simulazioneChat", state: { nodoRoot: idNodoPadre } })
  };

render() {
    return (
      <React.Fragment>
        <Navbar />
        <div className="modal-body row">
          <div className="col-md-9">
            <div className="container">
              <table className="table table-light table-borderedtable-hover">
                <thead>
                  <tr>
                    <th scope="col">Nome</th>
                  </tr>
                </thead>

                <tbody>
                 {this.state.lista.map((elem, i) => (
                 <tr>                 
                   <td>{elem.nomeChatbot}</td>
                 <td><button className="btn " type="button" onClick={() => this.simulaChat(elem.nodoPadre.idNodo)}>Simula</button></td>
                 </tr>
                 ))}
                </tbody>
              </table>
          </div>
        </div>
     </div>

      </React.Fragment>
    );
}
}