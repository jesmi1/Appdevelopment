import React from 'react'
import { useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux';
import { logout } from '../redux/UserSlice';

function Leftbar() {

    const dispatch= useDispatch();
    const navigate=useNavigate();

const dashboardHandler = ()=>{
    navigate('/Dashboard')
}
const settingsHandler = ()=>{
    navigate('/Appliance')
}
const usersHandler = () =>{
    navigate('/Client')
}
const helpHandler = () =>{
    navigate('/Help and Services')
}
const logoutHandler = () =>{
    dispatch(logout())
    navigate('/')
}
    return (
        <>
            <div className='left-bar'>
                <div className='left-bar-container'>
                    <button className='left-bar-button nav-btn' onClick={dashboardHandler}>
                        Dashboard
                    </button>
                    <button className='left-bar-button nav-btn' onClick={usersHandler}>
                        Client
                    </button>
                    <button className='left-bar-button nav-btn' onClick={settingsHandler}>
                        Appliance
                    </button>
                    <button className='left-bar-button nav-btn' onClick={helpHandler}>
                        Help and Service
                    </button>
                    <button className='left-bar-button-logout nav-btn' onClick={logoutHandler}>
                        Logout
                    </button>

                </div>
            </div>
        </>
    )
}

export default Leftbar