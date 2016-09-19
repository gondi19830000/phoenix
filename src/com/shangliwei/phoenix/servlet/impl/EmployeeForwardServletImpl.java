package com.shangliwei.phoenix.servlet.impl;

import com.shangliwei.phoenix.servlet.IForwardServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserForwardServletImpl
 */
@WebServlet("/UserForwardServletImpl")
public class EmployeeForwardServletImpl extends HttpServlet implements IForwardServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeForwardServletImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @see IForwardServlet#toPop(HttpServletRequest, HttpServletResponse)
     */
    public void toPop(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IForwardServlet#toInfo(HttpServletRequest, HttpServletResponse)
     */
    public void toInfo(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IForwardServlet#toList(HttpServletRequest, HttpServletResponse)
     */
    public void toList(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
