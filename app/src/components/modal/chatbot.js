import React, { Component } from "react";

export default class ModalChatBot extends Component {
  render() {
    return (
      <div className="container text-center">
        <React.Fragment>
          <h1>{this.props.mode === "insert" ? "Crea Chat" : "Modifica Chat"}</h1>
          <div className="form-group">
            <label for="nomeChatbot">Nome Chat:</label>{" "}
            {this.props.mode === "insert" ? (
            <input type="text" className="form-control" id="nomeChatbot" 
              placeholder="Inserisci il nome dell tuo user" name="nomeChatbot"
              onChange={event => this.props.nomeChatbotNuovoChange(event)}               
            />) :
            (
            <input type="text" className="form-control" id="nomeChatbot"
              placeholder="Inserisci il nome dell tuo user" name="nomeChatbot"
              value={this.props.chatBotModif.nomeChatbot}
              onChange={event => this.props.nomeChatbotModifChange(event)}              
            />)
            }
          </div>
          {this.props.mode === "insert" ? (
            <React.Fragment>
          <div className="form-group">
            <label for="nodoPadre">Nodo Padre:</label>
            <select className="form-control" name="nodoPadreSelezionato" onChange={event => this.props.nodoPadreChatbotNuovoChange(event)}>
            <option type="radio" name="nodoPadre" value="0">Selezionare Nodo Padre</option>
                    
              {this.props.nodoPadreList.map((elem, i) => (
                <React.Fragment>
                  <option type="radio" name="nodoPadre" value={elem.idNodo}>
                    {elem.text}
                  </option>
                </React.Fragment>
              ))}
            </select>
          </div>
          <button type="submit" className="btn btn-default"
            onClick={() => {
              this.props.insertChatbot();
              this.props.handleClose();
            }}>Submit</button>
          </React.Fragment>) : (
                      <button type="submit" className="btn btn-default"
            onClick={() => {
              this.props.updateChatbot();
              this.props.handleClose();
            }}>Submit</button>
          )}
        </React.Fragment>
      </div>
    );
  }
}
