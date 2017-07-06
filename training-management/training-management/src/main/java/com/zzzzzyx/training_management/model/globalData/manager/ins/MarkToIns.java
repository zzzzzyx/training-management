package com.zzzzzyx.training_management.model.globalData.manager.ins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MarkToIns {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int attendNum;
	int cancelRate;
	
	String averageMark;

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

	public String getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(String averageMark) {
		this.averageMark = averageMark;
	}

	
}
