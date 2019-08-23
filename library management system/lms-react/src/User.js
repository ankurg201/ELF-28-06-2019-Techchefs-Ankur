import React from "react";
import { fade, makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import InputBase from "@material-ui/core/InputBase";
import Badge from "@material-ui/core/Badge";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import MenuIcon from "@material-ui/icons/Menu";
import SearchIcon from "@material-ui/icons/Search";
import AccountCircle from "@material-ui/icons/AccountCircle";
import MailIcon from "@material-ui/icons/Mail";
import NotificationsIcon from "@material-ui/icons/Notifications";
import MoreIcon from "@material-ui/icons/MoreVert";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";

const useStyles = makeStyles(theme => ({
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

const User = (props) =>{

    console.log(props.data,"props at user")

  const classes = useStyles();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);

  const isMenuOpen = Boolean(anchorEl);
  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  function handleProfileMenuOpen(event) {
    setAnchorEl(event.currentTarget);
  }

 

  function handleMobileMenuClose() {
    setMobileMoreAnchorEl(null);
  }

  function handleMenuClose() {
    setAnchorEl(null);
    handleMobileMenuClose();
  }

  function handleMobileMenuOpen(event) {
    setMobileMoreAnchorEl(event.currentTarget);
  }
  
  function logout(){
      props.history.push("/");
  }

  const menuId = "primary-search-account-menu";
  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={menuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMenuOpen
      }
      onClose={handleMenuClose}
    >
      <MenuItem onClick={logout}>Logout</MenuItem>
    </Menu>
  );

  const mobileMenuId = "primary-search-account-menu-mobile";
  const renderMobileMenu = (
    <Menu
      anchorEl={mobileMoreAnchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={mobileMenuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMobileMenuOpen}
      onClose={handleMobileMenuClose}
    >
      <MenuItem>
        <IconButton aria-label="show 4 new mails" color="inherit">
          <Badge badgeContent={4} color="secondary">
            <MailIcon />
          </Badge>
        </IconButton>
        <p>Messages</p>
      </MenuItem>
      <MenuItem onClick={handleProfileMenuOpen}>
        <IconButton
          aria-label="account of current user"
          aria-controls="primary-search-account-menu"
          aria-haspopup="true"
          color="inherit"
        >
          <AccountCircle />
        </IconButton>
        <p>Profile</p>
      </MenuItem>
    </Menu>
  );

  return (
    <div className={classes.grow}>
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
            <IconButton aria-label="show 4 new mails" color="inherit">
              <Badge badgeContent={4} color="secondary">
                <MailIcon />
              </Badge>
            </IconButton>
            <IconButton
              edge="end"
              aria-label="account of current user"
              aria-controls={menuId}
              aria-haspopup="true"
              onClick={handleProfileMenuOpen}
              color="inherit"
            >
              <AccountCircle />
              Ankur
            </IconButton>
          </div>
          <div className={classes.sectionMobile}>
            <IconButton
              aria-label="show more"
              aria-controls={mobileMenuId}
              aria-haspopup="true"
              onClick={handleMobileMenuOpen}
              color="inherit"
            >
              <MoreIcon />
              Ankur
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>

      <div style={{ display: "flex", margin: 30, flexWrap: "wrap" }}>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions style={{ justifyContent: "center" }}>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
        <Card className={classes.card} style={{ margin: 15 }}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              component="img"
              image="./Screen/pic1.jpg"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                Java
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                JDK & Java Concept By ANKUR GUPTA
              </Typography>
            </CardContent>
          </CardActionArea>
          <CardActions>
            <Button size="small" color="primary">
              Issue
            </Button>
          </CardActions>
        </Card>
      </div>

      {renderMobileMenu}
      {renderMenu}
    </div>
  );
}

export default User;