package com.example.management;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {


    @Id
    @Column(name ="hotel_id")
    private Long hotelId;
    
    @Column(name="current_bookings")
    private int currentBookings;
    
    @Column(name = "current_staff")
    private int currentStaff;
    
    @Column(name = "total_rooms")
    private int totalRooms;
    
    @Column(name = "ratio")
    private double ratio;
    
    @OneToOne(mappedBy="hotel")
    private Manager manager;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Staff> staffs = new HashSet<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cluster_id")
    private Cluster cluster;
    
    public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	
    
 
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public int getCurrentBookings() {
		return currentBookings;
	}
	public void setCurrentBookings(int currentBookings) {
		this.currentBookings = currentBookings;
	}
	public int getCurrentStaff() {
		return currentStaff;
	}
	public void setCurrentStaff(int currentStaff) {
		this.currentStaff = currentStaff;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Hotel(Long hotelId, int currentBookings, int currentStaff, int totalRooms, double ratio) {
		super();
		this.hotelId = hotelId;
		this.currentBookings = currentBookings;
		this.currentStaff = currentStaff;
		this.totalRooms = totalRooms;
		this.ratio = ratio;

	}
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}