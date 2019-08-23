import React from 'react'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'
import { Navbar, Nav, NavDropdown, Form, FormControl, Button } from 'react-bootstrap'
import { Login } from '../login/login'
import { HomePage } from '../homePage/HomePage'
export const PublicHome = (props) => {
    return (
        <Router>
            <Route exact path="/" component={Login} />
            <Route exact path="/homePage" component={HomePage}/>
            {/* <Route exact path="/info" component={Info}/> */}
        </Router>
    )
} 