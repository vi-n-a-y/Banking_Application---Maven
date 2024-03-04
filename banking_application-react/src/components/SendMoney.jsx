import React from 'react';
import { useNavigate } from 'react-router-dom';
import { sendMoneyToAcc } from '../services/UserService';

const SendMoney = () => {
    let navigate = useNavigate();

    const [ amountData , setAmountData]=useState({});

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setAmountData({ ...amountData, [name]: value }); // Spread the existing state object
    };
   
        const handleDeposit = async (event) => {
            event.preventDefault();
            
    
            try {
                
                const response = await sendMoneyToAcc(accountData.accountNumber, amountData.amount );
               console.log("the adding amount is : "+amountData.amount);
                console.log("the account numbere  is : "+accountData.accountNumber);
                console.log(response.data); 
                const Amount=response.data.currBalance;
                // Log the response data
                // const  Amount=response.data.amount;
                 console.log("the user id is "+Amount);
                if (Amount>0) {
                       
                          console.log("money added successfull");
                           navigate('/home');
                
                           
                       
                        } else {
                            
                            console.error('some problem while inserting the user details');
                        }
                    } catch (error) {
                        // Handle errors, such as network issues or server errors
                        console.log("enter wrong credintials")
                        console.error('Error during add money:', error);
                    }
   
   
   
    };


    return (
        <div className="pers_info">
            <a href="logout.jsp"><button className="home_btn">Logout</button></a>
            <a href="#"><button className="home_btn">Home</button></a>
            <h1 className="acc_head">Send Money</h1>
            <form action="trxns">
                <table>
                    <tr>
                        <td><label>Receiver Account Number :</label></td>
                        <td><input type="text" name="rec_acc" className="info_inp" required /></td>
                    </tr>
                    <tr>
                        <td><label>Receiver IFSC Code :</label></td>
                        <td><input type="text" name="rec_ifsc" className="info_inp" /></td>
                    </tr>
                    <tr>
                        <td><label>Description :</label></td>
                        <td><input type="text" name="description" className="info_inp" required /></td>
                    </tr>
                    <tr>
                        <td><label>Total Amount to transfer :</label></td>
                        <td><input type="text" name="total_amount" className="info_inp" required /></td>
                    </tr>
                </table>
                <button className="sign">Send</button>
            </form>
        </div>
    );
};

export default SendMoney;
