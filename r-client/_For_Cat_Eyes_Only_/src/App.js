import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import NavigationDrawer from 'react-md/lib/NavigationDrawers';
import NavLink from './NavLink'; 
import Home from './Home';
// import Login from './js/pages/Login';
import Overview from './js/pages/Overview';
import Portfolio from './js/pages/Portfolio';
import Pending from './js/pages/Pending';  
// import Index from './js/pages/Index';
import xpansiv from './images/xpansiv.svg';
 
const navItems = [{
  exact: true,
  label: '',
  to: '/',
  icon: '',
}, {
  label: 'Overview',
  to: '/Overview',
  icon: 'bookmark',
}, {
  label: 'Home',
  to: '/Home',
  icon: 'bookmark',
},  {
  label: 'Portfolio',
  to: '/Portfolio',
  icon: 'donut_large',
}, {
  label: 'Pending',
  to: '/Pending',
  icon: 'flight_land',
}];

class App extends Component {
  render() {
    return (
      <Route
        render={({ location }) => (
          <NavigationDrawer className="blue white-text _pulse"
            drawerTitle="Portfolio"
            logo={xpansiv}
            toolbarTitle="Xpansiv Data Systems"
            navItems={navItems.map(props => <NavLink {...props} key={props.to} />)}
          >
            <Switch key={location.key}>
              <Route exact path="/" location={location} component={Overview} />
              <Route path="/Overview" location={location} component={Overview} />
              <Route path="/Home" location={location} component={Home} />
              <Route path="/Portfolio" location={location} component={Portfolio} />
              <Route path="/Pending" location={location} component={Pending} />
            </Switch>
          </NavigationDrawer>
        )}
      />
    );
  }
}

export default App;
