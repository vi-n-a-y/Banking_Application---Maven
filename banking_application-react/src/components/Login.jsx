import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    let navigate = useNavigate();
    const [formData, setFormData] = useState({
        uname: '',
        password: ''
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        navigate('/register');
        // Add your logic to handle form submission here
    };

    return (
        <div className="main_container">
            <div className="credit" id="credit">
                <div>
                    <form onSubmit={handleSubmit}>
                        <table>
                            <tr>
                                <td><label htmlFor="uname">User Name: </label></td>
                                <td><input type="text" name="uname" id="uname" className="info_inp"
                                        placeholder="Enter your Name..." value={formData.uname} onChange={handleInputChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="password">Password : </label></td>
                                <td><input type="password" name="password" id="password" className="info_inp"
                                        placeholder="Enter password Here..." value={formData.password} onChange={handleInputChange} required /></td>
                            </tr>
                        </table>
                        {/* <a href="#" className="forgot">forgot password ?</a> */}
                        <button type="submit" className="sign_sub">Submit</button>
                    </form>
                    <button  onClick={handleSubmit} className="sign_regi">Register</button>
                </div>
            </div>
        </div>
    );
};

export default Login;
