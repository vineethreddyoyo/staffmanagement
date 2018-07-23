package com.example.management;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name = "images")
public class Images {
	
@Id
@Column(name="manager_id")
private Long managerId;

@Column(name="url")
private String url;

public Long getManagerId() {
	return managerId;
}

public void setManagerId(Long managerId) {
	this.managerId = managerId;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public Images(Long managerId, String url) {
	super();
	this.managerId = managerId;
	this.url = url;
}

public Images() {
	super();
	// TODO Auto-generated constructor stub
}


	
}
	
