import React from 'react';
import User from './User'
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import SearchIcon from "@material-ui/icons/Search";
import InputBase from "@material-ui/core/InputBase";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import { fade, makeStyles } from "@material-ui/core/styles";

const classes = makeStyles(theme => ({
    grow: {
      flexGrow: 1
    },
    menuButton: {
      marginRight: theme.spacing(2)
    },
    card: {
      maxWidth: 345
    },
    media: {
      height: 140
    },
    title: {
      display: "none",
      [theme.breakpoints.up("sm")]: {
        display: "block"
      }
    },
    search: {
      position: "relative",
      borderRadius: theme.shape.borderRadius,
      backgroundColor: fade(theme.palette.common.white, 0.15),
      "&:hover": {
        backgroundColor: fade(theme.palette.common.white, 0.25)
      },
      marginRight: theme.spacing(2),
      marginLeft: 0,
      width: "100%",
      [theme.breakpoints.up("sm")]: {
        marginLeft: theme.spacing(3),
        width: "auto"
      }
    },
    searchIcon: {
      width: theme.spacing(7),
      height: "100%",
      position: "absolute",
      pointerEvents: "none",
      display: "flex",
      alignItems: "center",
      justifyContent: "center"
    },
    inputRoot: {
      color: "inherit"
    },
    inputInput: {
      padding: theme.spacing(1, 1, 1, 7),
      transition: theme.transitions.create("width"),
      width: "100%",
      [theme.breakpoints.up("md")]: {
        width: 200
      }
    },
    sectionDesktop: {
      display: "none",
      [theme.breakpoints.up("md")]: {
        display: "flex"
      }
    },
    sectionMobile: {
      display: "flex",
      [theme.breakpoints.up("md")]: {
        display: "none"
      }
    }
  }));
  

class UserScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state={
        book:[],
        issueBook:{
            id:'',
            status:'',
            issueDate:'',
            returnDate:''
        }
    }
    this.issueBook = this.issueBook.bind(this);
  }
  

  componentDidMount() {
        console.log("component mount");
        //console.log(this.state.username,this.state.password,"credencials");
        //change the login api
        fetch('http://localhost:8080/user/fetchBook', {
            method: 'GET',
            headers: {
                'Content-type': 'application/json',
            }
        })
        .then(results => results.json())
        .then(json => {
            this.setState({book:json.books})
            console.log("hhhhhhhh",this.state.book[0]);
            return this.state.book;
        }).catch(error=>{
            console.log("ERROR");
        //   this.notify()
        }
        )
  }
  issueBook(id) {
      this.state.issueBook.id=id
      this.state.issueBook.status=0
    fetch('http://localhost:8080/user/issueBook', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: {
                BookAllotment:{
                id: this.state.id,
                status: this.state.status,
                issueDate:this.state.issueDate,
                returnDate:this.state.returnDate
                }
            }
        })
        .then(results => results.json())
        .then(json => {
            if (json.statusCode == 401) this.notify();
        }).catch(error=>{
            console.log("ERROR");
        //   this.notify()
        }
        )
  }
  

  render() {
    return (
        
        <div class="container">
            <div class="row">
            <div class="col-md-12">
            <AppBar position="static">
        <Toolbar>
          <IconButton
            edge="start"
            className={classes.menuButton}
            color="inherit"
            aria-label="open drawer"
          >
            <MenuIcon />
          </IconButton>
          <Typography className={classes.title} variant="h6" noWrap>
            User
          </Typography>
          <div className={classes.search}>
            <div className={classes.searchIcon}>
              <SearchIcon />
            </div>
            <InputBase
              placeholder="Search…"
              classes={{
                root: classes.inputRoot,
                input: classes.inputInput
              }}
              inputProps={{ "aria-label": "search" }}
            />
          </div>
          <div className={classes.grow} />
          <div className={classes.sectionDesktop}>
          </div>
        </Toolbar>
      </AppBar>
      </div>
        {this.state.book.map((book1)=>{
            return (
                <div class="col-md-4">
                <Card style={{ margin: 15 }}>
                <CardActionArea>
                  <CardMedia
                    component="img"
                    image="./pic1.jpg"
                  />
                  <CardContent>
                    <Typography gutterBottom variant="h5" component="h2">
                    {book1.name}
                    </Typography>
                    <Typography variant="body2" color="textSecondary" component="p">
                      {book1.author}
                    </Typography>
                  </CardContent>
                </CardActionArea>
                <CardActions style={{ justifyContent: "center" }}>
                  <Button size="small" color="primary" onClick={()=>this.issueBook(book1.id)}>
                    Issue
                  </Button>
                </CardActions>
              </Card>
              </div>
            )
        })
    }
    </div>
    </div>
    )
  }
}

export default UserScreen;