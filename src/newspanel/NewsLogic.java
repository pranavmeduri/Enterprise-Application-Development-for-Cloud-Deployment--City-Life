package newspanel;

import java.sql.*;
import java.util.Vector;




public class NewsLogic

{
	
	


	private static final Connection con = null;


	public static Vector<News> getAllNews()
	{
		try
		{
			Vector<News> data=new Vector<News>();
			
			
			Statement smt=DBConnection.getConnetion().createStatement();
			ResultSet rs=smt.executeQuery("Select * from news");
			while(rs.next())
			{
				News n=new News();
				n.setId(rs.getString(1));
				n.setTitle(rs.getString(2));
				n.setHeadline(rs.getString(3));
				n.setDes(rs.getString(4));
				
				n.setDay(rs.getString(5));
				n.setMonth(rs.getString(6));
				n.setTime(rs.getString(7));
				n.setExtr(rs.getString(8));
				n.setState(rs.getString(9));
				n.setCity(rs.getString(10));
				
				
				
				
				data.add(n);	
				
			}
			return data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
		
	}
	
	
	public static boolean addNews(News n)
	{
		try
		{
		

			String sql="INSERT INTO `citylife`.`news` (`Title`, `Headlines`, `Description`, ` day`, `month`, ` time`, ` Externalresources`, ` state`, ` city`) VALUES "
					+ "('"+n.getTitle()+"', '"+n.getHeadline()+"', '"+n.getDes()+"', '"+n.getDay()+"', '"+n.getMonth()+"', '"+n.getTime()+"', '"+n.getExtr()+"', '"+n.getState()+"', '"+n.getCity()+"')";
			
			
			PreparedStatement pst=DBConnection.getConnetion().prepareStatement(sql);
			pst.executeUpdate();
			return true;
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false; 
		}
		
	}
	
	public static boolean deleteNews(String id )
	{
		try
		{
		

			
		String query="Delete from news where id='"+id+"'";
		
			
			PreparedStatement pst=DBConnection.getConnetion().prepareStatement(query);
			pst.executeUpdate();
			return true;
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false; 
		}
		
	}
	
	public static void updateNews(News news)
	{
		try
		{
			if(con.isClosed())
				coonect();
			
String query="UPDATE `citylife` SET `id`='"+news.getId()
+"', `title`='"+news.getTitle()
+"', `headline`='"+news.getHeadline()
+"', `description`='"+news.getDes()
+"', `day`='"+news.getDay()
+"', `month`='"+news.getMonth()
+"', `time`='"+news.getTime()
+"', `externalresources`='"+news.getExtr()
+"', `state`='"+news.getState()
+"', `city`='"+news.getCity()

+"' WHERE `id`='"+news.getId()+"'";

	PreparedStatement pst=con.prepareStatement(query);
	pst.executeUpdate();
}
catch(Exception e)
{
	e.printStackTrace();
}
}


	private static void coonect() {
		// TODO Auto-generated method stub
		
	}
}
	
	
	

