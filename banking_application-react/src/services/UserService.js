import axios from "axios";
 const rest='http://localhost:8080/api/bank';

 export const verifyUser=(uname)=>axios.post(rest + '/' +uname);
 export const registerUser=(User)=>axios.post(rest,User);
 export const addAccToUser=(userId,User)=>axios.post('http://localhost:8080/api/bank/set'+'/'+userId,User);
 export const addMoneyToAcc=(id,account)=>axios.put('http://localhost:8080/api/bank/addAmt'+'/'+id,{ amount: account });
 export const getAccById=(id)=>axios.get('http://localhost:8080/api/bank/acc/'+id);
 export const sendMoneyToAcc=(id,account)=>axios.put('http://localhost:8080/api/bank/sendMoney'+'/'+id,{ amount: account });