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
  }

  componentDidMount() {
    fetch(API + "/allChatbots", {
      method: 'GET',
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ lista: result })
      })
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
                                    <button className="btn " onClick={() => this.visualizzaChat(elem.nodoPadre.idNodo)}>
                                     Visualizza
                                    </button>
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
