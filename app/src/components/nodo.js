import React from 'react';
import Navbar from './navbar';

const API = 'http://localhost:8080/Nodo';

export default class Nodo extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      lista: [],
    };
  }

  componentDidMount() {
    this.getAllNodo();
  }


  getAllNodo = () => {
    fetch(API + "/all", {
      method: 'GET',
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ lista: result })
      })
  }


  deleteNodo = (i) => {
    fetch(API + "/delete/?idNodo=" + i, {
      method: "GET"
    })
      .then(response => response.json())
      .then(result => {
        if (result){alert("Cancelamento avvenuto con successo");
        this.getAllNodo()
        }else alert("Errore");
      });
  };


  creanodo = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    fetch( API + "/insertCreaNodo", {
        method : 'POST',
        body : formData
    })
        .then(response => this.getAllNodo())
}


  render() {
    return (
      <React.Fragment>
        <Navbar />
        <div className="container">
          <table className="table table-light table-borderedtable-hover">
            <thead>
              <tr>
                <th scope="col">ID Nodo</th>
                <th scope="col">Testo</th> 
                <th scope="col">Nodo Padre</th>
                <th scope="col">utility</th>
              </tr>
            </thead>
            {this.state.lista.map((elem, i) =>
              <tbody>
                <tr>
                  <td >
                    {elem.idNodo}
                  </td>
                  <td>
                    {elem.text}
                  </td>
                  <td>
                    {elem.nodoPadre == null ? "" : elem.nodoPadre.idNodo }
                  </td>
                  <td><button className="btn " onClick={() => this.deleteNodo(elem.idNodo)}>
                                     Elimina
                                    </button></td>
                                    
                </tr>
              </tbody>
            )

            }
          </table>
        </div>


        <div className= "container">
                    <form onSubmit={this.creanodo} className="form-horizontal">
                        <div className="form-group">
                           
                            <input name = "testo" type = "text" className = "form-control" id = "testo"/>
                            <input name = "tiponodo" type = "text" className = "form-control" id = "tiponodo"/>
                        </div>
                        <button type = "submit" className = "btn btn-primary">Crea Nodo</button>
                    </form>
                </div>




      </React.Fragment>

    );

  }
}