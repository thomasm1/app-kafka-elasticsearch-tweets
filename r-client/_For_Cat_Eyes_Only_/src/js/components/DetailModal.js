import React from "react";
import { render } from "react-dom";
import Modal from "react-responsive-modal";
import Paper from 'material-ui/Paper';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';


const styles = {
  fontFamily: "sans-serif",
  textAlign: "center",
  minWidth: "90%"
};
const pstyle = {
  //height: 400,
  width: 400,
  margin: 0,
  padding: 40,
  textAlign: 'center',
  display: 'inline-block',
};

export default class DetailModal extends React.Component {
  render() {
    return (
      <div style={styles}>
        {/*<h2>react-responsive-modal</h2>
        <button onClick={() => this.props.openModal()}>Open modal</button>*/}
        <Modal open={this.props.open} onClose={() => this.props.closeModal()} little>
          <h2>Transaction details</h2>
          <p>Details for {this.props.portfolioItemUID}.</p>
          <MuiThemeProvider>
          <Paper style={pstyle} zDepth={1}><p>Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet consectetur adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?</p></Paper>
          </MuiThemeProvider>
        </Modal>
      </div>
    );
  }
}
