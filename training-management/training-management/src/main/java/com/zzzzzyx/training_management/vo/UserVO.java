package com.zzzzzyx.training_management.vo;

public class UserVO {

	long id;
	String name;
	long point;
	long lastActivationTillToday;
	int attendedCourseCount;
	int finishedCourseCount;
	int averageMark;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public long getLastActivationTillToday() {
		return lastActivationTillToday;
	}
	public void setLastActivationTillToday(long lastActivationTillToday) {
		this.lastActivationTillToday = lastActivationTillToday;
	}
	public int getAttendedCourseCount() {
		return attendedCourseCount;
	}
	public void setAttendedCourseCount(int attendedCourseCount) {
		this.attendedCourseCount = attendedCourseCount;
	}
	public int getFinishedCourseCount() {
		return finishedCourseCount;
	}
	public void setFinishedCourseCount(int finishedCourseCount) {
		this.finishedCourseCount = finishedCourseCount;
	}
	public int getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}
	
	
}
