package com.ims.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Faculty {

	@Id
	private int fid;
	private String fname;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Course c;
	
	
	public Course getC() {
		return c;
	}
	public void setC(Course c) {
		this.c = c;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
