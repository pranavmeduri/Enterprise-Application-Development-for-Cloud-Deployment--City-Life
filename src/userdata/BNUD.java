package userdata;

import hospital.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import DBconnection.Database;

public class BNUD  extends Database{
 
	public static Hospital getHospitalr(String id)
	{
		try
		{
			Hospital user=new Hospital();

			Statement smt=Database.getConnection().createStatement();
			ResultSet rs=smt.executeQuery("Select * from hospital where id='"+id+"'");
			if(rs.next())
			{
				user.setHospitalname(rs.getString(2));
				user.setCategory(rs.getString(3));
				user.setSpeciality(rs.getString(4));
				user.setLocation(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setId(id);
			
				System.out.println("records present");
				return user;


			}
			else
			{
				System.out.println("records Not prasent");
				return null;


			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
		
	}

	
	public static Vector<Hospital> getAllHospital()
	{
		try
		{
			Vector<Hospital> data1=new Vector<Hospital>();
				Statement smt=Database.getConnection().createStatement();
				ResultSet rs=smt.executeQuery("select * from hospital");
				
				while(rs.next())
				{
			     
					Hospital u=new Hospital();
					u.setId(Integer.toString(rs.getInt(1)));
					u.setSpeciality(rs.getString(4));
					u.setLocation(rs.getString(5));
					u.setCategory(rs.getString(3));
					
					
					u.setAddress(rs.getString(6));
					u.setHospitalname(rs.getString(2));
					
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
	
	public static void delUser(String id){
	try
	{
		
	
		String query=" Delete from hospital where id='"+id+"'";
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
		
	}
	
	catch(Exception e)
	{
	e.printStackTrace();	
	}
	}
	
	public static boolean checkUser(String id,String pass,String type)
	{
		try
		
		{
			String q="select * from user where id='"+id+"' and password='"+pass+"' and type='"+type+"'";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(q);
				
			if(rs.next())
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static void updateHospitalr(Hospital h)
	{
		try
		{
		//	System.out.println(h.getHospitalname());
			String query="UPDATE `hospital` SET `hospital_name`='"+h.getHospitalname()+"', `category`='"+h.getCategory()+"', `speciality`='"+h.getSpeciality()+"', `location`='"+h.getLocation()+"', `address`='"+h.getAddress()+"' WHERE `id`='"+h.getId()+"'"; 
			
			PreparedStatement pst=Database.getConnection().prepareStatement(query);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static boolean addUser(User u )
	
	{
		try{
			
		String query="INSERT INTO `citylife`.`user` (`id`, `NAME`, `address`, `mobile`, `password`, `type`)"
				+ " VALUES ('"+u.getId()+"', '"+u.getName()+"', '"+u.getAddress()+"', '"+u.getMobile()+"', '"+u.getPassword()+"', '"+u.getType()+"')";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static Hospital getHospital(String n)
	{
		try
		{
			
			String q="select * from hospital where Hospital_name='"+n+"'";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(q);
			if(rs.next())
			{
				Hospital h=new Hospital();
				h.setHospitalname(rs.getString(2));
				h.setCategory(rs.getString(3));
				h.setSpeciality(rs.getString(4));
				h.setLocation(rs.getString(5));
				h.setAddress(rs.getString(6));
				h.setId(rs.getString(1));
				return h;
			}
			else {
				return null;
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	

	

			

		}
		
	public String getPassword(String email)
	{
		try
		{
			
			String q="select * from user where id='"+email+"'";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(q);
			if(rs.next())
			{
				
				return rs.getString(5);
			}
			else {
				return "";
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}


	}

}
