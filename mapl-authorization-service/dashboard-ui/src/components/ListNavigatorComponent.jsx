import React, {useEffect, useState} from 'react'
import { deleteNavigator, listNavigators } from '../services/NavigatorService'
import { useNavigate } from 'react-router-dom'

const ListNavigatorComponent = () => {

    const [navigators, setNavigators] = useState([])

    const navigator= useNavigate();

    useEffect(() => {
        getAllNavigators();
    }, [])

    function getAllNavigators() {
        listNavigators().then((response) => {
            setNavigators(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    function addNewNavigator(){
        navigator('/add-navigator')
    }

    function updateNavigator(id) {
        navigator(`/edit-navigator/${id}`)
    }

    function removeNavigator(id){
        console.log(id);

        deleteNavigator(id).then((response) =>{
            getAllNavigators();
        }).catch(error => {
            console.error(error);
        })
    }

  return (
    <div className='container'>

        <h2 className='text-center'>List of Navigators</h2>
        <button className='btn btn-primary mb-2' onClick={addNewNavigator}>Add Navigator</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Navigator Id</th>
                    <th>Navigator First Name</th>
                    <th>Navigator Last Name</th>
                    <th>Navigator Email Id</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    navigators.map(navigator => 
                        <tr key={navigator.id}>
                            <td>{navigator.id}</td>
                            <td>{navigator.firstName}</td>
                            <td>{navigator.lastName}</td>
                            <td>{navigator.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => updateNavigator(navigator.id)}>Update</button>
                                <button className='btn btn-danger' onClick={() => removeNavigator(navigator.id)}
                                    style={{marginLeft: '10px'}}
                                >Delete</button>
                            </td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListNavigatorComponent