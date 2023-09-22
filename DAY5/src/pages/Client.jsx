import React from 'react'
import Layout from '../components/Layout'
import '../assets/css/style.css'
import CRUD from './crud'
import Client1 from "../assets/img/Client1.mp4"

function Client() {
    return (
        <>

                             
            <video autoPlay loop muted>
                <source src={Client1} type="video/mp4" />
            </video>

            <Layout />
            <div className='main-wrapper'>
                <div className='welcome-container2'>
                    <h1> Welcome to Mercado ! </h1>
                </div>
                <CRUD/>
            </div>
        </>
    )
}

export default Client