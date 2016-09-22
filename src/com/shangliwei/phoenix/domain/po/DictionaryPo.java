package com.shangliwei.phoenix.domain.po;

import java.sql.Timestamp;

public class DictionaryPo {

	private String id;
	private String code;
	private String name;
	private String type;
	private int sort;
	private String effective;
	private String description;

	private String creater;
	private Timestamp creattime;
	private String editer;
	private Timestamp edittime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getCreattime() {
		return creattime;
	}

	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}

	public String getEditer() {
		return editer;
	}

	public void setEditer(String editer) {
		this.editer = editer;
	}

	public Timestamp getEdittime() {
		return edittime;
	}

	public void setEdittime(Timestamp edittime) {
		this.edittime = edittime;
	}

}
