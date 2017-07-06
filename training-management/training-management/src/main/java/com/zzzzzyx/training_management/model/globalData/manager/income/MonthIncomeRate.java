package com.zzzzzyx.training_management.model.globalData.manager.income;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MonthIncomeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	double rate;
	String month;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	
}
