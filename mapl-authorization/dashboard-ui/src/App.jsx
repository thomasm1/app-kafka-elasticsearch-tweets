import './App.css'
import DashboardComponent from './components/DashboardComponent'
import NavigatorComponent from './components/NavigatorComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDashboardComponent from './components/ListDashboardComponent'
import ListNavigatorComponent from './components/ListNavigatorComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* // http://localhost:3000 */}
              <Route path='/' element = { <ListNavigatorComponent />}></Route>
              {/* // http://localhost:3000/navigators */}
              <Route path='/navigators' element = { <ListNavigatorComponent /> }></Route>
              {/* // http://localhost:3000/add-navigator */}
              <Route path='/add-navigator' element = { <NavigatorComponent />}></Route>

              {/* // http://localhost:3000/edit-navigator/1 */}
              <Route path='/edit-navigator/:id' element = { <NavigatorComponent /> }></Route>

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
