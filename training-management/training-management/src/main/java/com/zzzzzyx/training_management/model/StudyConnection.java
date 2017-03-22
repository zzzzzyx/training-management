package com.zzzzzyx.training_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudyConnection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long user_id;
	long course_id;
	long institution_id;
	String paymentMethod;
	int mark;
	boolean isUser;//学员是否为会员
	boolean nameIfNotUser;
	
	public static final String PaymentMethod_cash = "cash";
	public static final String PaymentMethod_card = "card";
	
	public StudyConnection() {
	}
	
	

	public boolean isUser() {
		return isUser;
	}
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	public boolean isNameIfNotUser() {
		return nameIfNotUser;
	}
	public void setNameIfNotUser(boolean nameIfNotUser) {
		this.nameIfNotUser = nameIfNotUser;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(long institution_id) {
		this.institution_id = institution_id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
}
