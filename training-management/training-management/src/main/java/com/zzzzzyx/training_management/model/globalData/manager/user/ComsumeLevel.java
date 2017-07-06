package com.zzzzzyx.training_management.model.globalData.manager.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ComsumeLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	double gt2000;
	double gt1000;
	double gt500;
	double gt0;
	String month;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getGt2000() {
		return gt2000;
	}
	public void setGt2000(double gt2000) {
		this.gt2000 = gt2000;
	}
	public double getGt1000() {
		return gt1000;
	}
	public void setGt1000(double gt1000) {
		this.gt1000 = gt1000;
	}
	public double getGt500() {
		return gt500;
	}
	public void setGt500(double gt500) {
		this.gt500 = gt500;
	}
	public double getGt0() {
		return gt0;
	}
	public void setGt0(double gt0) {
		this.gt0 = gt0;
	}
	
	
	
}
