class Header extends React.Component {
    constructor(props){
        super(props);
        console.log(this.props);
    }
    render() {
        return React.createElement('h1', null, 'Header');
    }
}

class Footer extends React.Component {
    render() {
        return React.createElement('h1', null, 'Footer');
    }
}

class Content extends React.Component {
    constructor(props){
        super(props);
        console.log(this.props);
    }
    render() {
       // return React.createElement('p', null, 'Content');
        return React.createElement('ul', null,
        this.props.item.map((value,index)=>{
           return React.createElement('li',{key:index},value);
        })
        )
    }
}

const items = ['bag','pemcil','book']
const header = React.createElement(Header, { item: ['bag'] });
const footer = React.createElement(Footer)
const content = React.createElement(Content,{item : items})
const myApp = React.createElement('div', null, header, footer, content);

ReactDOM.render(myApp, document.getElementById('app'));