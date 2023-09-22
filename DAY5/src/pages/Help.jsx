import React from 'react'
import Layout from '../components/Layout'
import '../assets/css/Appointment.css'
import AppointmentBg from "../assets/img/AppointmentBg.mp4"

function Help() {
    return (
        <>
            <video autoPlay loop muted>
                <source src={AppointmentBg} type="video/mp4" />

            </video>

            <Layout />
            <div className='main-wrapper'>
                <div className='welcome-container3'>
                    <h1> Welcome to Mercado !</h1>
                </div>
                <div class="card1">
      <p class="card-title1">Return and Refund</p>
      <p class="small-desc1">
      Shop with confidence! We provide a money-back guarantee on eligible products. Learn more about our Refund Policy. We offer hassle-free returns. 
      </p>
      <div class="go-corner1">
        <div class="go-arrow1">→</div>
      </div>
    </div>
                <div class="card1">
      <p class="card-title1">Manage Address</p>
      <p class="small-desc1">
      Managing your account has never been simpler. Explore our account management options for complete control.Keep your information up to date. 
      </p>
      <div class="go-corner1">
        <div class="go-arrow1">→</div>
      </div>
    </div>
                <div class="card1">
      <p class="card-title1">Account Settings</p>
      <p class="small-desc1">
      Easily access and customize your account settings for a personalized experience.Review and update your personal information, including name, email, and contact details.
      </p>
      <div class="go-corner1">
        <div class="go-arrow1">→</div>
      </div>
    </div>
                <div class="card1">
      <p class="card-title1">Your Orders</p>
      <p class="small-desc1">
      Upon successful purchase, you will receive an order confirmation email .Track the status of your order in real-time. Check your order's progress from processing to delivery.
      </p>
      <div class="go-corner1">
        <div class="go-arrow1">→</div>
      </div>
    </div>
               
       
   


  

  

  
                    
            </div>

        </>
    )
}

export default Help