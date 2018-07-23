package com.example.management;

import java.util.List;

public class ClusterDetails {
	
    private Long clusterId;
    private String clusterName;
    private Long totalHotels;
    private List<HotelDetails> allHotels;
    
	public List<HotelDetails> getAllHotels() {
		return allHotels;
	}
	public void setAllHotels(List<HotelDetails> allHotels) {
		this.allHotels = allHotels;
	}
	public Long getClusterId() {
		return clusterId;
	}
	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public Long getTotalHotels() {
		return totalHotels;
	}
	public void setTotalHotels(Long totalHotels) {
		this.totalHotels = totalHotels;
	}
	public ClusterDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
