package com.jsp.shopping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff", catalog = "staff_data")
public class Staff implements Comparable<Staff>{
	int id;
	String name;
	String location;
	String mobile;
	@Id
	@Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public int compareTo(Staff o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
