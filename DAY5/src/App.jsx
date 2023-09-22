import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Login from './pages/Login'
import Register from './pages/Register'
import Dashboard from './pages/Dashboard'
import Appliance from './pages/Appliance'
import Client from './pages/Client'
import Home from './pages/Home'
import Help from './pages/Help'
import AboutUs from './pages/AboutUs'
import Contact from './pages/Contact'


function App() {
  return (
   <>
   <Routes>
    <Route exact path='/' element={<Home/>}/>
    <Route exact path='/Login' element={<Login/>}/>
    <Route exact path='/Register' element={<Register/>}/>
    <Route exact path='/Dashboard'element={<Dashboard/>} />
    <Route exact path='/Appliance' element={<Appliance/>}/>
    <Route exact path='/Client' element={<Client/>}/>
    <Route exact path='/Help and Services' element={<Help/>}/>
    <Route exact path='/AboutUs' element={<AboutUs/>}/>
    <Route exact path='/Contact' element={<Contact/>}/>
  
    
   </Routes>
   
   </>
  )
}

export default App