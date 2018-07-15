package com.example.management;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @Column(name = "staff_id")
    private Long staffId;

    //   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="staff_name")
    private String staffName;
    
    @Column(name="salary")
    private int salary;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    
    
    public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Staff() {
    }

    public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

	public Staff(Long staffId, String staffName, int salary) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.salary = salary;
	}

}
