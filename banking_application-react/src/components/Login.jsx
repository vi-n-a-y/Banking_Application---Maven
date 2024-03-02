import React, { useState } from 'react';
// import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { verifyUser } from '../services/UserService';


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

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            
            const response = await verifyUser(formData.uname);
            console.log(response.data); // Log the response data
            
            if (response.data.length > 0) {
                        // Extract password from the first element of the array
                        const passwordFromServer = response.data[0].password;
                        console.log("the password from server is "+passwordFromServer);
                        const enteredPassword = formData.password;
                        
                        // Check if the password is valid
                        if (passwordFromServer === enteredPassword) {
                            // Navigate to the home page `/home/${JSON.stringify(formData)}`
                            localStorage.setItem('uname', response.data[0].uname);
                            localStorage.setItem('userId', response.data[0].userId);
                            console.log("the user name is from localStrorage",localStorage.getItem('uname'));
                           // console.log(userId);
                            navigate('/home');
                        } else {
                            // Handle invalid password
                            console.error('Invalid password');
                        }
                    } else {
                        // Handle case where no user data is returned
                        console.error('No user data found');
                    }
                } catch (error) {
                    // Handle errors, such as network issues or server errors
                    console.log("enter wrong credintials")
                    console.error('Error during login:', error);
                }
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
                    <button onClick={() => navigate('/register')} className="sign_regi">Register</button>
                </div>
            </div>
        </div>
    );
};

export default Login;
      // Add your logic to handle form submission here
        //the react does not have the ablity to make HTTP requests, thus we need to use third-party libraries to achieve this.
        //the fetch API  is a web standard built for most of the modern browsers