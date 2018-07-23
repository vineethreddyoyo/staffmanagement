package com.example.management;

import javax.persistence.Entity;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@GeneratedValue
	@Column(name="request_id")
	private Long requestId;
	
	@Column(name="hotel_id")
	private Long hotelId;
	
	@Column(name="n_staff")
	private int n_staff;
	
	
	@Column(name="date")
	private Date date;
	
	
	
	public int getN_staff() {
		return n_staff;
	}

	public void setN_staff(int n_staff) {
		this.n_staff = n_staff;
	}
	

	public Request() {
		
		this.date = new Date(System.currentTimeMillis());
		
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Request(long requestId, Long hotelId, int n_staff, Date date) {
		super();
		this.requestId = requestId;
		this.hotelId = hotelId;
		this.n_staff = n_staff;
		this.date = date;
	}

	
	
}
