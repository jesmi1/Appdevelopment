import React from 'react'
import Layout from '../components/Layout'

import CRUD1 from './crud1'
import ApplianceBg from "../assets/img/ApplianceBg.mp4"

function Appliance() {
    return (
        <>
            <video autoPlay loop muted>
                <source src={ApplianceBg} type="video/mp4" />
            </video>

            <Layout />
            <div className='main-wrapper'>
                <div className='welcome-container3'>
                    <h1> Welcome to Mercado !</h1>
                </div>
                    <CRUD1/>
            </div>

        </>
    )
}

export default Appliance