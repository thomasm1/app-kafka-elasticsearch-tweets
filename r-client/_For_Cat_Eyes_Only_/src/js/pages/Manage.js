import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
//import PortfolioTable from '../components/Table';
import PortfolioExpand from '../components/PortfolioExpansion';
//import PortfolioDetail from '../components/PortfolioDetail';
//import PropTypes from 'prop-types';
//import Dialog from 'material-ui/Dialog';
//import FlatButton from 'material-ui/FlatButton';
import api from '../utils/api';

export default class Portfolio extends React.Component {
  constructor (props){
      super(props);
      this.state = {
        portfolioListData: null,
        custodyListData: null,
        gasMakeupData: null,
        selectedSet: 'Active',
        //selectedSet: 'profiletest.json',
        portfolioItemUID: null,
        //Below: table state elements to be passed as props to the table component
    };
    /*Bind context*/
    this.updateSet = this.updateSet.bind(this);  
    this.onOpenModal = this.onOpenModal.bind(this);
    this.onCloseModal = this.onCloseModal.bind(this);
}

    /*Update the portfolioItemUID state to display details for port item////////*/
    /*portfolioItemHandler(passupvar) {
      this.setState({
        portfolioItemUID: `${passupvar}`,
        open: true,
      });
      this.updateDetails(passupvar);
    }*/

    /*Modal handlers////////////////////////////////////////////////////////////*/
    onOpenModal = () => {
      this.setState({ open: true });
    };
    onCloseModal = () => {
      this.setState({ open: false });
    };

    /*Fire AJAX request on component mount/////////////////////////////////////*/
    componentDidMount = () => {
      this.updateSet(this.state.selectedSet)
    }

    /*Update views handler/////////////////////////////////////////////////////*/
    updateSet(selection){
      /*Change the state of the selectedSet -- this could show 'active','retired','put to market',etc*/
      this.setState(function(){
          return {
            selectedSet: selection,
            portfolioListData: null, /*Kill last tab data*/
            //portfolioItemUID: null, /*Nullify the portUID between tab clicks*/
          }
      });
      /*Grab data via /utils/api.js AJAX request and change the data state*/
      api.fetchPortfolioList(selection)
          .then(function(data){
          this.setState(function(){
              return {
                portfolioListData: data
              }
          })
      }.bind(this));
    }

  render(){
    /*const modalActions = [
      <FlatButton
        label="Close"
        primary={true}
        onClick={this.onCloseModal}
      />,
    ];*/
    return (
      <div>
        <h2>Manage Holdings</h2>
        {/*<MuiThemeProvider>
          <Dialog
            title="Transaction Details"
            actions={modalActions}
            modal={false}
            open={this.state.open}
            onRequestClose={this.onCloseModal}
            autoScrollBodyContent={true}
          > 
            <DetailsExist dataCustody={this.state.custodyListData} dataGas={this.state.gasMakeupData} portfolioItemUID={this.state.portfolioItemUID} />
          </Dialog>
        </MuiThemeProvider>
        <MuiThemeProvider>
          <SelectDataSet 
            selectedSet={this.state.selectedSet}
            onSelect={this.updateSet}
          />
        </MuiThemeProvider>*/}
         <MuiThemeProvider>  
          <PortfolioExpand data={this.state.portfolioListData}/>
        </MuiThemeProvider>
      </div>
      )
  }
}