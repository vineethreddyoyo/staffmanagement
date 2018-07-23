package com.example.management;

public class Details {

	private Long staff_id;
	private String staff_name;
	private String phone;
	
	

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	public Details(Long staff_id, String staff_name) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
	}
	
	public Details(Long staff_id, String staff_name, String phone) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.phone = phone;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
