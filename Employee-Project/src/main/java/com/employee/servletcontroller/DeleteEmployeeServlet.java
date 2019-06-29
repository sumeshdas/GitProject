package com.employee.servletcontroller;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.employee.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
public class DeleteEmployeeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		int employeeid=Integer.parseInt(id);
		EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
		employeeServiceImpl.deleteEmployeeById(employeeid);
		
		RequestDispatcher rd=req.getRequestDispatcher("getallemployeeservlet");
		rd.forward(req, res);
		
	}

}
