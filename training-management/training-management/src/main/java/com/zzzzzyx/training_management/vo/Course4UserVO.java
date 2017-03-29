package com.zzzzzyx.training_management.vo;

import com.zzzzzyx.training_management.model.Course;

public class Course4UserVO {

	long id;
	String courseName;
	String teacherName;
	int price;
	String startTime;
	String endTime;
	long institution_id;
	String status;
	
	int mark;
	boolean finished;

	public Course4UserVO() {
		super();
	}

	public Course4UserVO(long id, String courseName, String teacherName, int price, String startTime, String endTime,
			long institution_id, String status, int mark, boolean isFinished) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.institution_id = institution_id;
		this.status = status;
		this.mark = mark;
		this.finished = isFinished;
	}

	public Course4UserVO(Course c) {
		super();
		this.id = c.getId();
		this.courseName = c.getCourseName();
		this.teacherName = c.getTeacherName();
		this.price = c.getPrice();
		this.startTime = c.getStartTime();
		this.endTime = c.getEndTime();
		this.institution_id = c.getInstitution_id();
		this.status = c.getStatus();
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
