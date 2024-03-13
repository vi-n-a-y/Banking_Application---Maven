import React, { useState } from "react";
import axios from "axios";


const Statement = () => {
  // Define state variables
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [stm, setStm] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchData = async () => {
    setIsLoading(true);
    try {
      // Perform axios API call here
      const response = await axios.get("/your-api-endpoint", {
        params: {
          startDate,
          endDate,
        },
      });
      setStm(response.data);
      setIsLoading(false);
    } catch (error) {
      setError(error);
      setIsLoading(false);
    }
  };

  const handleDateChange = (e) => {
    // Update state when date inputs change
    const { name, value } = e.target;
    if (name === "startDate") {
      setStartDate(value);
    } else if (name === "endDate") {
      setEndDate(value);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Fetch data when form is submitted
    fetchData();
  };

  return (
    <div className="stmPage" id="st">
      <div className="pers_info">
        <button
          className="home_btn"
          onClick={() => (window.location.href = "home.jsp")}
        >
          Home
        </button>
        <h1 className="acc_head">Statement Form</h1>
        <form onSubmit={handleSubmit}>
          <div className="min_stm">
            <label>Start Date : </label>
            <input
              type="date"
              placeholder="select start date"
              name="startDate"
              value={startDate}
              onChange={handleDateChange}
            />
            <label>End Date :</label>
            <input
              type="date"
              placeholder="select end date"
              name="endDate"
              value={endDate}
              onChange={handleDateChange}
            />
            <button type="submit">Fetch Data</button>
          </div>
        </form>
        {isLoading ? (
          <p>Loading...</p>
        ) : error ? (
          <p>Error: {error.message}</p>
        ) : stm.length > 0 ? (
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
              onClick={() => (window.location.href = "home.jsp")}
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
