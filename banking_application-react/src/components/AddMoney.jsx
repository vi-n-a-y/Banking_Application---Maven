import React, { useState, useEffect } from 'react';
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import { addMoneyToAcc, getAccById } from '../services/UserService';
import { useParams } from 'react-router-dom';

const AddMoney = () => {
    let navigate = useNavigate();
    const { accountId } = useParams();
    const [accountData, setAccountData] = useState({});
    const [ amountData , setAmountData]=useState({});
    


    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setAmountData({ ...amountData, [name]: value }); // Spread the existing state object
    };

    useEffect(() => {
        // Fetch data using accountId
        fetchData(accountId);
    }, [accountId]);

    const fetchData = async (accountId) => {
        try {
            // Your axios method call using accountId
            const response = await axios.get(`http://localhost:8080/api/bank/acc/${accountId}`);
            setAccountData(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };
    
    const handleHome = () => {
      
        navigate('/home');
    };

    const handleDeposit = async (event) => {
        event.preventDefault();
        

        try {
            
            const response = await addMoneyToAcc(accountData.accountNumber, amountData.amount );
           // const response= await axios.put(`http://localhost:8080/api/bank/addAmt/${accountData.accountNumber}`, { amount: amountData.amount })

           const TID=response.data.trxnId;
           console.log("The Transaction ID is  :  "+TID);
           console.log("the adding amount is : "+amountData.amount);
            console.log("the account numbere  is : "+accountData.accountNumber);
            console.log(response.data); 
            
            
            if (TID>0) {
                       navigate('/home');
            
                    console.log("money added successfull");
                   
                    } else {
                     //   alert('some problem while adding the Money');
                        console.error('some problem while adding the Money');
                    }
               
                } catch (error) {
                    // Handle errors, such as network issues or server errors
                    alert("fail to addMoney to your account")
                    console.error('Error during add money:', error);
                }
        
    };

    return (
        <div className="pers_info">
            <button className="home_btn">Logout</button>
           <button className="home_btn" onClick={handleHome}>Home</button>
            <h1 className="markRed">ADD MONEY</h1>
            <form >
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
                        <td><input type="text" name="currBalance" value={accountData.currBalance} className="info_inp" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Amount :</label></td>
                        <td><input type="number" name="amount" value={amountData.amount} onChange={handleInputChange} className="info_inp" /></td>
                    </tr>
                </table>
                <button type="button"  className="sign" onClick={handleDeposit}>Deposit</button>
            </form>
        </div>
    );
};

export default AddMoney;


