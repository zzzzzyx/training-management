package com.zzzzzyx.training_management.model.globalData.manager.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class KindToCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int attendNum;
	int cancelRate;
	int averageMark;
	
	String length;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}

	public int getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(int cancelRate) {
		this.cancelRate = cancelRate;
	}

	public int getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	
}
