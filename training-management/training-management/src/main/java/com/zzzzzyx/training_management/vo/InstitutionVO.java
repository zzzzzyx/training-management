package com.zzzzzyx.training_management.vo;

public class InstitutionVO {

	long id;
	String name;
	int courseCount;
	int studyConnectionCount;	
	
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
	public int getCourseCount() {
		return courseCount;
	}
	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}
	public int getStudyConnectionCount() {
		return studyConnectionCount;
	}
	public void setStudyConnectionCount(int studyConnectionCount) {
		this.studyConnectionCount = studyConnectionCount;
	}
	
	
}
