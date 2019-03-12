package cont;

import history.User;

import java.sql.PreparedStatement;

import DBconnection.Database;

public class SaveQdata extends Database {

	public static boolean addhistoryInfo(Query u)
	{
		try
		{
			
			String sql="INSERT INTO `citylife`.`query` (`name`, `email`, `sub`, `msg`) VALUES ('"+u.getName()+"', '"+u.getEmail()+"', '"+u.getSub()+"', '"+u.getMsg()+"')";
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

}
