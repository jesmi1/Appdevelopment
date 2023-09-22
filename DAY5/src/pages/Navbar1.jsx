import '../assets/css/Navbar1.css'
import { Link } from 'react-router-dom'
function Navbar1() {
    return (
     <>

    <header className='navbar'>
        <div className='navbar_title navbar_item'>MERCADO</div>
        <div className='pinkbtn1 pinkHome'><Link to='/'>Home</Link></div>
        <div className='pinkbtn2 pinkaboutus'><Link to='/AboutUs'>About Us</Link></div>
        <div className='pinkbtn3 pinkcontact'><Link to='/Contact'>Contact</Link></div>
              
    </header>
    </>
)
    }
    export default Navbar1