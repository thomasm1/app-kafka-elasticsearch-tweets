import React, { Component } from 'react';
import { Route } from 'react-router-dom';
// Page
import FindersHome from '../pages/FindersHome';
import FindersLogin from '../pages/FindersLogin';

class RoutesComponent extends Component {
  render() {
    return (
      <div>
        <Route exact path="/" component={FindersHome} />
        <Route exact path="/login" component={FindersLogin} />
      </div>
    );
  }
}
export default RoutesComponent;