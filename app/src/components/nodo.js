import React from "react";
import Navbar from "./navbar";

const API = "http://localhost:8080/Nodo";

export default class Nodo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lista: [],
      idNodoPadre: 0
    };
  }

  componentDidMount() {
    this.getAllNodo();
  }

  getAllNodo = () => {
    fetch(API + "/all", {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ lista: result });
      });
  };

  deleteNodo = i => {
    fetch(API + "/delete/?idNodo=" + i, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        if (result) {
          alert("Cancelamento avvenuto con successo");
          this.getAllNodo();
        } else alert("Errore");
      });
  };

  downloadFile = i => {
    fetch(API + "/download/?idNodo=" + i, {
      method: "GET",
    }).then(response => {
      const filename =  response.headers.get('Content-Disposition').split('filename=')[1];
      response.blob().then(blob => {
        let url = window.URL.createObjectURL(blob);
        let a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.click();
      });
    });
  };

  creanodo = event => {
    event.preventDefault();
    const formData = new FormData(event.target);
    fetch(API + "/insertCreaNodo2", {
      method: "POST",
      body: formData
    }).then(response => this.getAllNodo());
  };

  modificaNodo = event => {
    event.preventDefault();
    const formData = new FormData(event.target);
    fetch(API + "/updateNodo", {
      method: "POST",
      body: formData
    }).then(response => this.getAllNodo());
  };

  cambianodo = i => {
    this.setState({ idNodoPadre: i });
  };

  render() {
    return (
      <React.Fragment>
        <Navbar />
        <div className="container">
          <table className="table table-light table-borderedtable-hover">
            <thead>
              <tr>
                <th scope="col" />
                <th scope="col">ID </th>
                <th scope="col">Testo</th>
                <th scope="col">Nodo padre</th>
                <th scope="col">Label</th>
                <th scope="col"></th>
                <th scope="col"></th>
              </tr>
            </thead>
            {this.state.lista.map((elem, i) => (
              <tbody>
                <tr>
                  <td>
                    <input
                      type="radio"
                      id="choiceIdNodoPadre"
                      name="choiceIdNodoPadre"
                      onChange={() => this.cambianodo(elem.idNodo)}
                    />
                  </td>
                  <td>{elem.idNodo}</td>
                  <td>{elem.text}</td>
                  <td>{elem.nodoPadre == null ? "" : elem.nodoPadre.idNodo}</td>
                  <td>{elem.tipoNodo}</td>
                  <td>
                    <button
                      className="btn "
                      onClick={() => this.deleteNodo(elem.idNodo)}
                    >
                      Elimina
                    </button>
                  </td>
                  <td>
                    <button
                      className="btn "
                      onClick={() => this.downloadFile(elem.idNodo)}
                    >
                      Download
                    </button>
                  </td>
                  <td>
                    <form
                      onSubmit={this.modificaNodo}
                      className="form-horizontal"
                    >
                      <input
                        name="testo"
                        type="text"
                        className="form-control"
                        id="testo"
                      />
                      <input
                        name="idNodo"
                        type="hidden"
                        value={elem.idNodo}
                        className="form-control"
                        id="idNodo"
                      />

                      <button type="submit" className="btn btn-primary">
                        Modifica
                      </button>
                    </form>
                  </td>
                </tr>
              </tbody>
            ))}
          </table>
        </div>

        <div className="container">
          <form onSubmit={this.creanodo} className="form-horizontal">
            <div className="form-group">
              <input
                name="testo"
                type="text"
                placeholder="scrivi il testo del nodo da creare"
                className="form-control"
                id="testo"
              />
              <table>
                <tr>
                  <td>
                    <input
                      name="tiponodo"
                      type="radio"
                      className="form-control"
                      value="DOMANDA"
                    />
                  </td>
                  <td>DOMANDA</td>
                </tr>
                <tr>
                  <td>
                    <input
                      name="tiponodo"
                      type="radio"
                      className="form-control"
                      value="OPZIONE"
                    />
                  </td>{" "}
                  <td>OPZIONE</td>
                </tr>
                <tr>
                  <td>
                    <input
                      name="tiponodo"
                      type="radio"
                      className="form-control"
                      value="RISPOSTA"
                    />
                  </td>
                  <td>RISPOSTA</td>
                </tr>
              </table>
              <input name="nodo" type="hidden" value={this.state.idNodoPadre} />
            </div>

            <button type="submit" className="btn btn-primary">
              Crea Nodo
            </button>
          </form>
        </div>
      </React.Fragment>
    );
  }
}
