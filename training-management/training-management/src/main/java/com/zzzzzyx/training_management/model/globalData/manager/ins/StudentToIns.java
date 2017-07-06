package com.zzzzzyx.training_management.model.globalData.manager.ins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudentToIns {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int cancelRate;
	int averageMark;
	
	String student;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	
	
	
}
