import React from 'react';
import history from './history';

const API = 'http://localhost:8080';

export default class Registrazione extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            listaaziende: [],
            user:[]
        }
        this.register = this.register.bind(this);
    }
    componentDidMount() {
        fetch(API + "/aziende", {
            method : 'GET'
        })
            .then(response => response.json())
            .then(result => {
                this.setState({ listaaziende : result})
            })
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
                //this.setState({user : result}),
                history.push("/login")
            })
    }

    render(){
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
                            <select name = "azienda" className = "custom-select" id="azienda">
                                {
                                    this.state.listaaziende.map((elem) =>
                                        <option value = {elem.idAzienda}> {elem.nomeAzienda} </option>
                                    )
                                }
                            </select>
                        </div>
                        <button type = "submit" className = "btn btn-primary">Registrati</button>
                    </form>
                </div>
        );
    }
}