package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ClassChange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long course_id;
	String courseName;//filled by user
	String teacherName;//filled by user
	int price;//filled by user
	String startTime;//filled by user
	String endTime;//filled by user
	long institution_id;
	String course_status;
	String description;
	String changeKind;
	
	public static final String ChangeKind_register = "register";
	public static final String ChangeKind_change = "change";
	public static final String ChangeKind_delete = "delete";
	public ClassChange() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
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
	public String getCourse_status() {
		return course_status;
	}
	public void setCourse_status(String course_status) {
		this.course_status = course_status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChangeKind() {
		return changeKind;
	}
	public void setChangeKind(String changeKind) {
		this.changeKind = changeKind;
	}
	public static String getChangekindRegister() {
		return ChangeKind_register;
	}
	public static String getChangekindChange() {
		return ChangeKind_change;
	}
	public static String getChangekindDelete() {
		return ChangeKind_delete;
	}
	
	
	
}
