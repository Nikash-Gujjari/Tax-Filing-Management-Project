import React from 'react';
import '../css/HomePage.css';
export const HomePage = () => {
  return (
    <div>
      <div className="home_header">
        <h1 className="home_h1">Tax Management System</h1>
        <button className="home_profile">Edit Profile</button>
        <button>Logout</button>
      </div>
        <navbar></navbar>
        <div class="content">
      </div>

    </div>
  );
}