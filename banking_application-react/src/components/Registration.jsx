import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Registration = () => {
    let navigate = useNavigate();
    const [formData, setFormData] = useState({
        uname: '',
        password: '',
        fullName: '',
        email: '',
        phno: '',
        address: ''
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        navigate('/login');
        // Add logic to submit form data to the server
        console.log(formData); // For testing, log form data to the console
    };

    return (
        <div className="main_container">
            <div className="info" id="info">
                <div>
                <form onSubmit={handleSubmit}>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>User Name:</label></td>
                                <td><input type="text" name="uname" value={formData.uname} onChange={handleInputChange} className="info_inp" placeholder="Enter your Name.." required /></td>
                            </tr>
                            <tr>
                                <td><label>Password:</label></td>
                                <td><input type="password" name="password" value={formData.password} onChange={handleInputChange} className="info_inp" placeholder="Enter password Here..." required /></td>
                            </tr>
                            <tr>
                                <td><label>Full Name:</label></td>
                                <td><input type="text" name="fullName" value={formData.fullName} onChange={handleInputChange} className="info_inp" placeholder="Enter full Name Here..." /></td>
                            </tr>
                            <tr>
                                <td><label>Email:</label></td>
                                <td><input type="text" name="email" value={formData.email} onChange={handleInputChange} className="info_inp" placeholder="Enter your email Here..." /></td>
                            </tr>
                            <tr>
                                <td><label>Phone No.:</label></td>
                                <td><input type="text" name="phno" value={formData.phno} onChange={handleInputChange} className="info_inp" placeholder="Enter Phone Number Here..." /></td>
                            </tr>
                            <tr>
                                <td><label>Address:</label></td>
                                <td><input type="text" name="address" value={formData.address} onChange={handleInputChange} className="info_inp" placeholder="Enter your Address Here..." /></td>
                            </tr>
                        </tbody>
                    </table>
                    <button type="submit" className="regi_btn">Submit</button>
                </form>
                <button className="regi_btn" onClick={handleSubmit}>Sign in</button>
                </div>
            </div>
        </div>
    );
};

export default Registration;
