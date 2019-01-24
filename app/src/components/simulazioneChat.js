import React from 'react'
import Navbar from './navbar';
import UploadFile from './upload';
//import Nodo from './../models/nodo';


const APINODO = "http://localhost:8080/Nodo";
export default class SimulazioneChat extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            nodi: [],
            nodoCorrente: 0,
            nodoRoot: 0

        }
        this.getSottoAlbero = this.getSottoAlbero.bind(this)
        this.aumentaContatoreNodo = this.aumentaContatoreNodo.bind(this)

    }
    setNodoCorrente = async (id) => {

        await this.setState({
            nodoCorrente: id,
        })

        this.getSottoAlbero()

        this.aumentaContatoreNodo()
    }

    aumentaContatoreNodo() {
        fetch(APINODO + '/aumentaContatoreNodo?idNodo=' + this.state.nodoCorrente, {
            method: 'GET'
        })
    }

    getSottoAlbero() {
        fetch(APINODO + '/recuperaSottoAlbero?id=' + this.state.nodoCorrente, {
            method: 'GET'
        })
            .then(response => response.json())
            .then(utente => {
                this.setState({ nodi: utente })
            })
    }
   
    componentDidMount() {

        this.setState({
            nodoRoot: this.props.location.state.nodoRoot
        })

    }
    render() {
        return (
            <React.Fragment>
                <Navbar />
                <div className="container">
                    <button className="btn btn-primary" onClick={() => this.setNodoCorrente(this.state.nodoRoot)}>Simula</button>
                    <table className="table table-light table-borderedtable-hover">
                        <thead>
                            <tr>

                                <th scope="col">Testo</th>

                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>

                        {this.state.nodi.map((elem, i) =>
                            <tbody key={i}>
                                <tr>

                                    <td>
                                        {elem.text}
                                    </td>

                                    <td>
                                        <button className="btn btn-primary" onClick={() => this.setNodoCorrente(elem.idNodo)}>Continua</button>
                                    </td>

                                    <td>
                                       <UploadFile idNodo={elem.idNodo } ></UploadFile>
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