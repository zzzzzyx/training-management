package com.zzzzzyx.training_management.model.globalData.manager.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AttendCourseLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int ge10;
	int ge5;
	int ge3;
	int ge0;
	String month;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getGe10() {
		return ge10;
	}
	public void setGe10(int ge10) {
		this.ge10 = ge10;
	}
	public int getGe5() {
		return ge5;
	}
	public void setGe5(int ge5) {
		this.ge5 = ge5;
	}
	public int getGe3() {
		return ge3;
	}
	public void setGe3(int ge3) {
		this.ge3 = ge3;
	}
	public int getGe0() {
		return ge0;
	}
	public void setGe0(int ge0) {
		this.ge0 = ge0;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
