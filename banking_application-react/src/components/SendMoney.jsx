
import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import { sendMoneyToAcc } from "../services/UserService";

const SendMoney = () => {
  let navigate = useNavigate();
  const { accountNumber } = useParams();
  const [formData, setFormData] = useState({
    toAccount: '',
    description: '',
    amount: '',
   
});

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value }); 
  };
  const handleHome = () => {
    navigate("/home");
  };

  const handleSend = async (event) => {
    event.preventDefault();
  
    try {
      const response = await sendMoneyToAcc(accountNumber,formData.toAccount,formData.amount,formData.description);
      console.log('Transaction successful:', response.data);
      navigate("/home");
    } catch (error) {
      console.error('Error sending money:', error);
    }
  };


  return (
    <div className="pers_info">
      <a href="logout.jsp">
        <button className="home_btn">Logout</button>
      </a>
      <button className="home_btn" onClick={handleHome}>
        Home
      </button>
      <h1 className="acc_head">Send Money</h1>
      <form onSubmit={handleSend} >
    
        <table>
        <tr>
            <td><label>Your Account Number :</label> </td>
            <td>
              <input type="text" name="FromAccount" value={accountNumber}  className="info_inp" readOnly />
            </td>
          </tr>

          <tr>
            <td><label>Receiver Account Number :</label> </td>
            <td>
              <input type="text" name="toAccount" value={formData.toAccount} onChange={handleInputChange} className="info_inp" required />
            </td>
          </tr>
         
        
          <tr>
            <td>
              <label>Description :</label>
            </td>
            <td>
              <input type="text" name="description"  className="info_inp" value={formData.description} onChange={handleInputChange} required />
            </td>
          </tr>

          <tr>
            <td>
              <label>Amount Send :</label>
            </td>
            <td>
              <input type="number" name="amount"  className="info_inp" value={formData.amount} onChange={handleInputChange} required />
            </td>
          </tr>

        </table>
       
        <button className="sign" >Send</button>
      </form>
    </div>
  );
};

export default SendMoney;




