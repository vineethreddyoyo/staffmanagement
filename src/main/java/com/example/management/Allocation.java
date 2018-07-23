package com.example.management;

import java.util.List;

public class Allocation {

	private Long managerId;
	private List<Long> s_ids;
	private Long  to_hotel_id;
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public List<Long> getS_ids() {
		return s_ids;
	}
	public void setS_ids(List<Long> s_ids) {
		this.s_ids = s_ids;
	}
	public Long getTo_hotel_id() {
		return to_hotel_id;
	}
	public void setTo_hotel_id(Long to_hotel_id) {
		this.to_hotel_id = to_hotel_id;
	}
	public Allocation(Long managerId, List<Long> s_ids, Long to_hotel_id) {
		super();
		this.managerId = managerId;
		this.s_ids = s_ids;
		this.to_hotel_id = to_hotel_id;
	}
	public Allocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
