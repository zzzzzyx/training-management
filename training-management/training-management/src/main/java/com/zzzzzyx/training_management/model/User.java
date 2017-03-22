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
	long level;
	long point;
	long overallConsumption;
	Date activationTime;
	long auth_id;
	
	public static final String Status_unactivated = "unactivated";
	public static final String Status_available = "available";
	public static final String Status_suspended = "suspended";
	public static final String Status_stopped = "stopped";
	
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
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
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
	
	
	
}
