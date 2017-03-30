package com.zzzzzyx.training_management.model.log;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ConsumeLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String consumeKind;
	long user_id;
	long course_id;
	long ins_id;
	long money;
	Date time;
	
	public static final String ConsumeKind_activation = "activation";
	public static final String ConsumeKind_attend = "attend";
	public static final String ConsumeKind_refund = "refund";
	
	public String getTitle(){
		switch(consumeKind){
		case ConsumeKind_activation: return "激活";
		case ConsumeKind_attend: return "预定";
		case ConsumeKind_refund: return "退款";
		default: return "�쳣";
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConsumeKind() {
		return consumeKind;
	}

	public void setConsumeKind(String consumeKind) {
		this.consumeKind = consumeKind;
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

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
