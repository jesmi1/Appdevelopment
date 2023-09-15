import {BrowserRouter, Routes, Route} from 'react-router-dom'
import './assets/css/app.css';
import Login from './pages/Login';
import Register from './pages/Register';
function App() {
  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route exact path='/' element={<Login/>}/>
      <Route exact path='/register' element={<Register/>}/>
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;