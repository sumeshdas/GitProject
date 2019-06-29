package com.employee.dao;

import java.util.ArrayList;
import com.employee.entity.EmployeeEntity;


public interface EmployeeDao {
	public void createEmployee(EmployeeEntity employeeEntity);
	public abstract ArrayList<EmployeeEntity> getAllEmployee();
	public abstract void deleteEmployee(int employeeid);
	public abstract EmployeeEntity getEmployeeById(int employeeid);
	public abstract void updateEmployee(EmployeeEntity employeeEntity);
}
