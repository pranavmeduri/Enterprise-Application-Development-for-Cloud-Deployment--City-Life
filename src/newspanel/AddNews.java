package newspanel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNewsSatya")
public class AddNews extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String Title=request.getParameter("t");
		String Headline=request.getParameter("h");
		String Description=request.getParameter("d");
		String Day=request.getParameter("day");
		String Month=request.getParameter("m");
		String Time=request.getParameter("t");
		String ExternalResources=request.getParameter("ex");
		String State=request.getParameter("s");
		String City=request.getParameter("c");
	
		
		
		News user=new News();
		
		
	//	user.setId(Id);
		user.setTitle(Title);
		user.setHeadline(Headline);
		user.setDescription(Description);
		user.setDay(Day);
		user.setMonth(Month);
		user.setTime(Time);
		user.setExtr(ExternalResources);
		user.setState(State);
		user.setCity(City);
		
		
		if(NewsLogic.addNews(user))
		{
			response.sendRedirect("NewsPanelSatya.jsp");

		}
		

		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
