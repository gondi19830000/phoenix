package com.shangliwei.phoenix.servlet.impl;

import com.shangliwei.phoenix.servlet.IOperationServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserOperationServletImpl
 */
@WebServlet("/UserOperationServletImpl")
public class EmployeeOperationServletImpl extends HttpServlet implements IOperationServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOperationServletImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @see IOperationServlet#doQueryDetail(HttpServletRequest, HttpServletResponse)
     */
    public void doQueryDetail(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IOperationServlet#doAdd(HttpServletRequest, HttpServletResponse)
     */
    public void doAdd(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IOperationServlet#doUpdate(HttpServletRequest, HttpServletResponse)
     */
    public void doUpdate(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IOperationServlet#doQueryPop(HttpServletRequest, HttpServletResponse)
     */
    public void doQueryPop(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IOperationServlet#doQueryList(HttpServletRequest, HttpServletResponse)
     */
    public void doQueryList(HttpServletRequest request, HttpServletResponse response)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see IOperationServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    public void doDelete(HttpServletRequest request, HttpServletResponse response)  { 
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
