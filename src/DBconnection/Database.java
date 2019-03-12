package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static Connection con=null;
	
	public static void  connect()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Loaded driver");
	   con = DriverManager.getConnection("jdbc:mysql://localhost/citylife", "root", "ibm");
	         System.out.println("Database connected...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static
	{
		connect();
	}
	
	public static Connection getConnection()
	{
		return con;
	}
	
	public static void main(String a[]) {
		
	}
}
