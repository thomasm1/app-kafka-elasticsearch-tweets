import React, { Component } from 'react';
import NavigatorService from '../service/NavigatorService';

class NavigatorComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            navigator: {},
            dashboard: {},
            organization: {}
        }        
    }

    componentDidMount(){
        NavigatorService.getNavigator().then((response) => {
            this.setState({navigator : response.data.navigator})
            this.setState({dashboard : response.data.dashboard})
            this.setState({ organization : response.data.organization})

            console.log(this.state.navigator)
            console.log(this.state.dashboard)
            console.log(this.state.organization)
        })
    }
    
    
    render() {
        return (
            <div> <br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Navigator Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Navigator First Name: </strong> {this.state.navigator.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Navigator Last Name: </strong> {this.state.navigator.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Navigator Email: </strong> {this.state.navigator.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Dashboard Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Dashboard Name: </strong> {this.state.dashboard.dashboardName }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Dashboard Description: </strong> {this.state.dashboard.dashboardDescription }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Dashboard code: </strong> {this.state.dashboard.dashboardCode }</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Organization Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong> Organization Name: </strong> {this.state.organization.organizationName } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Description: </strong> {this.state.organization.organizationDescription } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Code: </strong> {this.state.organization.organizationCode } </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default NavigatorComponent;