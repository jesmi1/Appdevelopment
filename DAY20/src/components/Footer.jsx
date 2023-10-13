import React from 'react'
import { Link } from 'react-router-dom'
import {AiFillFacebook, AiFillGithub, AiFillInstagram} from 'react-icons/ai'
import '../assets/css/style.css';
const Footer = () => {
  return (
    <div className='footer'>
        <div className='footer-container'>
            <div className='footer-l'>
                Copyright 2023 @ Mercado Inc
            </div>
            <div>
              <a href="https://www.instagram.com/accounts/login/">
              <AiFillInstagram size="2rem"/>
              </a>
            </div>
            <div>
            <a href="https://www.facebook.com/login/">
              <AiFillFacebook size="2rem"/>
              </a>
            </div>
            <div>
            <a href="https://github.com/login">
              <AiFillGithub size="2rem"/>
              </a>
            </div>
            <div className='footer-r'>
                <Link to='/privacy' className='me-2'>Privacy Policy</Link>
                <Link to='/terms' className='me-2'>Terms & Conditions</Link>
                <Link to='/FAQ' className='me-2'>FAQ</Link>
                <Link to='/AboutPage' className='me-2'>AboutUs</Link>
            </div>
        </div>

    </div>
  )
}
export default Footer
/*bg-white py-3 shadow-sm
   bg-black
*/