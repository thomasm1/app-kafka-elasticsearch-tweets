import React from 'react';
import { Link as RouterLink, Route } from 'react-router-dom';
import { FontIcon, ListItem } from 'react-md';
import './navlink.css';    // styles NavLink.js

const NavLink = ({ label, to, exact, icon }) => (
  <Route path={to} exact={exact}>
    {({ match }) => {
      let leftIcon;
      if (icon) {
        leftIcon = <FontIcon>{icon}</FontIcon>;
      }

      return (
        <ListItem   className="nav-wrapper blue"
          component={RouterLink}
          active={!!match}
          to={to}
          primaryText={label}
          leftIcon={leftIcon}
        />
      );
    }}
  </Route>
);

export default NavLink;

