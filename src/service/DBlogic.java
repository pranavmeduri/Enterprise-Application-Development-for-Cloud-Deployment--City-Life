package service;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Vector;

import DBconnection.Database;
public class DBlogic extends Database
{
	public static String userName="";
	
	
	
/*public	static boolean checkUser(String id,String pass)
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
		
	}  */


public static Vector<User> getAllUser(String loc)
{
	try
	{
		Vector<User> data=new Vector<User>();
		
		//if(con.isClosed())
			connect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from hospital where location='"+loc+"'");
		while(rs.next())
		{
			User user=new User();
			user.setHospitalname(rs.getString(2));
			user.setCategory(rs.getString(3));
			user.setSpeciality(rs.getString(4));
			user.setLocation(rs.getString(5));
			user.setAddress(rs.getString(6));
			
		
			
			data.add(user);	
			
		}
		return data;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;

	}
	
}


public static Vector<User> getHotD(String loc)
{
	try
	{
		Vector<User> data=new Vector<User>();
		
		//if(con.isClosed())
			connect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from hotel where name='"+loc+"'");
		while(rs.next())
		{
			User user=new User();
			user.setHospitalname(rs.getString(3));
			user.setCategory(rs.getString(4));
			user.setSpeciality(rs.getString(5));
			user.setLocation(rs.getString(6));
			user.setAddress(rs.getString(7));
			
		
			
			data.add(user);	
			
		}
		return data;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;

	}
	
}


public static Vector<User> getBusD(String SP,String EP)
{
	try
	{
		Vector<User> data=new Vector<User>();
		
		//if(con.isClosed())
			connect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from bus where SP='"+SP+"' and EP='"+EP+"'");
		while(rs.next())
		{
			User user=new User();
			user.setHospitalname(rs.getString(2));
			user.setCategory(rs.getString(3));
			user.setSpeciality(rs.getString(4));
			user.setLocation(rs.getString(5));
			user.setAddress(rs.getString(7));
			
		
			
			data.add(user);	
			
		}
		return data;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;

	}
	
}

public static Vector<User> getHistory(String loc)
{
	try
	{
		Vector<User> data=new Vector<User>();
		
		//if(con.isClosed())
			connect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from delhiPlaces where place='"+loc+"'");
		while(rs.next())
		{
			User user=new User();
			user.setHospitalname(rs.getString(2));
			user.setCategory(rs.getString(3));
			user.setSpeciality(rs.getString(4));
			user.setLocation(rs.getString(5));
			//user.setAddress(rs.getString(6));
			
		
			
			data.add(user);	
			
		}
		return data;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;

	}
	
}

public static Vector<User> getNews(String loc)
{
	try
	{
		Vector<User> data=new Vector<User>();
		
		//if(con.isClosed())
			connect();
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from news where title='"+loc+"'");
		while(rs.next())
		{
			User user=new User();
			user.setHospitalname(rs.getString(3));
			user.setCategory(rs.getString(4));
			user.setSpeciality(rs.getString(5));
			user.setLocation(rs.getString(6));
			user.setAddress(rs.getString(7));
			
		
			
			data.add(user);	
			
		}
		return data;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;

	}
	
}


public static HashSet<String> getAllPlace()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from hospital");
			
			while(rs.next())
			{
		     data1.add(rs.getString(5));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public static HashSet<String> getHotName()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from hotel");
			
			while(rs.next())
			{
		     data1.add(rs.getString(2));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}
public static HashSet<String> getEP()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from bus");
			
			while(rs.next())
			{
		     data1.add(rs.getString(4));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public static HashSet<String> getSP()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from bus");
			
			while(rs.next())
			{
		     data1.add(rs.getString(3));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public static HashSet<String> getAllHPlace()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from delhiplaces");
			
			while(rs.next())
			{
		     data1.add(rs.getString(1));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}


public static HashSet<String> getAllN()
{
	try
	{
		HashSet<String> data1=new HashSet<String>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from news");
			
			while(rs.next())
			{
		     data1.add(rs.getString(2));
		     
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public static Vector<User> getAllHotel()
{
	try
	{
		Vector<User> data1=new Vector<User>();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from hospital");
			
			while(rs.next())
			{
		     
				User u=new User();
				u.setAddress(rs.getString(2));
				
				data1.add(u);
			}
			return data1;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

/*public static void delUser(String id)
{
	try
	{
		if(con.isClosed())
			connect();
		String query="Delete from userdetails where id='"+id+"'";
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}*/

/*public static void updateUser(User user)
{
	try
	{
		if(con.isClosed())
			coonect();
		
		String query="UPDATE `wtl`.`userdetails` SET `id`='"+user.getId()
				+"', `name`='"+user.getName()
				+"', `DOB`='"+user.getDob()
				+"', `City`='"+user.getCity()
				+"', `Mobile`='"+user.getMobile()
				+"' WHERE `id`='"+user.getId()+"'";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static boolean addUserInfo(User u)
{
	try
	{
		if(con.isClosed())
			coonect();
		String sql="INSERT INTO `wtl`.`userdetails` (`id`, `name`, `DOB`, `City`, `Mobile`)"
				+ " VALUES ('"+u.getId()+
				"', '"+u.getName()
				+"', '"+u.getDob()
				+"', '"+u.getCity()
				+"', '"+u.getMobile()+"')";
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
*/

public static void main(String a[])
{connect();
	Vector<User> data =getAllUser(userName);
	Enumeration<User> ex=data.elements();
	while (ex.hasMoreElements()) {
		User user = (User) ex.nextElement();
		System.out.println("name "+user.getHospitalname());
		
	}}

}











