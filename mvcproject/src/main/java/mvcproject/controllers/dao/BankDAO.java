package mvcproject.controllers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mvcproject.controllers.SessionFactoryProvider;
import mvcproject.controllers.entity.AccountDTO;
import mvcproject.controllers.entity.BankDTO;
import mvcproject.controllers.entity.TransactionDTO;

import java.sql.SQLException;







//
public class BankDAO {
	
	Transaction transaction = null;
	
//for login credientials	
	
	public BankDTO getUserDetails(String uname , String password) {

		BankDTO resUser = new BankDTO();
		
		Session session=SessionFactoryProvider.getSessionFactory();
		transaction=session.beginTransaction();
		Query<BankDTO> query = session.createQuery("FROM BankDTO WHERE user_name = '" + uname + "' AND user_pass ='" + password + "' ", BankDTO.class);
		

		try {
			 query.setParameter("user_name", uname);
		        query.setParameter("user_pass", password);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return query.uniqueResult();
	}	
}


