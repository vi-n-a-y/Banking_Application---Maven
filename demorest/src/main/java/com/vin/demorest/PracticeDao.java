package com.vin.demorest;

import java.util.ArrayList;
import java.util.List;


public class PracticeDao {

	List<Practice> practice;
	
	public PracticeDao() {
		practice=new ArrayList<>();
		
		Practice p1=new Practice();
		p1.setId(101);
		p1.setName("bala");
		p1.setPoints(30);
		
		Practice p2=new Practice();
		p2.setId(102);
		p2.setName("vinay");
		p2.setPoints(50);
		System.out.println("dao is called");
		
		practice.add(p1);
		practice.add(p2);
		
	}
	
	public List<Practice> getPractices(){
		
		System.out.println("dao getPractices method is called");
		return practice;
	}
	
	public Practice getPract(int id) {
		
		Practice p=null;
		
		System.out.println("dao getpract is called");
		for(Practice p3:practice) {
			
			if(p3.getId()==id)
				return p3;
		}
		return null;
		
		
	}
	
	
}
