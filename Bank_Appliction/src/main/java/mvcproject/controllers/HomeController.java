package mvcproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("display")
	public ModelAndView getPage() {
		ModelAndView m=new ModelAndView("bank");
		/* m.setViewName("bank"); */
		return m;
	}

}
