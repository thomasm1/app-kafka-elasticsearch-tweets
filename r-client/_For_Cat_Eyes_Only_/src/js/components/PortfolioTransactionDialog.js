import React from 'react';
import api from '../utils/api';
import Dialog from 'material-ui/Dialog';
import RaisedButton from 'material-ui/RaisedButton';
import FlatButton from 'material-ui/FlatButton';

const btnStyle = {
  margin: 12,
};

export default class PortfolioTransactionDialog extends React.Component {

  constructor (props){
      super(props);
      this.state = {
        selectedDetail: this.props.detailUID,
        selectedFeedstockUID: this.props.detailFeedstockUID,
        selectedTransactionType: null,
        selectedTransactionTypeLabel: null,
        selectedTransactionUnits: this.props.selectedTransactionUnits,
        sendResponse: null,
        openDialog:false

    };
    /*Bind context*/
    this.sendTransactionSubmit = this.sendTransactionSubmit.bind(this);
  }

  /*componentDidMount = () => {
    this.updateDetails(this.state.selectedDetail)
  };*/

  setUnitTotal = (total) => {
    this.setState({selectedTransactionUnits: total});
  };

  handleOpenRetire = () => {
    this.setState({
      openDialog: true, 
      selectedTransactionType: 'Retire',
      selectedTransactionTypeLabel: 'Retire holdings from portfolio',
    });
  };

  handleOpenMarket = () => {
    this.setState({
      openDialog: true, 
      selectedTransactionType: 'Market',
      selectedTransactionTypeLabel: 'Put holdings to the market',
    });
  };

  handleClose = () => {
    console.log("You backed out of transaction or completed one and hit 'close'.");
    this.setState({openDialog: false});
    this.setState({sendResponse: null});
  };

  handleSubmit = () => {
    this.sendTransactionSubmit(this.state.selectedFeedstockUID,this.state.selectedTransactionType,this.state.selectedTransactionUnits);
    //this.setState({openDialog: false});
  };

    /*Send transaction handler///////////////////////////////////////////////////*/
    sendTransactionSubmit(a,b,c){
      this.setState(function(){
          return {
            sendResponse: null, /*Kill last tab data*/
          }
      });
      //Send 'retire' or 'put to market' transaction
      api.sendTransactionData(a,b,c)
          .then(function(data){
          this.setState(function(){
              return {
                sendResponse: "Success! You have done something and this is proof from the rest-api",//data,
              }
          })
      }.bind(this));
    }


	render(){
    const actionBtns = [
      <FlatButton
        label="Cancel"
        primary={true}
        onClick={this.handleClose}
      />,
      <FlatButton
        label="Submit"
        primary={true}
        keyboardFocused={true}
        onClick={this.handleSubmit}
      />,
    ];

    const closeBtn = [
      <FlatButton
        label="Close"
        primary={true}
        onClick={this.handleClose}
      />,
    ];

		return(
			<div>

              {this.props.detailFeedstockStatus==='Active'?
                <div>
                  <RaisedButton label="Retire" style={btnStyle} onClick={this.handleOpenRetire} />
                  <RaisedButton label="Put to Market" style={btnStyle} onClick={this.handleOpenMarket} />
                </div>
                :null
              }
              {this.state.openDialog===true?
              <Dialog
                title={this.state.selectedTransactionTypeLabel}
                actions={this.state.sendResponse===null?actionBtns:closeBtn}
                modal={false}
                open={this.state.openDialog}
                onRequestClose={this.handleClose}
              >

                {this.state.sendResponse===null?
                  <div>
                    <p>You cannot undo this action once you push 'Submit'.</p>
                    <p>Are you sure you want to commit the following action: {this.state.selectedTransactionType}?</p>
                  </div>:
                  <p>{this.state.sendResponse}</p>
                }

              </Dialog>
              :null
              }

      </div>
    )};
}