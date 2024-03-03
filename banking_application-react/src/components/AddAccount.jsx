import React, { useState, useEffect } from 'react';
import { addAccToUser } from '../services/UserService';
import { useNavigate } from 'react-router-dom';

const AddAccount = () => {
    let navigate = useNavigate();
    const [formData, setFormData] = useState([]);

    useEffect(() => {
        setFormData([{ accountNumber: '', bankName: '', ifscCode: '', acctType: '', currBalance: '' }]);
    }, []); // Initialize formData with an empty account when the component mounts

    const handleChange = (event, index) => {
        const { name, value } = event.target;
        const updatedFormData = [...formData];
        updatedFormData[index] = { ...updatedFormData[index], [name]: value };
        setFormData(updatedFormData);
    };
    const handleHome = () => {
        navigate('/home');
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
            <a href=""><button className="home_btn">Logout</button></a>
           <button className="home_btn" onClick={handleHome}>Home</button>
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
                    {!formData.length && <button type="button" onClick={() => setFormData([{ accountNumber: '', bankName: '', ifscCode: '', acctType: '', currBalance: '' }])} className="sign">Add Account</button>}
                    {!!formData.length && <button type="submit" className="sign">Submit</button>}
                </form>
            </div>
        </div>
    );
};

export default AddAccount;
