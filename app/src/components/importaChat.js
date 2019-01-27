import React, { Component } from 'react'
import history from "./history";

const APICHAT = "http://localhost:8080/Chatbot";
const APINODO = "http://localhost:8080/Nodo";
export default class ImportaChat extends Component {

    constructor(props) {
        super(props)
        this.state = {
            listaChatImportate: []
        }

        this.getListaChatImportate = this.getListaChatImportate.bind(this);
        this.onClick = this.onClick.bind(this);
    }

    componentDidMount() {

        this.getListaChatImportate();
    }
    getListaChatImportate() {

        fetch(APICHAT + "/getListaChatImportate", {
            method: "GET"
        })
            .then(response => response.json())
            .then(result => {

                this.setState({ listaChatImportate: result });
            });
    }

    onClick(e, elem) {
        e.preventDefault();

        fetch(APICHAT + "/importareXML/?nomeFile=" + elem, {
            method: "GET"
        }).then(response => response.json())
            .then(result => {
                if (result) {

                    fetch(APINODO + "/visualizzaChat/?idNodoPadre=" + result.nodoPadre.idNodo, {
                        method: "GET"
                    })
                        .then(response => response.json())
                        .then(result => {
                            history.push({
                                pathname: "/visualizzaChat",
                                state: { listaNodo: result }
                            });
                        });
                }
            });
    }



    render() {
        return (
            <div className="container">
                <div className="dropdown dropleft">
                    <button type="button" className="btn btn-primary dropdown-toggle" data-toggle="dropdown"> Chat disponibili da importare</button>
                    <div className="dropdown-menu">
                        {this.state.listaChatImportate.map((elem, i) => (
                            <a href={"/"} onClick={(e) => { e.preventDefault(); this.onClick(e, elem) }} className="dropdown-item" key={i}>{elem}</a>))}
                    </div>
                </div>
            </div>
        )
    }
}