package history;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;








public class DBlogic {
	private static final history.User User = null;
	static Connection con=null;
	public static String userName="";
	
	static void  coonect()
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
		coonect();
	

	}




public static Vector<User> getAllUser(String loc)
	{
	
		 Vector<User> data=new Vector<User>();
		try
		{
			  Statement smt=con.createStatement();
		         ResultSet rs=smt.executeQuery("select * from delhiplaces where place='"+loc+"'");
		         while(rs.next())
		         {
		        	User u=new User();
		          	u.setName(rs.getString(1));
		        	u.setLocation(rs.getString(2));
		      
		        	u.setPlace(rs.getString(3));
		        	u.setPopularity(rs.getString(4));
		        	u.setAboutplace(rs.getString(5));
		        	;
		        	data.add(u);
		         }
		         return data;
		     
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;

		}
	}
public static HashSet<String > getAllPlaceName()
{
	try
	{
		HashSet<String>	data=new HashSet<String>();
		  Statement smt=con.createStatement();
	         ResultSet rs=smt.executeQuery("select * from delhiplaces ");
	         while(rs.next())
	         {
	        	 data.add(rs.getString(1));
	         }
	         return data;
	         }
	catch (Exception e) {
e.printStackTrace();
}
	return null;

}

public static void updateUser(User s)
{
	try
	{
		if(con.isClosed())
			coonect();
		
		String query="UPDATE `history`.`delhiplaces` SET `place`='"+s.getName()
				+"', `Location`='"+s.getLocation()
				+"', `name`='"+s.getPlace()
				+"', `popularity`='"+s.getPopularity()
				+"', `AboutPlace`='"+s.getAboutplace()
				+"' WHERE `place`='"+s.getName()+"'";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

//}

}
public static boolean addhistoryInfo(User u)
{
	try
	{
		if(con.isClosed())
			coonect();
		String sql="INSERT INTO `history`.`delhiplaces` (`Name`, `Location`, `Place`, `Popularity`, `AboutPlace`)"
				+ " VALUES ('"+u.getPlace()+
				"', '"+u.getLocation()
				+"', '"+u.getName()
				+"', '"+u.getPopularity()
				+"', '"+u.getAboutplace()+"')";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.executeUpdate();
		return true;
				
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false; 
	}
	
}
public	static boolean checkUser(String id,String pass)
{
	try
	{
		if(con.isClosed())
			coonect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from login where id='"+id+"' and password='"+pass+"'");
		if(rs.next())
		{
			userName=rs.getString(3);
			return true;
		}
		
		else
		{
			return false;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;

	}
	
}
}



