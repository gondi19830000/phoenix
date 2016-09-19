package com.shangliwei.phoenix.domain.bo;

import java.sql.Connection;

import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.impl.DepartmentTransformImpl;

public class EmployeeBo extends EmployeePo {

	private EmployeePo po;
	private Connection connection;
	
	private String stateName;
	private String createrUsername;
	private String editerUsername;
	private DepartmentBo departmentBo;

	public EmployeeBo(EmployeePo po, Connection connection) {
		super();
		this.po = po;
		this.connection = connection;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCreaterUsername() {
		return createrUsername;
	}

	public void setCreaterUsername(String createrUsername) {
		this.createrUsername = createrUsername;
	}

	public String getEditerUsername() {
		return editerUsername;
	}

	public void setEditerUsername(String editerUsername) {
		this.editerUsername = editerUsername;
	}

	public DepartmentBo getDepartmentBo() {
		if (departmentBo == null) {
			departmentBo = new DepartmentTransformImpl().toBo(new DepartmentDaoImpl().query(po.getDepartmentId(), connection), connection);
		}
		return departmentBo;
	}

	public void setDepartmentBo(DepartmentBo departmentBo) {
		this.departmentBo = departmentBo;
	}

}
