package com.shangliwei.phoenix.domain.transform.impl;

import java.sql.Connection;

import com.shangliwei.phoenix.domain.bo.DepartmentBo;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.transform.ITransform;
import com.shangliwei.phoenix.domain.vo.DepartmentDetailVo;
import com.shangliwei.phoenix.domain.vo.DepartmentListVo;
import com.shangliwei.phoenix.domain.vo.DepartmentPopVo;

public class DepartmentTransformImpl implements ITransform<DepartmentPo> {

	@Override
	public DepartmentBo toBo(DepartmentPo po, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentDetailVo toDetailVo(DepartmentPo po, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentListVo toListVo(DepartmentPo po, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentPopVo toPopVo(DepartmentPo po, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

}
