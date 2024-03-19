import React, { useState } from 'react';
import '../index.css';

const Navbar = () => {


  return (
  <nv>
    <div className="bg_black">
        <b><a className="logo1" href="#">Self B@/\/k</a></b>
        <a className="nav" href="#">Menu</a>
        <a className="nav" href="" >Jobs</a>
        <a className="nav" href="" >Contact Us</a>     
        <input type="text" placeholder="search" />
        <button className="search">Search</button>
        <a href=""><button className="sign">Logout</button></a>
    </div>
  </nv>
  );
};

export default Navbar;
