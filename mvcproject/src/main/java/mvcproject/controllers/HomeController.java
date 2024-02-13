package mvcproject.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvcproject.controllers.dao.BankDAO;
import mvcproject.controllers.entity.BankDTO;


@Controller
public class HomeController extends HttpServlet {
	
	
//	@RequestMapping("/")
//	public String getPage() {
////		ModelAndView m=new ModelAndView("bank");
//		/* m.setViewName("bank"); */
//		return "bank";
//	}
	private static final long serialVersionUID = 1L;

    public HomeController() {
        super();
     
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/home":
				credintials(request, response);
				break;
			case "/Regi":
				registration(request, response);
				break;
			case "/add":
				addMoney(request, response);
				break;
			case "/trxns":
				trxns(request, response);
				break;
			case "/AccDet":
				accountDetails(request, response);
				break;
			default:
				bank(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
		
	



	
	public void credintials(HttpServletRequest request, HttpServletResponse response)throws SQLException,ServletException, IOException {
		String user_name = request.getParameter("u_name");
		String user_pass = request.getParameter("u_pass");
		BankDAO dao = new BankDAO();
		BankDTO user = dao.getUserDetails(user_name, user_pass);
		HttpSession session = request.getSession();

		if (user != null) {
			if (user.getPassword().equals(user_pass)) {
				session.setAttribute("user", user);
				int id = user.getUserId();
				System.out.println("sysout in Home_page java " + id);
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			} else {
				throw new RuntimeException("No Account found,Enter correct Crenditials to Login!");
			}
		}

	}
private String bank(HttpServletRequest request, HttpServletResponse response)throws SQLException,ServletException, IOException {
	
	return "bank";
	
	
}
private void registration(HttpServletRequest request, HttpServletResponse response) {

	
}
private void addMoney(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
}
private void trxns(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
}
private void accountDetails(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
}
}
	



