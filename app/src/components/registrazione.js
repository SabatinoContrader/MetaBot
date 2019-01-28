import React from 'react';
import history from './history';

const API = "http://localhost:8080";

export default class Registrazione extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            aziendeList: [],
        };
        this.register = this.register.bind(this);
    }

    componentDidMount() {

        let initAz = [];
        fetch(API + "/aziende", {
            method : 'GET'
        }).then(response => {return response.json();
        }).then(result => {
            initAz = result.map((az) => {
                return az
            });
            console.log(initAz);
            this.setState({aziendeList : initAz,});
        });


    }
    register(event){
        event.preventDefault();
        const formData = new FormData(event.target);

        fetch( API + "/users/register", {
            method : 'POST',
            body : formData
        })
            .then(response => response.json())
            .then( result => {
                if(result){
                    this.setState({user : result});
                    alert("Registrazione effettuata");
                }else alert("Errore durante la registrazione");
                history.push("/");
            })
    }

    render(){
        let az = this.state.aziendeList;
        let list = az.map((e) => <option key={e.idAzienda} value={e.idAzienda}>{e.nomeAzienda}</option>)
        return(
                <div className= "container">
                    <form onSubmit={this.register} className="form-horizontal">
                        <div className="form-group">
                            <label htmlFor="username_field">Username </label>
                            <input name = "username" type = "text" className = "form-control" id = "username_field"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password_field">Password </label>
                            <input name = "password" type = "text" className = "form-control" id ="username_field"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="email_field">Email </label>
                            <input name = "email" type = "email" className = "form-control" id ="username_field"/>
                        </div>

                        <div className="form-group">
                            <input name = "ruolo" type = "hidden" value = "UTENTE"/>
                        </div>

                        <div className="form-group">
                            <label htmlFor="azienda_field">Azienda </label>
                            <select name="azienda" className="custom-select" id="azienda_field">
                                {list}
                            </select>

                        </div>

                        <button type = "submit" className = "btn btn-primary">Registrati</button>
                    </form>
                </div>
        );
    }
}