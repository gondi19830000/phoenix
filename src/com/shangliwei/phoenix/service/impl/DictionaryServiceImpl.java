package com.shangliwei.phoenix.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.constant.LogConstant;
import com.shangliwei.phoenix.dao.IDictionaryDao;
import com.shangliwei.phoenix.dao.impl.DictionaryDaoImpl;
import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.domain.transform.IDictionaryTransform;
import com.shangliwei.phoenix.domain.transform.impl.DictionaryTransformImpl;
import com.shangliwei.phoenix.domain.vo.DictionaryDetailVo;
import com.shangliwei.phoenix.domain.vo.DictionaryListVo;
import com.shangliwei.phoenix.service.IDictionaryService;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.LogUtil;
import com.shangliwei.phoenix.util.Pagination;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DictionaryServiceImpl implements IDictionaryService {

	private Connection connection;
	private IDictionaryDao dao = new DictionaryDaoImpl();
	private IDictionaryTransform transform = new DictionaryTransformImpl();
	
	@Override
	public void add(DictionaryDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		DictionaryPo po = new DictionaryPo();
		po.setId(SequenceUtil.getUUID());
		po.setCode(vo.getCode());
		po.setName(vo.getName());
		po.setType(vo.getType());
		po.setSort(Integer.valueOf(vo.getSort()));
		po.setEffective(vo.getEffective());
		po.setDescription(vo.getDescription());
		po.setCreater(currendEmployeeId);
		po.setCreattime(DateTimeUtil.getTimestamp());
		dao.add(po, connection);
	}

	@Override
	public void update(DictionaryDetailVo vo, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		DictionaryPo po = new DictionaryPo();
		po.setId(vo.getId());
		po.setCode(vo.getCode());
		po.setName(vo.getName());
		po.setType(vo.getType());
		po.setSort(Integer.valueOf(vo.getSort()));
		po.setEffective(vo.getEffective());
		po.setDescription(vo.getDescription());
		po.setEditer(currendEmployeeId);
		po.setEdittime(DateTimeUtil.getTimestamp());
		dao.update(po, connection);
	}

	@Override
	public void delete(String id, String currendEmployeeId) throws ClassNotFoundException, SQLException {
		dao.delete(id, connection);
	}

	@Override
	public DictionaryDetailVo queryDetail(String id) throws ClassNotFoundException, SQLException {
		DictionaryDetailVo vo = null;
		DictionaryPo po = dao.query(id, connection);
		if (po != null) {
			vo = (DictionaryDetailVo) transform.toDetailVo(po, connection);
		}
		return vo;
	}

	@Override
	public List<DictionaryListVo> queryList(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		List<DictionaryListVo> voList = null;
		List<DictionaryPo> poList = dao.query(condition, pagination, connection);
		if (poList != null && !"".equals(poList)) {
			voList = new ArrayList<>();
			for (DictionaryPo po : poList) {
				voList.add((DictionaryListVo) transform.toListVo(po, connection));
			}
		}
		return voList;
	}

	@Override
	public List<DictionaryPo> queryPop(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException {
		String message = "Un imploment interface method:" + Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
		LogUtil.print(message, LogUtil.LEVEL_ERROR, LogConstant.DEVELOP_MODE);
		throw new RuntimeException(message);
	}

}
