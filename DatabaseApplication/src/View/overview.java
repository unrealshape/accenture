package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Database.DatabaseManager;
import Model.EmployeeTableModel;
import Model.Employees;

public class overview extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JScrollBar scrollBar;
	private Employees employeeMethods;
	private JButton btnAddNewEmployee;
	private JButton btnEditEmployee;
	private JButton btnDeleteEmploye;
	private JButton btnClose;
	private JButton btnGroups;
	

	/**
	 * Create the frame.
	 */
	public overview() {
		setTitle("JumpStart Employee Register");
		employeeMethods = new Employees();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 848, 352);
		contentPane.add(scrollPane);
		
		btnAddNewEmployee = new JButton("Add new employee");
		btnAddNewEmployee.setBounds(121, 369, 147, 23);
		contentPane.add(btnAddNewEmployee);
		
		btnEditEmployee = new JButton("Edit employee");
		btnEditEmployee.setBounds(278, 369, 130, 23);
		contentPane.add(btnEditEmployee);
		
		btnDeleteEmploye = new JButton("Delete Employe");
		btnDeleteEmploye.setBounds(418, 369, 130, 23);
		contentPane.add(btnDeleteEmploye);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClose.setBounds(558, 369, 130, 23);
		contentPane.add(btnClose);
		
		btnGroups = new JButton("Groups");
		btnGroups.setBounds(121, 403, 147, 23);
		contentPane.add(btnGroups);
		
	}
	
	public void setzeAlleActionListener(ActionListener l)
	{
		btnClose.addActionListener(l);
		btnAddNewEmployee.addActionListener(l);
		btnDeleteEmploye.addActionListener(l);
		btnEditEmployee.addActionListener(l);
		btnGroups.addActionListener(l);
	}
	
	public void setTableModel(EmployeeTableModel employeTM) {
		this.table.setModel(employeTM);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}
	
	
	public void openWindow() {
		try
		{
			DatabaseManager.verbinden();
		}
		catch(Exception e)
		{
			System.err.println("DB Fehlgeschalgen " + e);
		}
		
		try
		{
			employeeMethods.loadEmployees();			
		}
		catch(SQLException e)
		{
			System.err.println("Employeee Daten runterladen Fehlgeshlagen " + e);
		}
		setzeAlleActionListener(this);
		
		this.setTableModel(employeeMethods.getEmployeTableModel());
		this.setVisible(true);
	}
	//Mouse Interacts
	public JButton getBtnClose()
	{
		return btnClose;
	}
	public JButton getBtnAddNew()
	{
		return btnAddNewEmployee;
	}
	public JButton getBtnEdit()
	{
		return btnEditEmployee;
	}
	public JButton getBtnDelete()
	{
		return btnDeleteEmploye;
	}
	public JButton getBtnGroups()
	{
		return btnGroups;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnAddNew())
		{
			System.out.println("addnew");
		}
		else if(e.getSource() == getBtnClose())
		{
			System.out.println("close");
		}
		else if(e.getSource() == getBtnDelete())
		{
			System.out.println("delete");
		}
		else if(e.getSource() == getBtnEdit())
		{
			System.out.println("edit");
		}
		else if(e.getSource() == getBtnGroups())
		{
			System.out.println("groups");
		}
		
	}
}
