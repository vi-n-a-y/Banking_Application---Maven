package com.vin.practice;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data		//@Data is a Lombok annotation that generates boilerplate code for you, ie. getters, setters, equals(), hashCode(), and toString() methods , reducing the verbosity of your Java code and making it more readable.

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@Column
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
