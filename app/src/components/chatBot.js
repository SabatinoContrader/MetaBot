import React from "react";
import Navbar from "./navbar";
import history from "./history";
import "./../css/chatBot.css";

import { ContextMenuTrigger, ContextMenu, MenuItem } from "react-contextmenu"

import ModalChatBot from "./modal/chatbot";
import { ChatbotDTO } from "./../models/chatbot";
import { UserDTO } from './../models/user';
import { NodoDTO } from './../models/nodo';
import ImportaChat from "./importaChat";

const MENU_TYPE = 'SIMPLE';

const API = "http://localhost:8080/Chatbot";
const APINODO = "http://localhost:8080/Nodo";
const APIUSER = "http://localhost:8080/users/";

const Modal = ({ show, children, handleClose }) => {
  const showHideClassName = show ? "modal display-block" : "modal display-none";

  return (
    <div className={showHideClassName}>
      <section className="modal-main">
        <button className="btn " onClick={handleClose}>Chiudi</button>
        {children}
      </section>
    </div>
  );
};

function collect(props) {
  return { idChatbot: props.idChatbot, idNodoPadre: props.idNodoPadre,nomeChatbot:props.nomeChatbot };
}

export default class Chatbot extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      mode: "",
      lista: [],
      userList: [],
      nodoPadreList: [],
      show: false,
      chatBotNuovo: new ChatbotDTO(0, "", new UserDTO(0, "", "", "", ""), new NodoDTO(0, "", null, "", "")),
      chatBotModif: new ChatbotDTO(0, "", new UserDTO(0, "", "", "", ""), new NodoDTO(0, "", null, "", "")),
    };
    this.getAllUser = this.getAllUser.bind(this);
    this.getAllChat = this.getAllChat.bind(this);
    this.getAllNodo = this.getAllNodo.bind(this);
  }

  showModal = (mode) => {
    this.setState({ show: true, mode });
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

  visualizzaChat = (e, data) => {
    fetch(APINODO + "/visualizzaChat/?idNodoPadre=" + data.idNodoPadre, {
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

  simulaChat = (e, data) => {
    history.push({ pathname: "/simulazioneChat", state: { nodoRoot: data.idNodoPadre } })
  };

  deleteChat = (e, data) => {
    fetch(API + "/deleteByID/?idChatbot=" + data.idChatbot, {
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

  modificaChat = (e, data) => {
    fetch(API + "/get/?idChatbot=" + data.idChatbot, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ chatBotModif: result });
        this.showModal("update");
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

  updateChatbot() {
    const chatbotDTOb = this.state.chatBotModif;

    fetch(API + "/update", {
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

  cerca = (event) => {
    event.preventDefault();
    let search = event.target.search.value;
    if (search === "")
      this.getAllChat();
    else {
      let listaSearch = this.state.lista.filter(function (elem) { return elem.nomeChatbot === search; });
      this.setState({ lista: listaSearch });
    }

  }

  esportareChat = (e, data) => {
    fetch(API + "/esportareXML/?idChatbot=" + data.idChatbot+"&nomeFile="+data.nomeChatbot+".xml", {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        if (result) {
          alert("Esportare avvenuta con successo");
        } else alert("Errore");
      });
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
                    <ContextMenuTrigger
                      renderTag='tr' idChatbot={elem.idChatbot}
                      id={MENU_TYPE} holdToDisplay={1000} key={i}
                      idNodoPadre={elem.nodoPadre.idNodo}
                      nomeChatbot= {elem.nomeChatbot}
                      collect={collect}>
                      <td>{elem.nomeChatbot}</td>
                    </ContextMenuTrigger>
                  ))}
                </tbody>

              </table>
              <ContextMenu id={MENU_TYPE}>
                <MenuItem onClick={this.deleteChat}>Elimina</MenuItem>
                <MenuItem onClick={this.modificaChat}> Modifica</MenuItem>
                <MenuItem onClick={this.visualizzaChat}> Visualizza</MenuItem>
                <MenuItem onClick={this.esportareChat}> Esportare XML</MenuItem>
                <MenuItem onClick={this.simulaChat}> Simula chat </MenuItem>
              </ContextMenu>
            </div>
            <div className="container">
              <Modal show={this.state.show} handleClose={this.hideModal}>
                <ModalChatBot
                  mode={this.state.mode}
                  handleClose={this.hideModal}
                  userList={this.state.userList}
                  nodoPadreList={this.state.nodoPadreList}
                  nomeChatbotNuovoChange={this.nomeChatbotNuovoChange.bind(this)}
                  userChatbotNuovoChange={this.userChatbotNuovoChange.bind(this)}
                  nodoPadreChatbotNuovoChange={this.nodoPadreChatbotNuovoChange.bind(this)}
                  insertChatbot={this.insertChatbot.bind(this)}

                  nomeChatbotModifChange={this.nomeChatbotModifChange.bind(this)}
                  updateChatbot={this.updateChatbot.bind(this)}
                  chatBotModif={this.state.chatBotModif}
                />
              </Modal>
            </div>
            <div className="container">
              <form className="form-inline my-2 my-lg-0" onSubmit={(event) => this.cerca(event)}>
                <button className="btn my-2 my-sm-0" type="button" onClick={() => this.showModal("insert")}>Crea</button>
                <label className="mr-sm-2" for="search">Nome Chat :</label>
                <input name="search" className="form-control mr-sm-2" type="search" />
                <button className="btn btn-outline-success my-2 my-sm-0" type="submit" >Cerca</button>
              </form>
            </div>

          </div>
          <div className="col-md-3">
            <ImportaChat></ImportaChat>
          </div>
        </div>


      </React.Fragment>
    );
  }

  nomeChatbotModifChange(evt) {
    let chatBotModif = { ...this.state.chatBotModif };
    chatBotModif.nomeChatbot = evt.target.value;
    this.setState({ chatBotModif });
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
