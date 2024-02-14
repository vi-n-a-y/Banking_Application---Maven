package com.vin.demorest;



import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("practice")
public class PracticeResource {
	
	
	
	PracticeDao dao=new PracticeDao();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Practice> getPractice() {
		
		System.out.println("practice method is called!");

		
		
//		System.out.println(p1.getName());
//		System.out.println(p1.getPoints());
//		System.out.println(p1);
		return dao.getPractices();
		
	}
	
	

}
