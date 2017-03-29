package com.zzzzzyx.training_management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String status;
	long point;
	long overallConsumption;
	Date activationTime;
	long auth_id;
	
	public static final String Status_unactivated = "unactivated";
	public static final String Status_available = "available";
	public static final String Status_suspended = "suspended";
	public static final String Status_stopped = "stopped";
	
	public double getDiscountPercent(){
		if(point < 100)
			return 1;
		else if(point < 1000){
			return 0.95;
		}
		else
			return 0.9;
	}
	
	public Date getActivationTime() {
		return activationTime;
	}
	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}
	public long getOverallConsumption() {
		return overallConsumption;
	}
	public void setOverallConsumption(long overallConsumption) {
		this.overallConsumption = overallConsumption;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public long getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(long auth_id) {
		this.auth_id = auth_id;
	}

	public long getLastActivationTillToday() {
		if(this.getActivationTime() == null){
			return -1;
		}
		long timeDiv = new Date().getTime() - this.getActivationTime().getTime();
        long dayDiv = (long) (timeDiv /( 1000.0 * 24 * 60 * 60));
		return dayDiv;
	}
	
	
	
}
