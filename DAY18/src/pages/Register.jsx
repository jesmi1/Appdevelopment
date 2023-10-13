import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import '../Loginstyle/login.css';
import axios from 'axios';
function Register() { 
  const navigate = useNavigate()
  const [formdata, setFormdata] = useState({
    name: '',
    email: '',
    password: '',
    role:'user',
  })
  const handleChange = (e) => {
    setFormdata({ ...formdata, [e.target.id]: e.target.value })
  }

  const handleSubmit = (e)=>{
    e.preventDefault();
    axios.post("http://localhost:8181/api/v1/auth/register",{
     formdata
    }).then((res)=>{
      console.log(res.data);
    }).catch((err)=>{
      console.log(err.data);
    })
    navigate('/')
  }


  return (
    
      <div className='auth-container'>
        <div className='auth-wrapper'>
          <form className='auth-form app-x-shadow' onSubmit={handleSubmit}>
            <h1 className='auth-heading'>Register</h1>
              <input type="text" name="name" id="name" value={formdata.name} placeholder='username' onChange={handleChange} className='auth-field' required />
              <input type="email" name="email" id="email" value={formdata.email} placeholder='email' onChange={handleChange} className='auth-field' required />
              <input type="password" name="password" id="password" value={formdata.password} placeholder='password' onChange={handleChange} className='auth-field' required />
              <button type='submit' className='auth-btn app-x-shadow'> Register </button>
          </form>

         
        </div>
      </div>

    
  )
}

export default Register;