package com.ramorg.webmvc.student;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="STUDENT_ID")
	private int studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="DOB")
	private String dob;
	
	//private Address address;
	
	//private List<Skill> skills;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}*/

}
