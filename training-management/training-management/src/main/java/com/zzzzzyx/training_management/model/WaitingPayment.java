package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WaitingPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long fromCardNumber;
	long toCardNumber;
	long money;
	String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFromCardNumber() {
		return fromCardNumber;
	}
	public void setFromCardNumber(long fromCardNumber) {
		this.fromCardNumber = fromCardNumber;
	}
	public long getToCardNumber() {
		return toCardNumber;
	}
	public void setToCardNumber(long toCardNumber) {
		this.toCardNumber = toCardNumber;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
