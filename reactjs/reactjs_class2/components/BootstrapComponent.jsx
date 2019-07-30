import React, { Component } from 'react'
import { Button } from 'react-bootstrap'

class BootstrapComponent extends React.Component {
    render() {
    	return ( 
        <div>
    		<Button variant="danger">Hello World Danger</Button>
    		<Button variant="primary">Hello World Primary</Button>
    		<Button variant="success">Hello World Success</Button>
    	</div>
        )
    }
}
export default BootstrapComponent;