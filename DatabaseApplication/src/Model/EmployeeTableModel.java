package Model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class EmployeeTableModel implements TableModel {
	
	private ArrayList<Employee> employeeList;
	
	public EmployeeTableModel(ArrayList<Employee> employeeList)
	{
		this.employeeList = employeeList;
		
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
	return String.class;	
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			return "ID";
		case 1:
			return "FirstName";
		case 2:
			return "LastName";
		case 3:
			return "Group";
		case 4:
			return "CallNumber";
		}
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return employeeList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex == 0)
			return employeeList.get(rowIndex).getId();
		else if (columnIndex == 1)
			return employeeList.get(rowIndex).getFirstName();
		else if (columnIndex == 2)
			return employeeList.get(rowIndex).getLastName();
		else if (columnIndex == 3)
			return employeeList.get(rowIndex).getGroup();
		else if (columnIndex == 4)
			return employeeList.get(rowIndex).getCallNumber();
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
