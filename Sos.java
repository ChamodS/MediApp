/**
 * 
 */
/**
 * @author Dush
 *
 */
package com.example.mediapp.sos;

import java.util.Date;
import java.util.Map;

//import java.io.Serializable;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Table;
import javax.persistence.ManyToOne;

//import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.mediapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Sos{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long sosid;
	Date occuredDate;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	public User users;
	
	
	
	@Override
	public String toString() {
		return "Sos [sosid=" + sosid + ",occuredDate=" + occuredDate + "]";
	}
	
	
	public long getSosId() {
		return sosid;
	}
	public void setSosId(long sosid) {
		this.sosid = sosid;
	}
	public Date getOccuredDate() {
		return occuredDate;
	}
	public void setOccuredDate(Date occuredDate) {
		this.occuredDate = occuredDate;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	

}
