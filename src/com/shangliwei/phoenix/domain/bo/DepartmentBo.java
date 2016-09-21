package com.shangliwei.phoenix.domain.bo;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.transform.impl.EmployeeTransformImpl;

public class DepartmentBo extends DepartmentPo {

	private DepartmentPo po;
	private Connection connection;
	
	private EmployeeBo employeeBo;

	public DepartmentBo(DepartmentPo po, Connection connection) {
		super();
		this.po = po;
		this.connection = connection;
	}

	public EmployeeBo getEmployeeBo() throws SQLException {
		if (employeeBo == null) {
			employeeBo = new EmployeeTransformImpl().toBo(new EmployeeDaoImpl().query(po.getManager(), connection), connection);
		}
		return employeeBo;
	}

	public void setEmployeeBo(EmployeeBo employeeBo) {
		this.employeeBo = employeeBo;
	}

}
