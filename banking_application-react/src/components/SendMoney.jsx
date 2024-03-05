
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import { sendMoneyToAcc } from "../services/UserService";

const SendMoney = () => {
  let navigate = useNavigate();
  const { accountId } = useParams();

  const [amountData, setAmountData] = useState({});
  const [formData, setFormData]=useState([]);

  useEffect(() => {
    setFormData([{ toAccount: '', transactionType: '', description: '', trxnAmount: '', balance: '' }]);
}, []);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setAmountData({ ...amountData, [name]: value }); // Spread the existing state object
  };
  const handleHome = () => {
    navigate("/home");
  };

  const handleSend = async (event) => {
    event.preventDefault();

    try {
      const response = await sendMoneyToAcc(accountId, amountData.amount);
      console.log("the adding amount is : " + amountData.amount);
    //   console.log("the account numbere  is : " + accountData.accountNumber);
      console.log(response.data);
      const Amount = response.data.currBalance;
      // Log the response data
      // const  Amount=response.data.amount;
      console.log("the user id is " + Amount);
      if (Amount > 0) {
        console.log("money added successfull");
        navigate("/home");
      } else {
        console.error("some problem while inserting the user details");
      }
    } catch (error) {
      // Handle errors, such as network issues or server errors
      console.log("enter wrong credintials");
      console.error("Error during add money:", error);
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
      <form action="trxns" onSubmit={handleSend}>
      {formData.map((formData, index) => (
        <table>
          <tr>
            <td><label>Receiver Account Number :</label> </td>
            <td>
              <input type="text" name="toAccount" value={formData.toAccount} onChange={(event) => handleInputChange(event, index)} className="info_inp" required />
            </td>
          </tr>
          <tr>
            <td>
              <label>Transaction Type:</label>
            </td>
            <td>
              <input type="text" name="transactionType" value={formData.transactionType} onChange={(event) => handleInputChange(event, index)} className="info_inp" />
            </td>
          </tr>
          <tr>
            <td>
              <label>Description :</label>
            </td>
            <td>
              <input type="text" name="description"  className="info_inp" value={formData.description} onChange={(event) => handleInputChange(event, index)} required />
            </td>
          </tr>
          <tr>
            <td>
              <label>Total Amount to transfer :</label>
            </td>
            <td>
              <input  type="text" name="trxnAmount" className="info_inp" value={formData.trxnAmount} onChange={(event) => handleInputChange(event, index)} required/>
            </td>
          </tr>
        </table>
         ))}
        <button className="sign">Send</button>
      </form>
    </div>
  );
};

export default SendMoney;
