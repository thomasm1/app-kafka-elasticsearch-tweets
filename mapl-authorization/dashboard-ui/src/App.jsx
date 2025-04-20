import './App.css'
import DashboardComponent from './components/DashboardComponent'
import UserComponent from './components/UserComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDashboardComponent from './components/ListDashboardComponent'
import ListUserComponent from './components/ListUserComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* // http://localhost:3000 */}
              <Route path='/' element = { <ListUserComponent />}></Route>
              {/* // http://localhost:3000/users */}
              <Route path='/users' element = { <ListUserComponent /> }></Route>
              {/* // http://localhost:3000/add-user */}
              <Route path='/add-user' element = { <UserComponent />}></Route>

              {/* // http://localhost:3000/edit-user/1 */}
              <Route path='/edit-user/:id' element = { <UserComponent /> }></Route>

              {/* // http://localhost:3000/dashboards */}
              <Route path='/dashboards' element = { <ListDashboardComponent />}></Route>

              {/* // http://localhost:3000/add-dashboard */}
              <Route path='/add-dashboard' element = { <DashboardComponent /> }></Route>

              <Route path='/edit-dashboard/:id' element = { <DashboardComponent />}></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
