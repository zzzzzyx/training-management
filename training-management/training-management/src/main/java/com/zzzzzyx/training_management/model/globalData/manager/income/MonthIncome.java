package com.zzzzzyx.training_management.model.globalData.manager.income;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MonthIncome {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int income;
	String month;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
