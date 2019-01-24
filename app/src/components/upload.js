import React, { Component } from 'react'

const APINODO = "http://localhost:8080/Nodo";

export default class UploadFile extends Component {


    aggiungiFile = (event) => {

        event.preventDefault();
        let formdata = new FormData(event.target);
        formdata.append("idNodo", this.props.idNodo);

        fetch(APINODO + '/upload', {
            mode: 'no-cors',
            method: "POST",
            body: formdata
        })
          alert("File caricato con successo");
    }
    render() {
        return (
            <React.Fragment>
                <form onSubmit={this.aggiungiFile} enctype="multipart/form-data">
                    <div className="input-group">
                        <div className="input-group-prepend">

                            <button type="submit" className="btn btn-secondary" id="caricaUpload" >Carica File</button>
                        </div>
                        <div className="custom-file">
                            <input type="file" className="custom-file-input" id="upload" aria-describedby="caricaUpload" name="file"></input>
                            <label className="custom-file-label" htmlFor="upload">Scegli un file</label>
                        </div>
                    </div>
                </form>
            </React.Fragment>
        );
    }
}