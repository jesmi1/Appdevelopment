import React from 'react'
import Layout from '../components/Layout'
import { useSelector } from 'react-redux'
import { selectUser } from '../redux/UserSlice'
import Table from './Table'
import Card from './card'




function Dashboard() {
    const user=useSelector(selectUser)
    return (
        <>

            <Layout />
            <div className='dbg'>
            <div className='main-wrapper'>
                <div className='welcome-container1'>
                    <h1> Welcome <span className=' username-color'>{user.username} </span> to MERCADO ! </h1>
                </div>
                <Table/>
            
                </div>
                <div><img class="square" src={require('../assets/img/piechart.jpg')} alt="user" /></div>
                <Card/>
                
                <div class="div1">
                    <div class='div2'>HAVE A HAPPY HOME WITH</div>
                    <div class='div3'>BEST APPLIANCES IN TOWN</div>
                </div>
           
                    <div class='div4'>LIVING MADE EASY</div>
                    <div class='div5'>APPLIANCE FOR BETTER PRICE</div>
                   

            </div>
        </>
    )
}

export default Dashboard