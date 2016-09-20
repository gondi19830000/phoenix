package com.shangliwei.phoenix.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IEmployeeDao;
import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
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
	public void update(EmployeeDetailVo vo, String currendEmployeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id, String currendEmployeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeDetailVo queryDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeListVo> queryList(Map<String, Object> condition, Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePopVo> queryPop(Map<String, Object> condition, Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

}
