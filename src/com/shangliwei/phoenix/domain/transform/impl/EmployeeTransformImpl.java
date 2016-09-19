package com.shangliwei.phoenix.domain.transform.impl;

import java.sql.Connection;

import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.domain.bo.EmployeeBo;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.ITransform;
import com.shangliwei.phoenix.domain.vo.EmployeeDetailVo;
import com.shangliwei.phoenix.domain.vo.EmployeeListVo;
import com.shangliwei.phoenix.domain.vo.EmployeePopVo;
import com.shangliwei.phoenix.util.CacheUtil;

public class EmployeeTransformImpl implements ITransform<EmployeePo> {

	@Override
	public EmployeeBo toBo(EmployeePo po, Connection connection) {
		EmployeeBo bo = new EmployeeBo(po, connection);
		bo.setStateName(CacheUtil.getDictionaryName(po.getState(), "EMPLOYEE_STATE", connection));
		bo.setCreaterUsername(CacheUtil.getUsername(po.getCreater(), connection));
		bo.setEditerUsername(CacheUtil.getUsername(po.getEditer(), connection));
		bo.setDepartmentBo(new DepartmentTransformImpl().toBo(new DepartmentDaoImpl().query(po.getDepartmentId(), connection), connection));
		return bo;
	}

	@Override
	public EmployeeDetailVo toDetailVo(EmployeePo po, Connection connection) {
		EmployeeDetailVo vo = new EmployeeDetailVo();
		vo.setId(po.getId());
		vo.setSequence(po.getSequence());
		vo.setUsername(po.getUsername());
		vo.setPassword(po.getPassword());
		vo.setEmail(po.getEmail());
		vo.setPhone(vo.getPhone());
		vo.setState(po.getState());
		vo.setDepartmentId(vo.getDepartmentId());
		vo.setCreater(po.getCreater());
		vo.setEditer(po.getEditer());
		vo.setStateName(CacheUtil.getDictionaryName(po.getState(), "EMPLOYEE_STATE", connection));
		vo.setDepartmentName(CacheUtil.getDepartmentName(po.getDepartmentId(), connection));
		return vo;
	}

	@Override
	public EmployeeListVo toListVo(EmployeePo po, Connection connection) {
		EmployeeListVo vo = new EmployeeListVo();
		vo.setId(po.getId());
		vo.setUsername(po.getUsername());
		vo.setEmail(po.getEmail());
		vo.setPhone(po.getPhone());
		vo.setStateName(CacheUtil.getDictionaryName(po.getState(), "EMPLOYEE_STATE", connection));
		vo.setDepartmentName(CacheUtil.getDepartmentName(po.getDepartmentId(), connection));
		return vo;
	}

	@Override
	public EmployeePopVo toPopVo(EmployeePo po, Connection connection) {
		EmployeePopVo vo = new EmployeePopVo();
		vo.setId(po.getId());
		vo.setUsername(po.getUsername());
		vo.setDepartmentName(CacheUtil.getDepartmentName(po.getDepartmentId(), connection));
		return vo;
	}

}
