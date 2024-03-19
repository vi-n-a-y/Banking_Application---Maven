import axios from "axios";
 const rest='http://localhost:8080/api/bank';

 export const verifyUser=(uname)=>axios.post(rest + '/' +uname);
 export const registerUser=(User)=>axios.post(rest,User);
 export const addAccToUser=(userId,User)=>axios.post('http://localhost:8080/api/bank/set/'+userId,User);
 export const getAccById=(id)=>axios.get('http://localhost:8080/api/bank/acc/'+id);
 export const sendMoneyToAcc=(fromAccount,toAccount,amount,description)=>axios.post('http://localhost:8080/api/bank/transfer',null,{
    params:{
        fromAccountNumber: fromAccount, // Assuming accountNumber is the sender's account number
          toAccountNumber: toAccount,
          amount: amount,
          description: description
    }
 });
 export const addMoneyToAcc=(accountNumber,amount)=>axios.post('http://localhost:8080/api/bank/addMoney',null,{
    params:{
        fromAccountNumber: accountNumber , // Assuming accountNumber is the sender's account number
          amount: amount
         
    }
 });
 export const getStatement=(accountNumber,startDate,endDate)=>axios.get('http://localhost:8080/api/bank/statement',{
    params:{
        accountNumber: accountNumber ,  
         startDate:startDate,
         endDate:endDate
         
    }
 });