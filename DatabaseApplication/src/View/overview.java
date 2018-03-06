package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Database.DatabaseManager;
import Model.EmployeeTableModel;
import Model.Employees;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class overview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollBar scrollBar;
	private Employees employeeMethods;
	

	/**
	 * Create the frame.
	 */
	public overview() {
		employeeMethods = new Employees();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 838, 352);
		contentPane.add(scrollPane);
		
	}
	
	public void setzeAlleActionListener(ActionListener l)
	{

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
		//setzeAlleActionListener(this);
		
		this.setTableModel(employeeMethods.getEmployeTableModel());
		System.out.println("test");
		System.out.println("test");

		this.setVisible(true);
	}
}
