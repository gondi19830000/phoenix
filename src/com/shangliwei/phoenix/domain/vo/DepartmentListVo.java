package com.shangliwei.phoenix.domain.vo;

public class DepartmentListVo {

	private String id;
	private String name;
	private String parentId;
	private String manager;
	private String state;
	
	private String parentIdName;
	private String managerUsername;
	private String stateName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getParentIdName() {
		return parentIdName;
	}

	public void setParentIdName(String parentIdName) {
		this.parentIdName = parentIdName;
	}

	public String getManagerUsername() {
		return managerUsername;
	}

	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
