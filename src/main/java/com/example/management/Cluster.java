package com.example.management;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clusters")
public class Cluster {

    @Id
    @Column(name = "cluster_id")
    private long clusterId;

    @Column(name="cluster_name")
    private String clusterName;
    
    @OneToMany(mappedBy = "cluster", cascade= CascadeType.ALL)
    private Set<Hotel> hotels = new HashSet<>();

	public Cluster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getClusterId() {
		return clusterId;
	}

	public void setClusterId(long clusterId) {
		this.clusterId = clusterId;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Cluster(long clusterId, String clusterName) {
		super();
		this.clusterId = clusterId;
		this.clusterName = clusterName;
	}



	
}
