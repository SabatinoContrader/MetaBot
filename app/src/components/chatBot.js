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

const Modal = ({show, children,handleClose }) => {
  const showHideClassName = show ? "modal display-block" : "modal display-none";

  return (
    <div className={showHideClassName}>
      <section className="modal-main">
        <button className="btn " onClick= {handleClose}>Chiudi</button>
        {children}      
      </section>
    </div>
  );
};

export default class Chatbot extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      mode :"",
      lista: [],
      userList: [],
      nodoPadreList: [],
      show: false,
      chatBotNuovo: new ChatbotDTO(0, "", new UserDTO(0 , "", "", "", ""),new NodoDTO(0, "", null,"","")),
      chatBotModif: new ChatbotDTO(0, "", new UserDTO(0 , "", "", "", ""),new NodoDTO(0, "", null,"","")),
    };
    this.getAllUser = this.getAllUser.bind(this);
    this.getAllChat = this.getAllChat.bind(this);
    this.getAllNodo = this.getAllNodo.bind(this);
  }

  showModal = (mode) => {
    this.setState({ show: true , mode});
  };

  hideModal = () => {
    this.setState({ show: false});
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

  modificaChat = i => {
    fetch(API + "/get/?idChatbot=" + i, {
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
    if(search === "")
      this.getAllChat();
    else{
      let listaSearch =  this.state.lista.filter(function(elem) { return elem.nomeChatbot === search; });
      this.setState({ lista: listaSearch });
    }
    
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
                    <button className="btn "onClick={() => this.deleteChat(elem.idChatbot)}> Elimina</button>
                  </td>
                  <td>
                    <button className="btn "onClick={() => this.modificaChat(elem.idChatbot)}> Modifica</button>
                  </td>
                  <td>
                    <button className="btn " onClick={() => this.visualizzaChat(elem.nodoPadre.idNodo)}> Visualizza</button>
                  </td>
                  <td>
                    <button className="btn "onClick={() => this.simulaChat(elem.nodoPadre.idNodo)}> Simula chat </button>
                  </td>
                </tr>
              </tbody>
            ))}
          </table>
        </div>
        <div className="container">
          <Modal show={this.state.show} handleClose ={this.hideModal}> 
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
          <form className="form-inline my-2 my-lg-0" onSubmit={ (event) => this.cerca(event)}>
            <button className="btn my-2 my-sm-0" type="button" onClick={ () => this.showModal("insert")}>Crea</button>
            <label className="mr-sm-2" for="search">Nome Chat :</label>
            <input name="search" className="form-control mr-sm-2" type="search"/>
            <button className="btn btn-outline-success my-2 my-sm-0" type="submit" >Cerca</button>
          </form>
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
