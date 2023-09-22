import React from 'react'
import Navbar from './Navbar'
import '../assets/css/Home.css'
function Home() {
  return (
      <>
           <div className="pinkbc1">
      <Navbar/>
    
    <div className="pinkcard">
  <div className="pinkcontent">
    <div className="pinkfront">
      Welcome To MERCADO !
    </div>
    <div className="pinkback">
            <div className="pinkcon1">Purchase at better price</div>
            <div className="pinkcon2">customize your home</div>
            <div className="pinkcon3">with our applainces</div>
            <div className="pinkcon4">at MERCADO</div>
      
    </div>
  </div>
</div>

<div class="container">
    <div class="card">
      <div class="front"></div>
      <div class="back">
        <h1>WELCOME TO</h1>
        <h1 className="head1">MERCADO</h1>
        
       
      </div>
    </div>
  </div>
   </div>
    </>
  )
}

export default Home