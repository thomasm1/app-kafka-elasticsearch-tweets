import React, { useEffect, useState } from 'react'
import { deleteDashboard, getAllDashboards } from '../services/DashboardService';
import { Link, useNavigate } from 'react-router-dom';

const ListDashboardComponent = () => {

    const [dashboards, setDashboards] = useState([]);

    const navigator= useNavigate();

    useEffect( () => {
       listOfDashboards();
    }, [])

    function listOfDashboards(){
        getAllDashboards().then((response) => {
            console.log(response.data);
            setDashboards(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function updateDashboard(id){
        navigator(`/edit-dashboard/${id}`)
    }


    function removeDashboard(id){
        deleteDashboard(id).then((response) => {
            console.log(response.data);
            listOfDashboards();
        }).catch(error => {
            console.error(error);
        })
    }
  return (
    <div className='container'>
        <h2 className='text-center'>List of Dashboards</h2>
        <Link to='/add-dashboard' className='btn btn-primary mb-2'>Add Dashboard</Link>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Dashboard Id</th>
                    <th>Dashboard Name</th>
                    <th>Dashboard Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    dashboards.map( dashboard => 
                            <tr key={dashboard.id}>
                                <td> {dashboard.id} </td>
                                <td> {dashboard.dashboardName} </td>
                                <td> {dashboard.dashboardDescription} </td>
                                <td>
                                    <button onClick={() => updateDashboard(dashboard.id)} className='btn btn-info'>Update</button>
                                    <button onClick={() => removeDashboard(dashboard.id)} className='btn btn-danger'
                                        style={{marginLeft: "10px"}}
                                    >Delete</button>
                                </td>
                            </tr>
                        )
                }
            </tbody>
        </table>

    </div>
  )
}

export default ListDashboardComponent