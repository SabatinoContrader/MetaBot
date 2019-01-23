import React from 'react';
import Navbar from './navbar';
import history from './history';

const API = 'http://localhost:8080/Chatbot';
const APINODO = 'http://localhost:8080/Nodo';

export default class Chatbot extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      lista: [],
    };
    this.getAllChat = this.getAllChat.bind(this);
  }

  componentDidMount() {
    this.getAllChat();
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

  visualizzaChat = (idNodoPadre) => {
    fetch(APINODO + "/visualizzaChat/?idNodoPadre=" + idNodoPadre, {
      method: 'GET',
    })
      .then(response => response.json())
      .then(result => {
        history.push({
          pathname: '/visualizzaChat',
          state: { listaNodo: result }
          })
      })
  }

  deleteChat = (i) => {
    fetch(API + "/deleteByID/?idChatbot=" + i, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        if (result){alert("Cancelamento avvenuto con successo");
        this.getAllChat()
        }else alert("Errore");
      });
  };

  render() {
    return (
      <React.Fragment>
        <Navbar />
        <div className="container">
                    <table className="table table-light table-borderedtable-hover">
                        <thead>
                            <tr>
                                <th scope="col">ID Chat</th>
                                <th scope="col">Nome</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        {this.state.lista.map((elem, i) =>
                            <tbody>
                                <tr>
                                    <td >
                                        {elem.idChatbot}
                                    </td>
                                    <td>
                                        {elem.nomeChatbot}
                                    </td>
                                    <td><button className="btn " onClick={() => this.deleteChat(elem.idChatbot)}>
                                     Elimina
                                    </button></td>
                                    <td><button className="btn " onClick={() => this.visualizzaChat(elem.nodoPadre.idNodo)}>
                                     Visualizza
                                    </button></td>
                                </tr>
                            </tbody>
                        )

                        }
                    </table>
                </div>

      </React.Fragment>

    );

  }
}
