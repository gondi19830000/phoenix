package com.shangliwei.phoenix.domain.po;

import java.math.BigDecimal;

import oracle.sql.TIMESTAMP;

public class EmployeePo {

	private String id;
	private BigDecimal sequence;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String state;
	private String departmentId;

	private String creater;
	private TIMESTAMP creattime;
	private String editer;
	private TIMESTAMP edittime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getSequence() {
		return sequence;
	}

	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public TIMESTAMP getCreattime() {
		return creattime;
	}

	public void setCreattime(TIMESTAMP creattime) {
		this.creattime = creattime;
	}

	public String getEditer() {
		return editer;
	}

	public void setEditer(String editer) {
		this.editer = editer;
	}

	public TIMESTAMP getEdittime() {
		return edittime;
	}

	public void setEdittime(TIMESTAMP edittime) {
		this.edittime = edittime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

}
