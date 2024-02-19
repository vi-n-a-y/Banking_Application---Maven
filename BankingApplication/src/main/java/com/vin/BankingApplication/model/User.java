package com.vin.BankingApplication.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="abcdef")
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer	user_id;

@Column
private String	user_name;
@Column
private String	user_pass;
@Column
private String	user_full_name;
@Column
private String	user_mail;
@Column
private String	user_ph;
@Column
private String	user_address;

public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_pass() {
	return user_pass;
}
public void setUser_pass(String user_pass) {
	this.user_pass = user_pass;
}
public String getUser_full_name() {
	return user_full_name;
}
public void setUser_full_name(String user_full_name) {
	this.user_full_name = user_full_name;
}
public String getUser_mail() {
	return user_mail;
}
public void setUser_mail(String user_mail) {
	this.user_mail = user_mail;
}
public String getUser_ph() {
	return user_ph;
}
public void setUser_ph(String user_ph) {
	this.user_ph = user_ph;
}
public String getUser_address() {
	return user_address;
}
public void setUser_address(String user_address) {
	this.user_address = user_address;
}
public User(Integer user_id, String user_name, String user_pass, String user_full_name, String user_mail,
		String user_ph, String user_address) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.user_pass = user_pass;
	this.user_full_name = user_full_name;
	this.user_mail = user_mail;
	this.user_ph = user_ph;
	this.user_address = user_address;
}
@Override
public String toString() {
	return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + ", user_full_name="
			+ user_full_name + ", user_mail=" + user_mail + ", user_ph=" + user_ph + ", user_address=" + user_address
			+ "]";
}
	
	

}
