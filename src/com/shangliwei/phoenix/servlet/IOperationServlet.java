package com.shangliwei.phoenix.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IOperationServlet {

	public void doAdd(HttpServletRequest request, HttpServletResponse response);
	public void doUpdate(HttpServletRequest request, HttpServletResponse response);
	public void doDelete(HttpServletRequest request, HttpServletResponse response);
	public void doQueryDetail(HttpServletRequest request, HttpServletResponse response);
	public void doQueryList(HttpServletRequest request, HttpServletResponse response);
	public void doQueryPop(HttpServletRequest request, HttpServletResponse response);
}
