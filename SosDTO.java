package com.example.mediapp.sos;

import java.util.Date;

public class SosDTO {

	long sosid;
	Date occuredDate;
	long user_id;
	
	public long getSosid() {
		return sosid;
	}
	public void setSosid(long sosid) {
		this.sosid = sosid;
	}
	public Date getOccuredDate() {
		return occuredDate;
	}
	public void setOccuredDate(Date occuredDate) {
		this.occuredDate = occuredDate;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	

	
}
