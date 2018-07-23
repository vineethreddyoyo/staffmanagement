package com.example.management;

import javax.persistence.*;

@Entity
@Table(name="notifications")
public class Notification {
	
@Id
@GeneratedValue
@Column(name="notification_id")
private Long notificationId;

@Column(name="staff_id")
private Long staffId;

@Column(name="to_hotel_id")
private Long tohotelId;

@Column (name="from_hotel_id")
private Long fromhotelId;

public Long getNotificationId() {
	return notificationId;
}

public void setNotificationId(Long notificationId) {
	this.notificationId = notificationId;
}

public Long getStaffId() {
	return staffId;
}

public void setStaffId(Long staffId) {
	this.staffId = staffId;
}

public Long getTohotelId() {
	return tohotelId;
}

public void setTohotelId(Long tohotelId) {
	this.tohotelId = tohotelId;
}

public Long getFromHotelId() {
	return fromhotelId;
}

public void setFromHotelId(Long fromHotelId) {
	this.fromhotelId = fromHotelId;
}

public Notification(Long notificationId, Long staffId, Long tohotelId, Long fromHotelId) {
	super();
	this.notificationId = notificationId;
	this.staffId = staffId;
	this.tohotelId = tohotelId;
	this.fromhotelId = fromHotelId;
}

public Notification() {
	super();
	// TODO Auto-generated constructor stub
}



	
}
