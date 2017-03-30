package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String courseName;
	String teacherName;
	int price;
	String startTime;
	String endTime;
	long institution_id;
	String status;
	
	public static final String Status_waiting = "waiting";
	public static final String Status_studying = "studying";
	public static final String Status_end = "end";
	
	public Course(ClassChange classChange) {
		this.id = classChange.course_id;
		this.courseName = classChange.courseName;
		this.teacherName = classChange.teacherName;
		this.price = classChange.price;
		this.startTime = classChange.startTime;
		this.endTime = classChange.endTime;
		this.institution_id = classChange.institution_id;
		this.status = classChange.course_status;
	}

	@Override
	public String toString() {
		return "[课程名：" + courseName + ", 教师名：" + teacherName + ",价格：" + price + ", 开始时间:"
				+ startTime + ", 结束时间:" + endTime + ", 状态：" + status + "]";
	}



	public Course() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public long getInstitution_id() {
		return institution_id;
	}
	public void setInstitution_id(long institution_id) {
		this.institution_id = institution_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
