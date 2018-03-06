package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.DatabaseManager;

public class Employees {
	
	private ArrayList<Employee> employeeList;
	
	public Employees()
	{
		employeeList = new ArrayList<>();
	}
	
	public EmployeeTableModel getEmployeTableModel()
	{
		return new EmployeeTableModel(employeeList);
	}
	
	public void loadEmployees() throws SQLException
	{
		employeeList = DatabaseManager.getInstance().getAllEmployees();
	}
	

}
