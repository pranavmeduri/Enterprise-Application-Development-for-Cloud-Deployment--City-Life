package newspanel;

import java.sql.*;


public class DBConnection {
	
	private static Connection con;
	
public static void  connect()
{
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Loaded driver");
 	   con = DriverManager.getConnection("jdbc:mysql://localhost/citylife", "root", "java");
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

public static  Connection getConnetion()
{
	return con;
}

public static void updateNews(News n) {
	// TODO Auto-generated method stub
	
}


}
