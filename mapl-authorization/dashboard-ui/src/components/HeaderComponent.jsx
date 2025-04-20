import React from 'react'
import { NavLink } from 'react-router-dom'

const HeaderComponent = () => {
  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-lg navbar-dark bg-dark'>
                <a className="navbar-brand" href="https://wwww.mapl.app">User Management</a>

                <div className="collapse navbar-collapse" id="navbarNav">
                  <ul className="navbar-nav">
                    <li className="nav-item">
                        <NavLink className='nav-link' to='/users'>Users</NavLink>
                    </li>

                    <li className="nav-item">
                        <NavLink className='nav-link' to='/dashboards'>Dashboards</NavLink>
                    </li>
                  </ul>
              </div>

            </nav>
        </header>

    </div>
  )
}

export default HeaderComponent