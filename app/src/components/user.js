import React from 'react';
import Navbar from './navbar';
const API = "http://localhost:8080";


export default class User extends React.Component {


    constructor(props){
        super(props);
        this.state = {
            usersList : [],
            aziendeList : [],
        };
        this.getUtentiGestibili = this.getUtentiGestibili.bind(this);
        this.getListaAziende = this.getListaAziende.bind(this);
    }

    componentDidMount(){
        this.getUtentiGestibili();
    }

    getListaAziende(){
        let initAz = [];
        fetch(API + "/aziende", {
            method : 'GET'
        }).then(response => {return response.json();
        }).then(result => {
            initAz = result.map((az) => {
                return az
            });
            this.setState({aziendeList : initAz,});
        });
    }

    getUtentiGestibili(){
        let initUs = [];
        let userReq = JSON.parse(localStorage.getItem("currentUser"));
        fetch(API + "/users/utentigestibili", {
            method : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',

            },
            body : JSON.stringify({
                idUser : userReq.idUser,
                username : userReq.username,
                password : userReq.password,
                email : userReq.email,
                ruolo : userReq.ruolo,
                aziendaDTO : userReq.aziendaDTO
            })
        }).then(response => {
            return response.json();
        }).then( result => {
            initUs = result.map((us) => {
                return us;
            });
            this.setState({usersList : initUs,});
        });
    }

    eliminaUtente = i =>{
        fetch(API + "/users/delete/" + i, {
            method: "GET",
        })
            .then(response => response.json())
            .then(result => {
                if (result) {
                    alert("Errore");
                } else {
                    alert("Utente eliminato");
                    this.getUtentiGestibili();
                } 
            });
    }

    submitAggiungiUtente = event =>{
        event.preventDefault();
        const formData = new FormData(event.target);

        fetch( API + "/users/register", {
            method : 'POST',
            body : formData
        })
            .then(response => response.json())
            .then( result => {
                if(result) {
                    alert("Utente creato");
                     this.getUtentiGestibili();
                }else alert("Errore durante la creazione");
            });
    }
    generaOptionAziende = () => {
        this.getListaAziende();
        let az = this.state.aziendeList;
        return(
            az.map((e) =>
                <option key={e.idAzienda} value={e.idAzienda}>{e.nomeAzienda}</option>
            ));
    }
    generaFormAggiungiUtente(){
        let userReq = JSON.parse(localStorage.getItem("currentUser"));
        let ruoloInput;
        let aziendaInput;
        if(userReq.ruolo.toUpperCase() === "ADMIN")
            ruoloInput =
                <div className = "form-group row">
                    <label htmlFor="ruolo_field">Ruolo </label>
                    <select name="ruolo" className="custom-select" id="ruolo_field">
                            <option defaultValue value = "ADMIN"> ADMIN </option>
                            <option value = "CHATMASTER"> CHATMASTER</option>
                    </select>
                </div>;
        else ruoloInput = <input hidden name="ruolo" type="text" value="CHATMASTER" id="ruolo_field"/>;

        if(userReq.aziendaDTO.nomeAzienda.toUpperCase() === "CONTRADER")
            aziendaInput =
                <div className="form-group row">
                    <label htmlFor="azienda_field">Azienda </label>
                    <select name="azienda" className="custom-select" id="azienda_field">
                        {this.generaOptionAziende()}
                    </select>
                </div>;
        else
            aziendaInput = <input name = "azienda" hidden type="text" value={userReq.aziendaDTO.idAzienda} id="azienda_field"/>;
        return(
            <form onSubmit = { this.submitAggiungiUtente } className = "form-horizontal">
                <div className = "form-group row" >
                    <label htmlFor="username_field">Username </label>
                    <input name = "username" type = "text" className = "form-control" id = "username_field"/>
                </div>
                <div className = "form-group row">
                    <label htmlFor="password_field">Password </label>
                    <input name = "password" type = "text" className = "form-control" id ="username_field"/>
                </div>
                <div className = "form-group row">
                    <label htmlFor="email_field">Email </label>
                    <input name = "email" type = "email" className = "form-control" id ="username_field"/>
                </div>

                {ruoloInput}
                {aziendaInput}
                <button type = "submit" className = "btn btn-primary"> Aggiungi </button>
            </form>
        );
    }

    render() {
        let form = this.generaFormAggiungiUtente();
        return(
            <React.Fragment>
                <Navbar/>
                <div className="container">

                    <h3>Crea Utente </h3>

                        {form}
                    <hr />
                    <h4>Utenti</h4>
                    <table className="table table-light table-bordered table-hover">
                        <thead>
                            <tr>
                                <th scope = "col"> ID User</th>
                                <th scope = "col"> Username</th>
                                <th scope = "col"> Password</th>
                                <th scope = "col"> Email</th>
                                <th scope = "col"> Ruolo</th>
                                <th scope = "col"> Azienda</th>
                                <th scope = "col"> </th>
                            </tr>
                        </thead>

                            {
                                this.state.usersList.map( (u, i) => (
                                <tbody>
                                    <tr>
                                        <td>{u.idUser}</td>
                                        <td>{u.username}</td>
                                        <td>{u.password}</td>
                                        <td>{u.email}</td>
                                        <td>{u.ruolo}</td>
                                        <td>{u.aziendaDTO.nomeAzienda}</td>
                                        <td><button className = "btn"
                                            onClick={() => this.eliminaUtente(u.idUser)}>Elimina
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                                ))
                            }

                    </table>
                </div>
            </React.Fragment>
        )
    }
}