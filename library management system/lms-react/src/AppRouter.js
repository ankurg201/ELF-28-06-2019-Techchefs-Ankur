import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Login from "./Login";
import User from "./User";
import Admin from "./Admin";
import Librariyan from "./Librariyan";


import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import UserScreen from "./UserScreen";

function AppRouter() {
  return (
    <Router>
      <Route path="/" exact component={Login} />
      <Route path="/user/" component={UserScreen} />
      <Route path="/admin/" component={Admin} />
      <Route path="/librariyan/" component={Librariyan} />
    </Router>
  );
}

export default AppRouter;
