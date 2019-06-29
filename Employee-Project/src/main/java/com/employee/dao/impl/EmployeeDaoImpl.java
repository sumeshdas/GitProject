package com.employee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.employee.dao.EmployeeDao;
import com.employee.entity.EmployeeEntity;
import com.employee.util.DatabaseConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public void createEmployee(EmployeeEntity employeeEntity) {

		Connection conn=null;
		Statement stm=null;
		try
		{
			conn=DatabaseConnection.getMySqlConnection();
			stm=conn.createStatement();
			String name=employeeEntity.getName();
			int id=employeeEntity.getId();
			String gender=employeeEntity.getGender();
			int age=employeeEntity.getAge();

			String sql = "INSERT INTO employee(name,age,gender) values('"+name+"',"+age+", '"+gender+"')";

		boolean isinserted=	stm.execute(sql);
		System.out.println(isinserted);
		}catch (SQLException e ) {
			e.printStackTrace();
			
		
		}
			
		
		
		
	}

	public ArrayList<EmployeeEntity> getAllEmployee() {

		Connection conn=null;
		Statement stm=null;
		EmployeeEntity employeeEntity=null;
		ArrayList<EmployeeEntity> employeeList=new ArrayList<EmployeeEntity>();
		try
		{
			conn=DatabaseConnection.getMySqlConnection();
			stm=conn.createStatement();
			
			//SELECT * FROM employee WHERE id=1;
			String sql="SELECT * FROM employee";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
				{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String gender=rs.getString(4);
				employeeEntity=new EmployeeEntity(id, name, age ,gender);
				employeeList.add(employeeEntity);
				}
			
		
		}catch (SQLException e ) {
			e.printStackTrace();
			
		
		}
		
		return employeeList;
	}

	public void deleteEmployee(int employeeid) {


		
		
		Connection conn=null;
		Statement stm=null;
		try
		{
			conn=DatabaseConnection.getMySqlConnection();
			stm=conn.createStatement();
			
			String sql="DELETE From employee where id="+employeeid;
		boolean isdeleted=	stm.execute(sql);
		System.out.println(isdeleted);
		}catch (SQLException e ) {
			e.printStackTrace();
			
		
		}
		
	}

	public EmployeeEntity getEmployeeById(int employeeid) {

		Connection conn=null;
		Statement stm=null;
		EmployeeEntity employeeEntity=null;
		try
		{
			conn=DatabaseConnection.getMySqlConnection();
			stm=conn.createStatement();
			
			//SELECT * FROM employee WHERE id=1;
			String sql="SELECT * FROM employee WHERE id="+employeeid;
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
				{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String gender=rs.getString(4);
				employeeEntity=new EmployeeEntity(id, name, age,gender);
				}
			
		
		}catch (SQLException e ) {
			e.printStackTrace();
			
		
		}
		
		return employeeEntity;
	

	}

	public void updateEmployee(EmployeeEntity employeeEntity) {


		Connection conn=null;
		Statement stm=null;
		try
		{
			conn=DatabaseConnection.getMySqlConnection();
			stm=conn.createStatement();
			String name=employeeEntity.getName();
			int id=employeeEntity.getId();
			int age=employeeEntity.getAge();
			String gender=employeeEntity.getGender();
			String sql="UPDATE employee SET name=' "+name+"' ,age="+age+",gender='"+gender+"' WHERE id="+id;
		boolean isupdated=	stm.execute(sql);
		System.out.println(isupdated);
		}catch (SQLException e ) {
			e.printStackTrace();
			
		
		}
			
		
	
	}
}
