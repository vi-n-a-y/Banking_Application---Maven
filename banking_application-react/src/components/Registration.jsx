import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../services/UserService';

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

    const handleSubmit = async(event) => {
        event.preventDefault();
        try {
            
            const response = await registerUser(formData);
            console.log(response.data); // Log the response data
            const userIdFromServer=response.data.userId;
            console.log("the user id is "+userIdFromServer);
            if (userIdFromServer>0) {
                      alert("SUCCESSFULly REGISTERED");
                       navigate('/');
            
                       
                   
                    } else {
                        
                        alert('some problem while inserting the user details');
                    }
                } catch (error) {
                    // Handle errors, such as network issues or server errors
                    alert("enter wrong credintials")
                    console.error('Error during login:', error);
                }
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
                    <button type="submit" className="regi_btn" onClick={handleSubmit}>Submit</button>
                </form>
                <button onClick={() => navigate('/')} className="regi_btn">SignIn</button>
                </div>
            </div>
        </div>
    );
};

export default Registration;
