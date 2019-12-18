package com.example.mediapp.clinicalEvent;


import java.util.Date;

public class ClinicalEventDTO {
    Date createDate;
    Date date;
    String eventName;
    String venue;
    String description;
    String imageUrl;
    String targetAudience;//aim- send notifications and when updating attendance
    String time;
    String guestTitle;
    String guestName;
    String guestEmail;

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getGuestTitle() {
        return guestTitle;
    }

    public void setGuestTitle(String guestTitle) {
        this.guestTitle = guestTitle;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTargetAudiance() {
        return targetAudience;
    }

    public void setTargetAudiance(String targetAudiance) {
        this.targetAudience = targetAudiance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
