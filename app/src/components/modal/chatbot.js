import React, { Component } from "react";

export default class ModalChatBot extends Component {
  render() {
    return (
      <div class="container text-center">
        <React.Fragment>
          <h1>Crea Chat</h1>
          <div class="form-group">
            <label for="nomeChatbot">Nome Chat:</label>{" "}
            <input
              type="text"
              class="form-control"
              id="nomeChatbot"
              placeholder="Inserisci il nome dell tuo user"
              name="nomeChatbot"
              onChange={event => this.props.nomeChatbotNuovoChange(event)}
            />
          </div>
          <div class="form-group">
            <label for="user">User:</label>
            {this.props.userList.map((elem, i) => (
              <React.Fragment>
                <input
                  type="radio"
                  name="user"
                  value={elem.idUser}
                  onChange={event => this.props.userChatbotNuovoChange(event)}
                />
                {elem.username}
              </React.Fragment>
            ))}
          </div>
          <div class="form-group">
            <label for="nodoPadre">Nodo Padre:</label>
            <select class="form-control" name="nodoPadreSelezionato" onChange={event => this.props.nodoPadreChatbotNuovoChange(event)}>
            <option type="radio" name="nodoPadre" value="0">SELECIONE</option>
                    
              {this.props.nodoPadreList.map((elem, i) => (
                <React.Fragment>
                  <option
                    type="radio"
                    name="nodoPadre"
                    value={elem.idNodo}                    
                  >
                    {elem.text}
                  </option>
                </React.Fragment>
              ))}
            </select>
          </div>
          <button
            type="submit"
            class="btn btn-default"
            onClick={() => {
              this.props.insertChatbot();
              this.props.handleClose();
            }}
          >
            Submit
          </button>
        </React.Fragment>
      </div>
    );
  }
}
