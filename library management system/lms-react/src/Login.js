import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        }
    }
    notify = () => toast("Unauthorized User");
    
    login=()=>{
        console.log("login clicked");
        console.log(this.state.username,this.state.password,"credencials");
        //change the login api
        fetch('http://localhost:8080/login/auth', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify({
                id: this.state.username,
                password: this.state.password
            })
        })
        .then(results => results.json())
        .then(json => {
            console.log(json);
            if (json.statusCode == 401) this.notify();
            //change the json.userStatus with exact var in json
            if (json.users[0].userType == "normal") this.props.history.push("/user/");
            if (json.users[0].userType == "admin") this.props.history.push("/admin/");
            if (json.users[0].userType == "librariyan") this.props.history.push("/librariyan/");
            
        }).catch(error=>{

          this.notify()
        }
        )
    }

    render() {
        
        return (
          <div>
            <MuiThemeProvider>
              <div>
                <AppBar title="Login" />
                <TextField
                  hintText="Enter your Username"
                  floatingLabelText="Username"
                  onChange={(event, newValue) =>
                    this.setState({ username: newValue })
                  }
                />
                <br />
                <TextField
                  type="password"
                  hintText="Enter your Password"
                  floatingLabelText="Password"
                  onChange={(event, newValue) =>
                    this.setState({ password: newValue })
                  }
                />
                <br />
                <RaisedButton
                  label="Submit"
                  primary={true}
                  style={style}
                  onClick={this.login}
                />
                <ToastContainer />
              </div>
            </MuiThemeProvider>
          </div>
        );
    }
}
const style = {
    margin: 15,
};
export default Login;