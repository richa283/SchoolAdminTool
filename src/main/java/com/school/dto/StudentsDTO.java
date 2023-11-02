package com.school.dto;

public class StudentsDTO {

	public int id;
	public String name;
	public String father_name;
	public String mother_name;
	public String roll_no;
	public String classes;
	public String fees;
	public String session;
	public String address;
	public String mobile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "StudentsDTO [name=" + name + ", father_name=" + father_name + ", mother_name=" + mother_name
				+ ", roll_no=" + roll_no + ", classes=" + classes + ", fees=" + fees + ", session=" + session
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
