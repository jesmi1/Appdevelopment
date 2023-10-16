import React from 'react'
import '../assets/css/style.css'
import { Footer, Navbar } from '../components'
import {useNavigate } from 'react-router-dom'
const Dashboard = () =>{
    const nav = new useNavigate();
  return (
    <>

    <div className='left-bar'>
        <div className='left-bar-container'>
            <button className='left-bar-button nav-btn' >
                Dashboard
            </button>
            <button className='left-bar-button nav-btn' onClick={()=>nav("/")}>
                Home
            </button>
            <button className='left-bar-button nav-btn' onClick={()=>nav("/product")}>
                Products
            </button>
            
    
          

        </div>
    </div>
</>

  )
}

export default Dashboard