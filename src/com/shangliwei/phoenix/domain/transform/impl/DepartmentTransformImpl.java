package com.shangliwei.phoenix.domain.transform.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.bo.DepartmentBo;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.transform.IDepartmentTransform;
import com.shangliwei.phoenix.domain.vo.DepartmentDetailVo;
import com.shangliwei.phoenix.domain.vo.DepartmentListVo;
import com.shangliwei.phoenix.domain.vo.DepartmentPopVo;
import com.shangliwei.phoenix.util.CacheUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;

public class DepartmentTransformImpl implements IDepartmentTransform {

	@Override
	public DepartmentBo toBo(DepartmentPo po, Connection connection) throws SQLException {
		DepartmentBo bo = new DepartmentBo(po, connection);
		bo.setEmployeeBo(new EmployeeTransformImpl().toBo(new EmployeeDaoImpl().query(po.getManager(), connection), connection));
		return bo;
	}

	@Override
	public DepartmentDetailVo toDetailVo(DepartmentPo po, Connection connection) {
		DepartmentDetailVo vo = new DepartmentDetailVo();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setParentId(po.getParentId());
		vo.setType(po.getType());
		vo.setManager(po.getManager());
		vo.setState(po.getState());
		vo.setDescription(po.getDescription());
		vo.setCreater(po.getCreater());
		vo.setEditer(po.getEditer());
		vo.setParentIdName(CacheUtil.getDepartmentName(po.getParentId(), connection));
		vo.setTypeName(CacheUtil.getDictionaryName(po.getType(), "DEPARTMENT_TYPE", connection));
		vo.setStateName(CacheUtil.getDictionaryName(po.getState(), "DEPARTMENT_STATE", connection));
		vo.setCreateDateCN(DateTimeUtil.format(po.getCreateDate()));
		vo.setCloseDateCN(DateTimeUtil.format(po.getCloseDate()));
		vo.setManagerUsername(CacheUtil.getUsername(po.getManager(), connection));
		vo.setCreaterUsername(CacheUtil.getUsername(po.getCreater(), connection));
		vo.setCreattimeCN(DateTimeUtil.format(po.getCreattime()));
		vo.setEditerUsername(CacheUtil.getUsername(po.getEditer(), connection));
		vo.setEdittimeCN(DateTimeUtil.format(po.getEdittime()));
		return vo;
	}

	@Override
	public DepartmentListVo toListVo(DepartmentPo po, Connection connection) {
		DepartmentListVo vo = new DepartmentListVo();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setParentId(po.getParentId());
		vo.setManager(po.getManager());
		vo.setState(po.getState());
		vo.setParentIdName(CacheUtil.getDepartmentName(po.getParentId(), connection));
		vo.setManagerUsername(CacheUtil.getUsername(po.getManager(), connection));
		vo.setStateName(CacheUtil.getDictionaryName(po.getState(), "DEPARTMENT_STATE", connection));
		return vo;
	}

	@Override
	public DepartmentPopVo toPopVo(DepartmentPo po, Connection connection) {
		DepartmentPopVo vo = new DepartmentPopVo();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setParentId(po.getParentId());
		vo.setManager(po.getManager());
		vo.setParentIdName(CacheUtil.getDepartmentName(po.getParentId(), connection));
		vo.setManagerUsername(CacheUtil.getUsername(po.getManager(), connection));
		return vo;
	}

}
