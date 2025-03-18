import React, { useState, useEffect } from 'react'
import { createNavigator, getNavigator, updateNavigator } from '../services/NavigatorService'
import { useNavigate, useParams } from 'react-router-dom';
import { getAllDashboards } from '../services/DashboardService';

const NavigatorComponent = () => {

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [dashboardId, setDashboardId] = useState('')
    const [dashboards, setDashboards] = useState([])

    useEffect(() => {
        getAllDashboards().then((response) => {
            setDashboards(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    const {id} = useParams();
    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: '',
        dashboard: ''
    })

    const navigator= useNavigate();

    useEffect(() => {

        if(id){
            getNavigator(id).then((response) => {
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setEmail(response.data.email);
                setDashboardId(response.data.dashboardId)
            }).catch(error => {
                console.error(error);
            })
        }

    }, [id])

    function saveOrUpdateNavigator(e){
        e.preventDefault();

        if(validateForm()){

            const navigator = {firstName, lastName, email, dashboardId}
            console.log(navigator)

            if(id){
                updateNavigator(id, navigator).then((response) => {
                    console.log(response.data);
                    navigator('/navigators');
                }).catch(error => {
                    console.error(error);
                })
            } else {
                createNavigator(navigator).then((response) => {
                    console.log(response.data);
                    navigator('/navigators')
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateForm(){
        let valid = true;

        const errorsCopy = {... errors}

        if(firstName.trim()){
            errorsCopy.firstName = '';
        } else {
            errorsCopy.firstName = 'First name is required';
            valid = false;
        }

        if(lastName.trim()){
            errorsCopy.lastName = '';
        } else {
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }

        if(email.trim()){
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Email is required';
            valid = false;
        }

        if(dashboardId){
            errorsCopy.dashboard = ''
        }else {
            errorsCopy.dashboard = 'Select Dashboard'
            valid = false
        }

        setErrors(errorsCopy);
        
        return valid;

    }

    function pageTitle(){
        if(id){
            return <h2 className='text-center'>Update Navigator</h2>
        }else{
            return <h2 className='text-center'>Add Navigator</h2>
        }
    }

  return (
    <div className='container'>
        <br /> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
               {
                    pageTitle()
               }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name:</label>
                            <input
                                type='text'
                                placeholder='Enter Navigator First Name'
                                name='firstName'
                                value={firstName}
                                className={`form-control ${ errors.firstName ? 'is-invalid': '' }`}
                                onChange={(e) => setFirstName(e.target.value)}
                            >
                            </input>
                            { errors.firstName && <div className='invalid-feedback'> { errors.firstName} </div> }
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name:</label>
                            <input
                                type='text'
                                placeholder='Enter Navigator Last Name'
                                name='lastName'
                                value={lastName}
                                className={`form-control ${ errors.lastName ? 'is-invalid': '' }`}
                                onChange={(e) => setLastName(e.target.value)}
                            >
                            </input>
                            { errors.lastName && <div className='invalid-feedback'> { errors.lastName} </div> }
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Email:</label>
                            <input
                                type='text'
                                placeholder='Enter Navigator Email'
                                name='email'
                                value={email}
                                className={`form-control ${ errors.email ? 'is-invalid': '' }`}
                                onChange={(e) => setEmail(e.target.value)}
                            >
                            </input>
                            { errors.email && <div className='invalid-feedback'> { errors.email} </div> }
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Select Dashboard:</label>
                            <select
                               className={`form-control ${ errors.dashboard ? 'is-invalid': '' }`}
                               value={dashboardId}
                                onChange={(e) => setDashboardId(e.target.value)}
                            >
                               <option value="Select Dashboard">Select Dashboard</option>
                                {
                                    dashboards.map( dashboard => 
                                        <option key={dashboard.id} value={dashboard.id} > {dashboard.dashboardName}</option>
                                        )
                                }
                            </select>
                            { errors.dashboard && <div className='invalid-feedback'> { errors.dashboard} </div> }
                        </div>
                        <button className='btn btn-success' onClick={saveOrUpdateNavigator} >Submit</button>
                    </form>

                </div>
            </div>

        </div>

    </div>
  )
}

export default NavigatorComponent