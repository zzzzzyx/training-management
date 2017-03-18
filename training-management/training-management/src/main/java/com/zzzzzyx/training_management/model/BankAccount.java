package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tableGenerator")
	@TableGenerator(name="tableGenerator",initialValue=66000003,allocationSize=1)
	long cardNumber;
	long password;
	long money;
	
	
	public BankAccount() {
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	
	
}
