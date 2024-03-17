import React, { useState } from 'react';
import axios from 'axios';
import { getStatement } from "../services/UserService";

const StatementPage = ({ accountNumber }) => {
  const [transactions, setTransactions] = useState([]);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');

const handleSubmit=async(event)=>{
  event.preventDefault();

try{
  const response=await getStatement(accountNumber,startDate,endDate);
  console.log("statement data is :",response.data);
  setTransactions(response.data);

}catch(error){
  console.error("error in statament : ",error);
}
}

  return (
    <div>
      <h1>Statement</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Start Date:</label>
          <input
            type="date"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
        </div>
        <div>
          <label>End Date:</label>
          <input
            type="date"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
      <table>
        <thead>
          <tr>
            <th>Transaction ID</th>
            <th>Date</th>
            <th>Description</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Balance</th>
          </tr>
        </thead>
        <tbody>
          {transactions.map(transaction => (
            <tr key={transaction.trxnId}>
              <td>{transaction.trxnId}</td>
              <td>{transaction.trxnDate}</td>
              <td>{transaction.description}</td>
              <td>{transaction.transactionType}</td>
              <td>{transaction.trxnAmount}</td>
              <td>{transaction.balance}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StatementPage;
