 
 import React from 'react';
 import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
 import Paper from 'material-ui/Paper';
 import RaisedButton from 'material-ui/RaisedButton';
 import {
   cyan50 
 } from 'material-ui/styles/colors';
 import '../../css/application.css';
 
 const paperstyle0 = {
   width: '100%',
   margin: 0,
   textAlign: 'center',
   display: 'inline-block',
 };
 const paperstyle1 = {
   width: 320,
   margin: 20,
   padding: 40,
   textAlign: 'center',
   verticalAlign: 'top',
   display: 'inline-block',
   borderRadius: 40,
   backgroundColor: cyan50
 };
 
 const btnstyle = {
   margin: 12,
 };
 
 class Login extends React.Component {
     render(){
         return (
             <MuiThemeProvider>
 
        <Paper className="single-widget-container"> 
                <Header className="text-align-center">
                    <h4>Login to your account</h4>
                    <a href="index.html"><i class="fa fa-home"></i>
                        <img src="../images/xpansiv.svg" alt="xpansiv logo" />
                        <span class="name">Market Dashboard</span></a>
                </Header>
                <div className="body">
                    <form className="no-margin"
                          action="#play" method="get">
                        <fieldset>
                            <div className="form-group">
                                <label for="email" >Email</label>
                                <div className="input-group">
                                    <span className="input-group-addon">
                                        <i className="fa fa-user"></i>
                                    </span>
                                    <input id="email" type="email" className="form-control input-lg input-transparent"
                                           placeholder="Your Email">
                                </div>
                            </div>
                            <div className="form-group">
                                <label for="password" >Password</label>

                                <div className="input-group input-group-lg">
                                    <span className="input-group-addon">
                                        <i className="fa fa-lock"></i>
                                    </span>
                                    <input id="password" type="password" className="form-control input-lg input-transparent"
                                           placeholder="Your Password">
                                </div>
                            </div>
                        </fieldset>
                        <div className="form-actions">

                        
                            <button type="submit" className="btn btn-block btn-lg btn-danger">
                                <span className="small-circle"><i className="fa fa-caret-right"></i></span>
                                <small>Sign In</small>
                            </button>
                            <a className="forgot" href="#">Forgot Username or Password?</a>
                        </div>
                    </form>
                </div>
                <footer>
             <!--       <div className="facebook-login">
                        <a href="index-2.html"><span><i className="fa fa-facebook-square fa-lg"></i> LogIn with Facebook+</span></a>
                    </div>
                -->
             </footer> 
        </Paper>



        </MuiThemeProvider>
			)
	}
}