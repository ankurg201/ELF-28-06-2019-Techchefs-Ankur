import React from 'react';
import logo from './logo.svg';
import './App.css';
import Login from "./Login"
import AppRouter from './AppRouter';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

function App() {
    return (
      <div className="App">
     <AppRouter/>
    </div>
  );
}

export default App;
