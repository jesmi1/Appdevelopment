import React from 'react'
import { Footer, Navbar } from '../components'
import Dashboard from './Dashboard'
import dashbg from "../assets/css/dashbg.avif"
import Layout from './Layout'
const Dashpage = () => {
  return (
    <div >
        
     <div><Layout/></div>
     <Navbar/>
     <Dashboard/>
     
     <div class=" p-20 bg-dark-subtle text-emphasis-light position-absolute top-50 start-50 translate-middle">
      Welcome User1!
     </div>
     <Footer/>
    </div>
    
  )
}

export default Dashpage