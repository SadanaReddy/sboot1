package com.sboot1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data

public class Faculty {


	private int id;

	private String firstName;

	private String lastName;

	private String dob;

	private boolean teaching;

	private long mobileNo;


	public Faculty() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public boolean isTeaching() {
		return teaching;
	}
	public void setTeaching(boolean teaching) {
		this.teaching = teaching;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

}
