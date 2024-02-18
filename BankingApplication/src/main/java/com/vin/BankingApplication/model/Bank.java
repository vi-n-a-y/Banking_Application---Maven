package com.vin.BankingApplication.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data ;

@Data
@Entity
@Table(name="abcdef")
public class Bank {
	
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
	
	

}
