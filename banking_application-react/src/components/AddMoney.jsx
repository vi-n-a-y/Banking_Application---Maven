import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddMoney = () => {
    let navigate = useNavigate();
    const [accountData, setAccountData] = useState({});

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('your-api-endpoint-here');
                setAccountData(response.data);
            } catch (error) {
                console.error('Error fetching account data:', error);
            }
        };

        fetchData();
    }, []);
    const handleHome = () => {
        navigate('/home');
    };

    const handleDeposit = () => {
        // Your deposit logic goes here
        console.log('Deposit button clicked');
    };

    return (
        <div className="pers_info">
            <button className="home_btn">Logout</button>
           <button className="home_btn" onClick={handleHome}>Home</button>
            <h1 className="markRed">ADD MONEY</h1>
            <form>
                <table>
                    <tr>
                        <td><label>Account Number :</label></td>
                        <td><input type="text" name="add_acc_nmbr" value={accountData.accountNumber} className="info_inp" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>IFSC Code :</label></td>
                        <td><input type="text" name="add_ifscc_cd" value={accountData.ifscCode} className="info_inp" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Current Balance :</label></td>
                        <td><input type="text" name="curr_balan" value={accountData.currBalance} className="info_inp" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Amount :</label></td>
                        <td><input type="text" name="add_amt" className="info_inp" /></td>
                    </tr>
                </table>
                <button type="button" onClick={handleDeposit} className="sign">Deposit</button>
            </form>
        </div>
    );
};

export default AddMoney;
