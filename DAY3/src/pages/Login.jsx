import ResponsiveAppBar from "../components/navbar";
import '../assets/css/login.css';
import {useState} from 'react'
import toast, {Toaster} from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';
const Login = () => {
    const nav = useNavigate()
    const [login,setLogin]=useState({
        email:'',
        password:''
    })
    const handleChange=(e)=>{
        e.preventDefault();
        setLogin({...login,[e.target.id]:e.target.value})
    }
    const handleSubmit=(e)=>{
        e.preventDefault();
        console.log('Email : ${login.email} Password: ${login.password}')
        toast.success('Successfully toasted!')
    }
    const handleRoute=()=>{
       nav('/register')
    }
    
    
    return (
        <>
        <ResponsiveAppBar/>
    <div className="logbg">
        
        <div class="container">
    <div class="card">
      <div class="front"></div>
      <div class="back">
        <h1>WELCOME TO</h1>
        <h1 className="head1">MERCADO</h1>
        <p className="para1">CHOOSE YOUR HOME</p>
        <p className="para2">APPLIANCES</p>
      </div>
    </div>
  </div>

      
    <form onSubmit={handleSubmit}>
    <div className="auth-form d-flex-c">
        <input type="email" name="email" id="email" className='input-field' placeholder='Email' onChange={handleChange} autoFocus required/>
        <input type="password" name="password" id="password" className='input-field' placeholder='Password' onChange={handleChange}  required/>
        <button type="submit" className='auth-btn'>Login</button>
    </div>
    <h5 className="regbut">Route to <span className='text-link' onClick={handleRoute}>Register ?</span></h5>
    </form>
    </div>
    <Toaster
         position="top-center"
         reverseOrder={false}
    />  
       
      
   
    </>


  )
}

export default Login