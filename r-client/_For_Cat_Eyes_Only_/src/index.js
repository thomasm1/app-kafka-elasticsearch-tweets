// @flow
import React from 'react';
import ReactDOM from 'react-dom'

/* GLOBAL IMPORTS */
import 'jquery';
import 'materialize-css';

import type { Store } from 'redux';
import { Provider } from 'react-redux';
import { Router, Route, browserHistory } from 'react-router';
import { create } from './reducer';
import { routes as producerRoutes} from './app/Producer/routes';
import { routes as xpansivRoutes} from './app/Xpansiv/routes';
import { routes as buyerRoutes} from './app/Buyer/routes';
import { App } from './app/App';
import localStorage from 'localStorage';

import axios from 'axios';

import { get, debounce } from 'lodash';

/* */
const store: Store = create(axios.create({
  baseURL: `http://${process.env.API_URL || 'http://localhost:8080'}/`,
  headers: {
    common: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      ...JSON.parse(localStorage.getItem('GEM-AUTH'))
    }
  }
}));

/* app */

class Index extends React.Component {
  render () {
    return (
      <Provider store={store}>
        <Router history={browserHistory}>
          <Route
            path='/'
            component={App}
            onChange={(prevState, nextState) => {
              if (nextState.location.action !== "POP") {
                window.scrollTo(0, 0);
              }
            }
          }>
            { producerRoutes(store, store.dispatch) }
            { xpansivRoutes(store, store.dispatch) }
            { buyerRoutes(store, store.dispatch) }
          </Route>
        </Router>
      </Provider>
    );
  }
}

ReactDOM.render(<Index/>, document.getElementById('content'));
