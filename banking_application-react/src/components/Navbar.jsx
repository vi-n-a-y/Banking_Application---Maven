
import React, { useState } from 'react';
import '../App.css';

const Nav = () => {
  const [initialPosition, setInitialPosition] = useState("75%");

  const highlightLink = (index, end) => {
    const percentages = ["75%", "50%", "25%", "0"];
    let targetPosition = index !== -1 ? percentages[index] : end;

    setInitialPosition(targetPosition);
    setTimeout(() => {
      document.getElementById("menuList").classList.add("clicked");
    }, 0);
  };

  const handleLinkClick = (index) => {
    highlightLink(index);
  };

  const handleKeyPress = (event) => {
    let start = +initialPosition.slice(0, 2) || 0;
    let end;

    if (event.key === "ArrowRight") {
      end = start !== 0 ? start - 25 : 0;
    }
    if (event.key === "ArrowLeft") {
      end = start !== 75 ? start + 25 : 75;
    }

    highlightLink(-1, end + "%");
  };

  return (
    <nav>
      <ul id="menuList" onKeyDown={handleKeyPress}>
        <li><a href="#" className="nav-link" onClick={() => handleLinkClick(0)}>Home</a></li>
        <li><a href="#" className="nav-link" onClick={() => handleLinkClick(1)}>Products</a></li>
        <li><a href="#" className="nav-link" onClick={() => handleLinkClick(2)}>Contact Us</a></li>
        <li><a href="#" className="nav-link" onClick={() => handleLinkClick(3)}>About Us</a></li>
      </ul>
    </nav>
  );
};

export default Nav;

