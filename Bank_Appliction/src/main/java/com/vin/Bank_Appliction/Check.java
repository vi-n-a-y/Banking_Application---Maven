package com.vin.Bank_Appliction;

import jakarta.servlet.http.HttpServlet;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Check {
	
	@Controller
	public class HomeControl{
		
		@RequestMapping(value="/home")
		public String home() {
			System.out.println("method home is created");
			return "login";
		}
		
	}

}
