import React, { useState } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import { getStatement } from "../services/UserService";

const Statement = () => {
  const [transactions, setTransactions] = useState([]);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState('');
  const { accountNumber } = useParams();
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    setIsLoading(true);

    try {
      const response = await getStatement(accountNumber,startDate,endDate);

      setTransactions(response.data);
      setError(response.data.length === 0 ? 'No transactions found for the selected dates.' : '');
    } catch (error) {
      console.error("error in statement : ", error);
      setError('An error occurred while fetching data. Please try again.');
    } finally {
      setIsLoading(false);
    }
  }

  const handleHome = () => {
    navigate("/home");
  };

  return (
    <div className="stmPage" id="st">
      <div className="pers_info">
        <button className="home_btn" onClick={handleHome}>Home</button>
        <h1 className="acc_head">Statement Form</h1>
        <form onSubmit={handleSubmit}>
          <div className="min_stm">
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
          </div>
        </form>
        {isLoading ? (
          <p>Loading...</p>
        ) : (
          <>
            {error && <p>{error}</p>}
            {transactions.length > 0 && (
              <table border={1}>
                <caption><font>Mini-Statement Form</font></caption>
                <thead>
                  <tr>
                    <th>Transaction ID</th>
                    <th>Account</th>
                    <th>Receiver/sender Account</th>
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
                      <td>{accountNumber}</td>
                      <td>{transaction.toAccount.accountNumber}</td>
                      <td>{transaction.trxnDate}</td>
                      <td>{transaction.description}</td>
                      <td>{transaction.transactionType}</td>
                      <td>{transaction.trxnAmount}</td>
                      <td>{transaction.balance}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
          </>
        )}
      </div>
    </div>
  );
};

export default Statement;
