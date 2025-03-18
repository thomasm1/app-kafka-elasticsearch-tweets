import React, { useEffect, useState } from 'react'
import { createDashboard, getDashboardById, updateDashboard } from '../services/DashboardService';
import { useNavigate, useParams } from 'react-router-dom';

const DashboardComponent = () => {

  const [dashboardName, setDashboardName] = useState('')
  const [dashboardDescription, setDashboardDescription] = useState('')

  const {id} = useParams();

  const navigator= useNavigate();

  useEffect(() => {

    getDashboardById(id).then((response) => {
      setDashboardName(response.data.dashboardName);
      setDashboardDescription(response.data.dashboardDescription);
    }).catch(error => {
      console.error(error);
    })

  }, [id])

  function saveOrUpdateDashboard(e){
    e.preventDefault();

    const dashboard = { dashboardName, dashboardDescription }

    console.log(dashboard); 

    if(id){
      updateDashboard(id, dashboard).then((response) => {
        console.log(response.data);
        navigator('/dashboards');
      }).catch(error => {
        console.error(error);
      })
    }else {
      createDashboard(dashboard).then((response) => {
        console.log(response.data);
        navigator('/dashboards')
      }).catch(error => {
        console.error(error);
      })
    }

  }

  function pageTitle(){
    if(id){
        return <h2 className='text-center'>Update Dashboard</h2>
    } else {
        return <h2 className='text-center'>Add Dashboard</h2>
    }
  }

  return (
    <div className='container'><br /><br />
      <div className='row'>
          <div className='card col-md-6 offset-md-3 offset-md-3'>
              {
                pageTitle()
              }

              <div className='card-body'>
                  <form>
                      <div className='form-group mb-2'>
                          <label className='form-label'>Dashboard Name:</label>
                          <input
                            type='text'
                            name='dashboardName'
                            placeholder='Enter Dashboard Name'
                            className='form-control'
                            value={dashboardName}
                            onChange={(e) => setDashboardName(e.target.value)}

                          >
                          </input>
                      </div>

                      <div className='form-group mb-2'>
                          <label className='form-label'>Dashboard Description:</label>
                          <input
                            type='text'
                            name='dashboardDescription'
                            placeholder='Enter Dashboard Description'
                            value={dashboardDescription}
                            onChange={(e) => setDashboardDescription(e.target.value)}
                            className='form-control'
                          >
                          </input>
                      </div>
                      <button className='btn btn-success mb-2' onClick={(e) => saveOrUpdateDashboard(e)}>Submit</button>
                  </form>

              </div>
          </div>

      </div>

    </div>
  )
}

export default DashboardComponent