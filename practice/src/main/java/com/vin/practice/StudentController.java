package com.vin.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@GetMapping("/st")
	public Student getStudent() {
		return new Student("venu",30);	
	}
	
	
	@GetMapping("/jdb")
	public String getStudentList(@RequestParam(name="str")String name) {

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from demo where name='" + name + "'");
			if(rs>0) {
				String st="successfully jdbc connected";
			}else {
				String st="not connected jdbc";
			}
		
				
				
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		
		return st;
	}
}
	
	

