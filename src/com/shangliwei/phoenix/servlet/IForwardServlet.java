package com.shangliwei.phoenix.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IForwardServlet {

	public void toInfo(HttpServletRequest request, HttpServletResponse response);
	public void toList(HttpServletRequest request, HttpServletResponse response);
	public void toPop(HttpServletRequest request, HttpServletResponse response);
}
