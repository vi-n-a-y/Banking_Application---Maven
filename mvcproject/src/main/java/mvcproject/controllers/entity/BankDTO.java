package mvcproject.controllers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class BankDTO {
	
	
	
	
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String uname;
	
	@Column(name="user_pass")
	private String password;
	
	@Column(name="user_full_name")
	private String fullName;
	
	@Column(name="user_mail")
	private String email;
	
	@Column(name="user_ph")
	private String phno;
	
	@Column(name="user_address")
	private String address;
		
	
	
	public BankDTO() {
		super();
	}


	public BankDTO(String uname, String password, String fullName, String email, String phno, String address) {
		super();
		this.uname = uname;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phno = phno;
		this.address = address;
	}


	public BankDTO(int userId, String uname, String password, String fullName, String email, String phno,
			String address) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phno = phno;
		this.address = address;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
		
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhno() {
		return phno;
	}


	public void setPhno(String phno) {
		this.phno = phno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}	
}
