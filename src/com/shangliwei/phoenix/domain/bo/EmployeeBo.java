package com.shangliwei.phoenix.domain.bo;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.impl.DepartmentTransformImpl;

public class EmployeeBo extends EmployeePo {

	private EmployeePo po;
	private Connection connection;
	
	private DepartmentBo departmentBo;

	public EmployeeBo(EmployeePo po, Connection connection) {
		super();
		this.po = po;
		this.connection = connection;
	}

	public DepartmentBo getDepartmentBo() throws SQLException {
		if (departmentBo == null) {
			departmentBo = new DepartmentTransformImpl().toBo(new DepartmentDaoImpl().query(po.getDepartmentId(), connection), connection);
		}
		return departmentBo;
	}

	public void setDepartmentBo(DepartmentBo departmentBo) {
		this.departmentBo = departmentBo;
	}

}
