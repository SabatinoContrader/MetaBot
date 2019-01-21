import React from 'react';
import Navbar from './navbar';

export default class Nodo extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      lista: [],
    };
  }

  componentDidMount() {
    this.setState({ lista: this.props.location.state.listaNodo })
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