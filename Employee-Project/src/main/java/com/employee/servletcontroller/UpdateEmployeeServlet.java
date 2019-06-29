package com.employee.servletcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeBean;
import com.employee.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		int intid=Integer.parseInt(id);
		String name=req.getParameter("name");
		String  age=req.getParameter("age");
		int intage=Integer.parseInt(age);
		String gender=req.getParameter("gender");
		
		EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
		EmployeeBean employeeBean=new EmployeeBean(intid, name, intage, gender);
		
		employeeServiceImpl.updateEmployee(employeeBean);   
		
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		pw.println("<center>");
		pw.println("<h1>Employee Details</h1>");
		pw.println("<br>");
		
		pw.println("Name="+name);
		pw.println("<br>");
		
		pw.println("Age="+age);
		pw.println("<br>");
		
		pw.println("Gender="+gender);
		pw.println("<br>");
		pw.println("</center>");
		
		pw.println("</body></html>");
		pw.close();
			
	
	
	}
	

}
