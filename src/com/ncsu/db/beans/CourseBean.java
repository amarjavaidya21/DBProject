package com.ncsu.db.beans;

import java.util.Date;

public class CourseBean {

	String token="";
	String name="";
	Date startDate;
	Date endDate;
	String profID=""; 

	public CourseBean() {
		super();
	}
	
	public CourseBean(String token, String name, Date startDate, Date endDate,
			String profID) {
		super();
		this.token = token;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.profID = profID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProfID() {
		return profID;
	}

	public void setProfID(String profID) {
		this.profID = profID;
	}
}