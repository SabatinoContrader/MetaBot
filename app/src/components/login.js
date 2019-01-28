import React from 'react';
import history from './history';
import { Link } from 'react-router-dom';

const API = 'http://localhost:8080/users/login';

export default class Login extends React.Component {

  constructor(props) {
    super(props);

    this.login = this.login.bind(this);
  }
  componentDidMount() {
    localStorage.setItem( "currentUser", null);
  }

  render() {
    return (
      <React.Fragment>
        <div className="modal-dialog">
          <div className="modal-content">
            <form onSubmit={this.login}>
              <div className="modal-header">
                <h2 className="modal-title">Login</h2>
              </div>
              <div className="modal-body">
              <label htmlFor="username" className="col-form-label">Username:</label>
              <input className="form-control" id="username" name="username" type="text" />
              <label htmlFor="password" className="col-form-label">Password:</label>
              <input className="form-control" id="password" name="password" type="text" />
              <br></br><br></br>
              <div className="modal-footer">
              <button  className="btn btn-primary">Login</button>
                <div className="nav-item">
                  <Link to={'/registrazione'}><button className="btn btn-primary">Registrati</button></Link>
                </div>
              </div>
              </div>
            </form>

          </div>

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
    }).then(response => response.json())
      .then(result => {localStorage.setItem( 'currentUser' ,JSON.stringify(result) )
      });
     history.push("/home");
  }
}
