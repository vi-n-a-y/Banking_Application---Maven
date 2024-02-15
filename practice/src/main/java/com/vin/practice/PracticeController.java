package com.vin.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
	
	

	@GetMapping("/bala")
	public String getString(@RequestParam(name="str")String str) {
	
		if(str.equals("hii")) {
		return "hello";
		}else {
			return "welcome";
		}
	
	}
	
}
