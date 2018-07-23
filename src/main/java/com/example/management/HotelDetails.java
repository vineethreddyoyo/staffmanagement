package com.example.management;


public class HotelDetails {
	private Long hotelId;
    
    private int currentBookings;
    
    private int currentStaff;
   
    private int totalRooms;
    
    private double ratio;
    
    private String hotelName;
    
    private String managerName;

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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public HotelDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelDetails(Long hotelId, int currentBookings, int currentStaff, int totalRooms, double ratio,
			String hotelName, String managerName) {
		super();
		this.hotelId = hotelId;
		this.currentBookings = currentBookings;
		this.currentStaff = currentStaff;
		this.totalRooms = totalRooms;
		this.ratio = ratio;
		this.hotelName = hotelName;
		this.managerName = managerName;
	}
  
    
    
}
