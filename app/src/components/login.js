import React from 'react';
import User from './../models/user';
import history from './history';

const API = 'http://localhost:8080/users/login';

export default class Login extends React.Component {

  constructor(props) {
    super(props);

    this.login = this.login.bind(this);
    this.state = { u: new User(0, "", "", "", "") };
  }

  render() {
    return (
      <React.Fragment>
        <div className="text-center">
          <form onSubmit={this.login}>
            <h2>Login</h2>
            <br></br><br></br>
            <h2>Username:</h2>
            <input id="username" name="username" type="text" />
            <h2>Password:</h2>
            <input id="password" name="password" type="text" />
            <br></br><br></br>
            <button>Login</button>
          </form>
        </div>
      </React.Fragment>
    );


  }
  login(event) {
    event.preventDefault();
    const formData = new FormData(event.target);

    fetch(API, {
      method: 'POST',
      body: formData,
    })
      .then(response => response.json())
      .then(result => {
        this.setState({ u: result })

      })

    history.push("home");
  }
}
