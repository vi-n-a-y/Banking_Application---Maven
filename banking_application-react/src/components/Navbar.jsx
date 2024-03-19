import React, { useState } from "react";
import "../index.css";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const handleLogout = () => {};

  return (
    <nav>
      <div className="bg_black">
        <b>
          <a className="logo1" href="#">
            Self B@/\/k
          </a>
        </b>
        <a className="nav" href="#">
          Menu
        </a>
        <a className="nav" href="">
          Jobs
        </a>
        <a className="nav" href="">
          Contact Us
        </a>
        <input type="text" placeholder="search" />
        <button className="search">Search</button>
        <button className="sign" onClick={handleLogout}>
          Logout
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
