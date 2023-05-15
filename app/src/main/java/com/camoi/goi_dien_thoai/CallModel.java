package com.camoi.goi_dien_thoai;


import java.time.Duration;
import java.time.LocalDateTime;

public class CallModel {
    private int id;
    private ContactModel contactModel;
    private LocalDateTime dateTime;
    private Duration duration;
    private boolean isMissed;

    public CallModel(int id, ContactModel contactModel, LocalDateTime dateTime, Duration duration, boolean isMissed) {
        this.id = id;
        this.contactModel = contactModel;
        this.dateTime = dateTime;
        this.duration = duration;
        this.isMissed = isMissed;
    }

    public CallModel() {

    }

    @Override
    public String toString() {
        return "CallModel{" +
                "id=" + id +
                ", contactModel=" + contactModel +
                ", dateTime=" + dateTime +
                ", duration=" + duration +
                ", isMissed=" + isMissed +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isMissed() {
        return isMissed;
    }

    public void setMissed(boolean missed) {
        isMissed = missed;
    }
}
