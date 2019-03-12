package hospital;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    //String name=request.getParameter("sen");
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
 	 Connection  mycon = DriverManager.getConnection("jdbc:mysql://localhost/citylife", "root", "java");
    
    System.out.println("Database connected");
    
    Statement smt=mycon.createStatement();
    
    ResultSet rs=smt.executeQuery("select * from hospital where hospital_name like 'Bhagat%'");
    
    while(rs.next())
    {
    	
    	
    	System.out.println(rs.getString(2));
    	System.out.println(rs.getString(3));
    	System.out.println(rs.getString(4));
    	System.out.println(rs.getString(5));
    	System.out.println(rs.getString(6));
    }
    
    }
 
 catch(Exception e)
    {
	 e.printStackTrace();
    }
	}
}
    
    
		
	


