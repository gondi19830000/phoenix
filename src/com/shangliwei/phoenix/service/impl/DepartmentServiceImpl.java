package com.shangliwei.phoenix.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IDepartmentDao;
import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.transform.IDepartmentTransform;
import com.shangliwei.phoenix.domain.transform.impl.DepartmentTransformImpl;
import com.shangliwei.phoenix.domain.vo.DepartmentDetailVo;
import com.shangliwei.phoenix.domain.vo.DepartmentListVo;
import com.shangliwei.phoenix.domain.vo.DepartmentPopVo;
import com.shangliwei.phoenix.service.IDepartmentService;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.Pagination;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DepartmentServiceImpl implements IDepartmentService {

	private Connection connection;
	private IDepartmentDao dao = new DepartmentDaoImpl();
	private IDepartmentTransform transform = new DepartmentTransformImpl();
	
	@Override
	public void add(DepartmentDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBUtil.getConnection();
			DepartmentPo po = new DepartmentPo();
			po.setId(SequenceUtil.getUUID());
			po.setName(vo.getName());
			po.setParentId(vo.getParentId());
			po.setType(vo.getType());
			po.setManager(vo.getManager());
			po.setState("01");
			po.setCreateDate(DateTimeUtil.getDate());
			po.setDescription(vo.getDescription());
			po.setCreater(currendEmployeeId);
			po.setCreattime(DateTimeUtil.getTimestamp());
			dao.add(po, connection);
		} finally {
			DBUtil.release(connection);
		}
	}

	@Override
	public void update(DepartmentDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBUtil.getConnection();
			DepartmentPo po = new DepartmentPo();
			po.setId(vo.getId());
			po.setName(vo.getName());
			po.setParentId(vo.getParentId());
			po.setType(vo.getType());
			po.setManager(vo.getManager());
			po.setState(vo.getState());
			po.setCreateDate(DateTimeUtil.getDate());
			po.setDescription(vo.getDescription());
			po.setEditer(currendEmployeeId);
			po.setEdittime(DateTimeUtil.getTimestamp());
			dao.update(po, connection);
		} finally {
			DBUtil.release(connection);
		}
	}

	@Override
	public void delete(String id, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBUtil.getConnection();
			dao.delete(id, connection);
		} finally {
			DBUtil.release(connection);
		}
	}

	@Override
	public DepartmentDetailVo queryDetail(String id) throws ClassNotFoundException, SQLException {
		DepartmentDetailVo vo = null;
		try {
			connection = DBUtil.getConnection();
			DepartmentPo po = dao.query(id, connection);
			if (po != null) {
				vo = (DepartmentDetailVo) transform.toDetailVo(po, connection);
			}
		} finally {
			DBUtil.release(connection);
		}
		return vo;
	}

	@Override
	public List<DepartmentListVo> queryList(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		List<DepartmentListVo> voList = null;
		try {
			connection = DBUtil.getConnection();
			List<DepartmentPo> poList = dao.query(condition, pagination, connection);
			if (poList != null) {
				voList = new ArrayList<>();
				for (DepartmentPo po : poList) {
					voList.add((DepartmentListVo) transform.toListVo(po, connection));
				}
			}
		} finally {
			DBUtil.release(connection);
		}
		return voList;
	}

	@Override
	public List<DepartmentPopVo> queryPop(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		List<DepartmentPopVo> popList = null;
		try {
			connection = DBUtil.getConnection();
			List<DepartmentPo> poList = dao.query(condition, pagination, connection);
			if (poList != null) {
				popList = new ArrayList<>();
				for (DepartmentPo po : poList) {
					popList.add((DepartmentPopVo) transform.toPopVo(po, connection));
				}
			}
		} finally {
			DBUtil.release(connection);
		}
		return popList;
	}

}
