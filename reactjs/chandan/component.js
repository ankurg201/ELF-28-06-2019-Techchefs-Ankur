function Header(props){
    console.log(props);
    return React.createElement('h1',null,'Header');
}

function Footer(){
    return React.createElement('h1',null,'Footer');
}

function Content(){
    return React.createElement('p',null,'Content');
}

const header = React.createElement(Header,{item:['bag']});
const footer = React.createElement(Footer)
const content = React.createElement(Content)
const myApp = React.createElement('div',null,header,footer,content);

ReactDOM.render(myApp,document.getElementById('app'));