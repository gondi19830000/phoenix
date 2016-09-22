package com.shangliwei.phoenix.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IEmployeeDao;
import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.IEmployeeTransform;
import com.shangliwei.phoenix.domain.transform.impl.EmployeeTransformImpl;
import com.shangliwei.phoenix.domain.vo.EmployeeDetailVo;
import com.shangliwei.phoenix.domain.vo.EmployeeListVo;
import com.shangliwei.phoenix.domain.vo.EmployeePopVo;
import com.shangliwei.phoenix.service.IEmployeeService;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.Pagination;
import com.shangliwei.phoenix.util.SequenceUtil;

public class EmployeeServiceImpl implements IEmployeeService {

	private Connection connection;
	private IEmployeeDao dao = new EmployeeDaoImpl();
	private IEmployeeTransform transform = new EmployeeTransformImpl();
	
	@Override
	public void add(EmployeeDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBUtil.getConnection();
			EmployeePo po = new EmployeePo();
			po.setId(SequenceUtil.getUUID());
			po.setSequence(dao.getMaxSequence(connection) + 1);
			po.setUsername(vo.getUsername());
			po.setPassword(vo.getPassword());
			po.setEmail(vo.getEmail());
			po.setPhone(vo.getPhone());
			po.setState("01");
			po.setDepartmentId(vo.getDepartmentId());
			po.setCreater(currendEmployeeId);
			po.setCreattime(DateTimeUtil.getTimestamp());
			dao.add(po, connection);
		} finally {
			DBUtil.release(connection);
		}
	}

	@Override
	public void update(EmployeeDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBUtil.getConnection();
			EmployeePo po = dao.query(vo.getId(), connection);
			po.setId(vo.getId());
			po.setUsername(vo.getUsername());
			po.setPassword(vo.getPassword());
			po.setEmail(vo.getEmail());
			po.setPhone(vo.getPhone());
			po.setState(vo.getState());
			po.setDepartmentId(vo.getDepartmentId());
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
	public EmployeeDetailVo queryDetail(String id) throws ClassNotFoundException, SQLException {
		EmployeeDetailVo vo = null;
		try {
			connection = DBUtil.getConnection();
			EmployeePo po = dao.query(id, connection);
			if (po != null) {
				vo = (EmployeeDetailVo) transform.toDetailVo(po, connection);
			}
		} finally {
			DBUtil.release(connection);
		}
		return vo;
	}

	@Override
	public List<EmployeeListVo> queryList(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		List<EmployeeListVo> voList = null;
		try {
			connection = DBUtil.getConnection();
			int beginRow = 0;
			int endRow = 0;
			if (pagination != null) {
				beginRow = pagination.getBeginRow();
				endRow = pagination.getEndRow();
			}
			List<EmployeePo> poList = dao.query(condition, beginRow, endRow, connection);
			if (poList != null) {
				voList = new ArrayList<>();
				for (EmployeePo po : poList) {
					voList.add((EmployeeListVo) transform.toListVo(po, connection));
				}
			}
		} finally {
			DBUtil.release(connection);
		}
		return voList;
	}

	@Override
	public List<EmployeePopVo> queryPop(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		List<EmployeePopVo> popList = null;
		try {
			connection = DBUtil.getConnection();
			int beginRow = 0;
			int endRow = 0;
			if (pagination != null) {
				beginRow = pagination.getBeginRow();
				endRow = pagination.getEndRow();
			}
			List<EmployeePo> poList = dao.query(condition, beginRow, endRow, connection);
			if (poList != null) {
				popList = new ArrayList<>();
				for (EmployeePo po : poList) {
					popList.add((EmployeePopVo) transform.toPopVo(po, connection));
				}
			}
		} finally {
			DBUtil.release(connection);
		}
		return popList;
	}

}
