package com.vin.practice;

public class Student {
	private int id;
	private String name;
	private int point;
	
	
	
	
	
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name, int point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}
	public Student(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}


}
