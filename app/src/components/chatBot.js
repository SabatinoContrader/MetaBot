import React from "react";
import Navbar from "./navbar";
import history from "./history";
import "./../css/chatBot.css";

import ModalChatBot from "./modal/chatbot";
import { ChatbotDTO } from "./../models/chatbot";
import { UserDTO } from './../models/user';
import { NodoDTO } from './../models/nodo';

const API = "http://localhost:8080/Chatbot";
const APINODO = "http://localhost:8080/Nodo";
const APIUSER = "http://localhost:8080/users/";

const Modal = ({show, children }) => {
  const showHideClassName = show ? "modal display-block" : "modal display-none";

  return (
    <div className={showHideClassName}>
      <section className="modal-main">{children}</section>
    </div>
  );
};

export default class Chatbot extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lista: [],
      userList: [],
      nodoPadreList: [],
      show: false,
      chatBotNuovo: new ChatbotDTO(0, "", new UserDTO(0 , "", "", "", ""),new NodoDTO(0, "", null,"","")),
    };
    this.getAllUser = this.getAllUser.bind(this);
    this.getAllChat = this.getAllChat.bind(this);
    this.getAllNodo = this.getAllNodo.bind(this);
  }

  showModal = () => {
    this.setState({ show: true });
  };

  hideModal = () => {
    this.setState({ show: false });
  };

  componentDidMount() {
    this.getAllUser();
    this.getAllChat();
    this.getAllNodo();
  }

  getAllNodo() {
    fetch(APINODO + "/all", {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ nodoPadreList: result });
      });
  }

  getAllUser() {
    fetch(APIUSER + "/all", {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ userList: result });
      });
  }

  getAllChat() {
    fetch(API + "/all", {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ lista: result });
      });
  }

  visualizzaChat = idNodoPadre => {
    fetch(APINODO + "/visualizzaChat/?idNodoPadre=" + idNodoPadre, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        history.push({
          pathname: "/visualizzaChat",
          state: { listaNodo: result }
        });
      });
  };

  simulaChat = idNodoPadre => {
    
        history.push({  pathname: "/simulazioneChat",    state: { nodoRoot: idNodoPadre }  } )  
  };

  deleteChat = i => {
    fetch(API + "/deleteByID/?idChatbot=" + i, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        if (result) {
          alert("Cancelamento avvenuto con successo");
          this.getAllChat();
        } else alert("Errore");
      });
  };

  insertChatbot() {
    const chatbotDTOb = this.state.chatBotNuovo;

    fetch(API + "/insert", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(chatbotDTOb)
      })
        .then(response => response.json())
        .then(result => {
           this.getAllChat();
        })
  }

  render() {
    return (
      <React.Fragment>
        <Navbar />
        <div className="container">
          <table className="table table-light table-borderedtable-hover">
            <thead>
              <tr>
                <th scope="col">Nome</th>
                <th scope="col" />
                <th scope="col" />
              </tr>
            </thead>
            {this.state.lista.map((elem, i) => (
              <tbody>
                <tr>
                  <td>{elem.nomeChatbot}</td>
                  <td>
                    <button
                      className="btn "
                      onClick={() => this.deleteChat(elem.idChatbot)}
                    >
                      Elimina
                    </button>
                  </td>
                  <td>
                    <button
                      className="btn "
                      onClick={() => this.visualizzaChat(elem.nodoPadre.idNodo)}
                    >
                      Visualizza
                    </button>
                  </td>
                  <td>
                    <button
                      className="btn "
                      onClick={() => this.simulaChat(elem.nodoPadre.idNodo)}
                    >
                      Simula chat
                    </button>
                  </td>
                </tr>
              </tbody>
            ))}
          </table>
        </div>
        <div className="container">
          <Modal show={this.state.show}>
            <ModalChatBot
               handleClose={this.hideModal}
               userList={this.state.userList}
               nodoPadreList={this.state.nodoPadreList}
               nomeChatbotNuovoChange={this.nomeChatbotNuovoChange.bind(this)}
               userChatbotNuovoChange={this.userChatbotNuovoChange.bind(this)}
               nodoPadreChatbotNuovoChange={this.nodoPadreChatbotNuovoChange.bind(this)}
              insertChatbot={this.insertChatbot.bind(this)}
            />
          </Modal>
          <button className="btn " type="button" onClick={this.showModal}>
            Crea
          </button>
        </div>
      </React.Fragment>
    );
  }
  nomeChatbotNuovoChange(evt) {
    let chatBotNuovo = { ...this.state.chatBotNuovo };
    chatBotNuovo.nomeChatbot = evt.target.value;
    this.setState({ chatBotNuovo });
  }

  userChatbotNuovoChange(evt) {
    let chatBotNuovo = { ...this.state.chatBotNuovo };
    chatBotNuovo.user.idUser = evt.target.value;
    this.setState({ chatBotNuovo });
  }

  nodoPadreChatbotNuovoChange(evt) {
    let chatBotNuovo = { ...this.state.chatBotNuovo };
    chatBotNuovo.nodoPadre.idNodo = evt.target.value;
    this.setState({ chatBotNuovo });
  }
}
