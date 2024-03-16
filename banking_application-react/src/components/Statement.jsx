import React, { useState } from "react";
import axios from "axios";
import { getStatement } from "../services/UserService";
import { useNavigate, useParams } from "react-router-dom";


const Statement = () => {
  // Define state variables

let navigate=useNavigate();
const {accountNumber}=useParams();
const {formData,setFormData}=useState({
  startDate:'',
  endDate:''
});

const handleInputChange=(event)=>{
  const{name,value}=event.target;
  setFormData({...formData,[name]:value});
};
const handleHome=()=>{
  navigate("/home");
};

const handleStatement=async(event)=>{
  event.preventDefault();

try{
  const response=await getStatement(accountNumber,formData.startDate,formData.endDate);
  console.log("statement data is :",response.data);




}catch(error){
  console.error("error in statament : ",error);
}



};


  


  return (
    <div className="stmPage" id="st">
      <div className="pers_info">
        <button
          className="home_btn"
          onClick={handleHome}
        >
          Home
        </button>
        <h1 className="acc_head">Statement Form</h1>
        <form onSubmit={handleStatement}>
          <div className="min_stm">
            <label>Start Date : </label>
            <input
              type="date"
              placeholder="select start date"
              name="startDate" 
              value={formData.startDate}
              onChange={handleInputChange}
            />
            <label>End Date :</label>
            <input
              type="date"
              placeholder="select end date"
              name="endDate" 
              value={formData.endDate}
              onChange={handleInputChange}
            />
            <button type="submit">Fetch Data</button>
          </div>
        </form>
        {/* {isLoading ? (
          <p>Loading...</p>
        ) : error ? (
          <p>Error: {error.message}</p>
        ) : stm.length > 0 ? ( */}
          <table
            border="1
"
          >
            <caption>
              <font>Mini-Statement Form</font>
            </caption>
            <thead>
              <tr>
                <th>Trxn_id</th>
                <th>Date</th>
                <th>From Account No:</th>
                <th>To Account No</th>
                <th>Description</th>
                <th>Amount Send</th>
                <th>Current Balance</th>
              </tr>
            </thead>
            <tbody>
              {stm.map((mini) => (
                <tr key={mini.trnId}>
                  <td>{mini.trnId}</td>
                  <td>{mini.trnDate}</td>
                  <td>{mini.fromAcc}</td>
                  <td>{mini.toAcc}</td>
                  <td>{mini.description}</td>
                  <td>{mini.amountSend}</td>
                  <td>{mini.balance}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <div>
            <h1 className="acc_head">
              No transactions found from your Account
            </h1>
            <button
              className="sign"
              onClick={() => (window.location.href = "/Home")}
            >
              Home
            </button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Statement;
