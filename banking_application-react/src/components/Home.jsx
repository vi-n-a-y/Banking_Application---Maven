import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { verifyUser } from '../services/UserService';
import { useParams } from 'react-router-dom';

const Home = () => {
    const navigate = useNavigate();
    const [userData, setUserData] = useState(null);
    const [selectedAccountId, setSelectedAccountId] = useState(null);
    const [isRadioSelected, setIsRadioSelected] = useState(false); // New state
    const { uname } = useParams();

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const response = await verifyUser(uname);
            setUserData(response.data);
        } catch (error) {
            console.error('Error while fetching user data:', error);
        }
    };

    const handleAddMoney = () => {
        if (isRadioSelected) {
            navigate(`/addMoney/${selectedAccountId}`);
        }
        else{
            alert("please select atleast one account")
        }
    };

    const handleSendMoney = () => {
        if (isRadioSelected) {
            navigate(`/sendMoney/${selectedAccountId}`);
        } else{
            alert("please select atleast one account")
        }
    };

    const handleAddAccount = () => {
        navigate(`/addAcc`);
    };

    const handleRadioChange = (accountId) => {
        setSelectedAccountId(accountId);
        setIsRadioSelected(true);
    };


    return (
        <div className="home_main">
        <div className="bg_black">
        <b><a className="logo1" href="#">Pir@es.Bank</a></b>
        <a className="nav" href="#">MENU</a>
        {userData && userData[0].accounts.length > 0 && (
                    <>
                        <a className="nav" href="" onClick={handleAddMoney}>ADD MONEY</a>
                        <a className="nav" href="" onClick={handleSendMoney}>SEND MONEY</a>
                    </>
                )}
        <input type="text" placeholder="search" />
        <button className="search">search</button>
        <a href=""><button className="sign">logout</button></a>
    </div>
            {userData && (
                <>
                <div className="pers_info">
                <h1 className="acc_head">User Details</h1>
                <table>
                    <tr>
                        <td><label>User Name : </label></td>
                        <td><input type="text" name="uname" value={userData[0].uname} className="info_text" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Full Name : </label></td>
                        <td><input type="text" name="fullName" value={userData[0].fullName} className="info_text" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Phone Number : </label></td>
                        <td><input type="text" name="phno" value={userData[0].phno} className="info_text" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Email : </label></td>
                        <td><input type="text" name="email" value={userData[0].email} className="info_text" readOnly /></td>
                    </tr>
                    <tr>
                        <td><label>Address : </label></td>
                        <td><input type="text" name="address" value={userData[0].address} className="info_text" readOnly /></td>
                    </tr>
                </table>
            </div>
            <button className="home_btn" onClick={handleAddAccount}>Add Account</button>
            <h1 className="acc_head">Account Details</h1>
           
                    <div className="acc_info">
                        {userData[0].accounts.length > 0 ? (
                            userData[0].accounts.map((account, index) => (
                                <div key={index} className="account-details">
                                    <table>
                                        <tr>
                                            <td><label>Account {index + 1} : </label></td>
                                            <td>
                                                <input 
                                                    type="radio"  name="id"   value={account.id}  className="info_text"  checked={selectedAccountId === account.id}   onChange={() => handleRadioChange(account.id)}  />
                                            </td>
                                        </tr>
                                        <tr>
                    <td><label>Account Number : </label></td>
                    <td><input type="text" name="accountNumber" value={account.accountNumber} className="info_text" readOnly /></td>
                    </tr>    
                    <tr> <td><label>Bank Name : </label></td>
                    <td><input type="text" name="bankName" value={account.bankName} className="info_text" readOnly /></td>
                </tr>
                <tr>
                    <td><label>IFSC Code : </label></td>
                    <td><input type="text" name="ifscCode" value={account.ifscCode} className="info_text" readOnly /></td> </tr>
                    <tr>   <td><label>Account Type : </label></td>
                    <td><input type="text" name="acctType" value={account.acctType} className="info_text" readOnly /></td>
                </tr>
                <tr>
                    <td><label>Current Balance : </label></td>
                    <td><input type="text" name="currBalance" value={account.currBalance} className="info_text" readOnly /></td>
                </tr>
                                    </table>
                                </div>
                                
                            ))
                        ) : (
                            <div>
                                <h2>Please Add your account details</h2>
                                <button onClick={handleAddAccount}>Add Account</button>
                            </div>
                        )}
                    </div>
                    
                    {userData[0].accounts.length > 0  &&(
                        <>
                        <button className="sign" id="btn" onClick={handleAddMoney}>Add Money</button>
                        <button className="sign" id="btn" onClick={handleSendMoney}>Send Money</button>
                        </>
                    )}
                </>
            )}
        </div>
        
    );


    
};

export default Home;