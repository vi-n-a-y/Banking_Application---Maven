import React, { useState } from 'react';
import { addAccToUser } from '../services/UserService';
import { useNavigate } from 'react-router-dom';

const AddAccount = () => {
    let navigate = useNavigate();
    const [formData, setFormData] = useState([]);

    const handleChange = (event, index) => {
        const { name, value } = event.target;
        const updatedFormData = [...formData];
        updatedFormData[index] = { ...updatedFormData[index], [name]: value };
        setFormData(updatedFormData);
    };

    const handleAddAccount = () => {
        setFormData([...formData, { accountNumber: '', bankName: '', ifscCode: '', acctType: '', currBalance: '' }]);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await addAccToUser(localStorage.getItem('userId'), formData);
            console.log(response.data);
            if (response.data.accounts.length > 0) {
                console.log("the response id is : " + response.data.accounts[0].id);
                navigate('/home');
            }
        } catch (error) {
            console.log("something went wrong")
            console.error('Error during Adding account:', error);
        }
    };

    return (
        <div className="add_main">
            <a href="logout.html"><button className="home_btn">Logout</button></a>
            <a href="home.html"><button className="home_btn">Home</button></a>
            <div className="acc_main">
                <h1 className="markRed">Add Account</h1>
                <form id="accountDetails" onSubmit={handleSubmit}>
                    {formData.map((account, index) => (
                        <table key={index}>
                            <tr>
                                <td><label>Account Number:</label></td>
                                <td><input type="text" name="accountNumber" value={account.accountNumber} onChange={(event) => handleChange(event, index)} className="info_text" required /></td>
                            </tr>
                            <tr>
                                <td><label>Bank Name:</label></td>
                                <td><input type="text" name="bankName" value={account.bankName} onChange={(event) => handleChange(event, index)} className="info_text" required /></td>
                            </tr>
                            <tr>
                                <td><label>IFSC Code:</label></td>
                                <td><input type="text" name="ifscCode" value={account.ifscCode} onChange={(event) => handleChange(event, index)} className="info_text" required /></td>
                            </tr>
                            <tr>
                                <td><label>Account Type:</label></td>
                                <td><input type="text" name="acctType" value={account.acctType} onChange={(event) => handleChange(event, index)} className="info_text" required /></td>
                            </tr>
                            <tr>
                                <td><label>Current Balance:</label></td>
                                <td><input type="text" name="currBalance" value={account.currBalance} onChange={(event) => handleChange(event, index)} className="info_text" required /></td>
                            </tr>
                        </table>
                    ))}
                    <button type="button" onClick={handleAddAccount} className="sign">Add Account</button>
                    <button type="submit" className="sign">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default AddAccount;
