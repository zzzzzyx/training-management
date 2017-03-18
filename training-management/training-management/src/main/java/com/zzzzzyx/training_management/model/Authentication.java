package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class Authentication {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tableGenerator")
	@TableGenerator(name="tableGenerator",initialValue=1000005,allocationSize=1)
	long id;
	String username;
	String password;
	long bankCardNumber;
	String userKind;
	
	public static final String UserKind_User = "User";
	public static final String UserKind_Manager = "Manager";
	public static final String UserKind_Institution = "Institution";
	
	public Authentication() {
	}

	public long getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserKind() {
		return userKind;
	}

	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}
	
	
}
