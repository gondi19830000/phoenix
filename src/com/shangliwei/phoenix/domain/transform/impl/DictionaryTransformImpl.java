package com.shangliwei.phoenix.domain.transform.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.constant.LogConstant;
import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.domain.transform.IDictionaryTransform;
import com.shangliwei.phoenix.domain.vo.DictionaryDetailVo;
import com.shangliwei.phoenix.domain.vo.DictionaryListVo;
import com.shangliwei.phoenix.util.CacheUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.LogUtil;

public class DictionaryTransformImpl implements IDictionaryTransform {

	@Override
	public Object toBo(DictionaryPo po, Connection connection) throws SQLException {
		String message = "Un imploment interface method:" + Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
		LogUtil.print(message, LogUtil.LEVEL_ERROR, LogConstant.DEVELOP_MODE);
		throw new RuntimeException(message);
	}

	@Override
	public Object toDetailVo(DictionaryPo po, Connection connection) throws SQLException {
		DictionaryDetailVo vo = new DictionaryDetailVo();
		vo.setId(po.getId());
		vo.setCode(po.getCode());
		vo.setName(po.getName());
		vo.setType(po.getType());
		vo.setSort(String.valueOf(po.getSort()));
		vo.setEffective(po.getEffective());
		vo.setDescription(po.getDescription());
		vo.setCreater(po.getCreater());
		vo.setEditer(po.getEditer());
		vo.setEffectiveName(CacheUtil.getDictionaryName(po.getEffective(), "DICTIONRY_EFFECTIVENAME", connection));
		vo.setCreaterUsername(CacheUtil.getUsername(po.getCreater(), connection));
		vo.setEditerUsername(CacheUtil.getUsername(po.getEditer(), connection));
		vo.setCreattimeCN(DateTimeUtil.format(po.getCreattime()));
		vo.setEdittimeCN(DateTimeUtil.format(po.getEdittime()));
		return vo;
	}

	@Override
	public Object toListVo(DictionaryPo po, Connection connection) throws SQLException {
		DictionaryListVo vo = new DictionaryListVo();
		vo.setId(po.getId());
		vo.setCode(po.getCode());
		vo.setName(po.getName());
		vo.setType(po.getType());
		vo.setSort(String.valueOf(po.getSort()));
		vo.setEffective(po.getEffective());
		vo.setEffectiveName(CacheUtil.getDictionaryName(po.getEffective(), "DICTIONRY_EFFECTIVENAME", connection));
		return vo;
	}

	@Override
	public Object toPopVo(DictionaryPo po, Connection connection) {
		String message = "Un imploment interface method:" + Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
		LogUtil.print(message, LogUtil.LEVEL_ERROR, LogConstant.DEVELOP_MODE);
		throw new RuntimeException(message);
	}

}
