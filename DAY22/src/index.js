import React from 'react';
import ReactDOM from 'react-dom/client';
import '../node_modules/font-awesome/css/font-awesome.min.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './redux/store';


import { Home, Product, Products, AboutPage, ContactPage, Cart, Login, Register, Checkout, PageNotFound, Dashboard, ProductCard } from "./pages"
import Privacy from './pages/Privacy';
import FAQ from './pages/FAQ.jsx';
import Dashpage from './pages/Dashpage';
import Layout from './pages/Layout';




const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Provider store={store}>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/product" element={<Products />} />
        <Route path="/product/:id" element={<Product />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="*" element={<PageNotFound />} />
        <Route path="/product/*" element={<PageNotFound />} />
        <Route path="/privacy" element={<Privacy/>} />
        <Route path="/FAQ" element={<FAQ/>} />
        <Route path="/AboutPage" element={<AboutPage/>} />
        <Route path="/dashboard" element={<Dashboard/>} />
        <Route path="/dashpage" element={<Dashpage/>} />
        <Route path="/layout" element={<Layout/>} />
        <Route path="/pc" element={<ProductCard/>} />
        
      </Routes>
    </Provider>
  </BrowserRouter>
);