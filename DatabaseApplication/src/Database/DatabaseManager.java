package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Employee;
public class DatabaseManager {


	
    private final static String dbserver = "localhost";
    private final static int dbport = 3306;
    private final static String dbname = "mydb";
    private final static String dbuser = "root";
    private final static String dbpass ="google123";
    private final static String url = "jdbc:mysql://" + dbserver + ":" + dbport + "/" + dbname + "?useSSL=false";
    private static String query = "";
    private static DatabaseManager instance = null;
    private static Connection con = null;
    public DatabaseManager()
    {
    	
    }
    public static DatabaseManager getInstance()
    {
    	return instance;
    }
    private void verbinden(String url,String dbuser,String dbpass,String treiber)throws Exception
    {
        Class.forName(treiber);
        this.con = DriverManager.getConnection(url, dbuser, dbpass);    
    }   
    public static void verbinden() throws Exception
    {
        instance = new DatabaseManager();
        instance.verbinden(url,dbuser,dbpass,"org.gjt.mm.mysql.Driver");
        
    }
    public ResultSet ausfuehren(String query) throws SQLException 
    {
	PreparedStatement stmt = con.prepareStatement(query);
	stmt.execute();

	return stmt.getResultSet();
    }

    public ResultSet ausfuehren(PreparedStatement stmt) throws SQLException 
    {
	stmt.execute();

	return stmt.getResultSet();
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException
    {
    	ArrayList<Employee> arrayListEmployee = new ArrayList<>();
    	query = "SELECT employeeID, firstName, lastName, callNumber, group_groupID FROM employee";
    	ResultSet rs = ausfuehren(query);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String firstName = rs.getString(2);
    		String lastName = rs.getString(3);
    		String callNumber = rs.getString(4);
    		String group = getTitleName(rs.getInt(5));
    		arrayListEmployee.add(new Employee(id,firstName,lastName,callNumber,group));
    	}
		return arrayListEmployee;
    	
    }

   
    private String getTitleName(int idFromGroups) throws SQLException {
		String title = "";
		query = "SELECT title FROM mydb.group WHERE groupID='"+idFromGroups+"'";
		ResultSet rs = ausfuehren(query);
		if(rs.next())
		{
			title = rs.getString(1);
		}
		return title;
	}

}