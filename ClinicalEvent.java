/**
 * 
 */
/**
 * @author Dush
 *
 */
package com.example.mediapp.clinicalEvent;

import com.example.mediapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class ClinicalEvent{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long eventId;
	
	@NonNull
	Date createDate;
	LocalDate date;
	String eventName;
	String venue;
	String description;
	String targetAudi;
	public String getTargetAudi() {
		return targetAudi;
	}
	public void setTargetAudi(String targetAudi) {
		this.targetAudi = targetAudi;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getCreateDate() {
		return createDate;
	}
	String imageUrl;
	
	 @ManyToMany(mappedBy = "clinicalEvents")
	    @JsonIgnore
	    List<User> users;
	
	@Override
	public String toString() {
		return "ClinicalEvent [eventId=" + eventId + ", createDate=" + createDate + ", eventName=" + eventName + ", date=" + date + ", venue=" + venue + ",description="+description+",imageUrl="+imageUrl+"]";
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public Date CreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
