package com.zzzzzyx.training_management.model.log;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudyLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String logKind;
	long user_id;
	long ins_id;
	long course_id;
	Date time;
	
	public static final String LogKind_attend = "attend";
	public static final String LogKind_leaveBeforeStart = "leaveBeforeStart";
	public static final String LogKind_leaveAfterStart = "leaveAfterStart";
	public static final String LogKind_finish = "finish";
	
	public String getTitle(){
		switch(logKind){
		case LogKind_attend: return "预定";
		case LogKind_leaveBeforeStart: return "退订";
		case LogKind_leaveAfterStart: return "退课";
		case LogKind_finish: return "完成";
		default: return "�쳣";
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogKind() {
		return logKind;
	}
	public void setLogKind(String logKind) {
		this.logKind = logKind;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getIns_id() {
		return ins_id;
	}
	public void setIns_id(long ins_id) {
		this.ins_id = ins_id;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
