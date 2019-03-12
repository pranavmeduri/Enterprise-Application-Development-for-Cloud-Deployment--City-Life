	package newspanel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateNewsSatya")
public class UpdateNews extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Id=request.getParameter("Id");
		String Title=request.getParameter("Title");
		String Headline=request.getParameter("Headlines");
		String Description=request.getParameter("Description");
		String Day=request.getParameter("Day");
		String Month=request.getParameter("Month");
		String Time=request.getParameter("Time");
		String ExternalResources=request.getParameter("Extr");
		String State=request.getParameter("State");
		String City=request.getParameter("City");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html><body>"
				+ "<h1>"+Id+"</h1>"
				+ "<form action='upNews' method='post'>"
				+ "<h1> Update Information ....</h1>"
				+ "<table >"
				+ "<tr><td>Id</td><td><input type='text'value='"+Id+"' name='id'></td></tr>"
				+ "<tr><td>Title</td><td><input type='date' value='"+Title+"' name='title'></td></tr>"
				+ "<tr><td>Headline</td><td><input type='text' value='"+Headline+"' name='headline'></td></tr>"
				+ "<tr><td>Description</td><td><input type='text' value='"+Description+"' name='description'></td></tr>"
				+ "<tr><td>Day</td><td><input type='text' value='"+Day+"' name='day'></td></tr>"
				+ "<tr><td>Month</td><td><input type='text' value='"+Month+"' name='month'></td></tr>"
				+ "<tr><td>Time</td><td><input type='text' value='"+Time+"' name='time'></td></tr>"
				+ "<tr><td>ExternalResources</td><td><input type='text' value='"+ExternalResources+"' name='externalresources'></td></tr>"
				+ "<tr><td>State</td><td><input type='text' value='"+State+"' name='state'></td></tr>"
				+ "<tr><td>City</td><td><input type='text' value='"+City+"' name='city'></td></tr>"
					+ "<tr><td></td><td><input type='submit' value='UPDATE'></td></tr>"

				+ "</table>"
				+ "<input type='hidden' value='"+Id+"' name='id'>"
				
				+ "</form>"
				+ "</body></html>");
	}
		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			
			String Id=request.getParameter("id");
			String Title=request.getParameter("title");
			String headline=request.getParameter("headline");
			String description=request.getParameter("des");
			String day=request.getParameter("day");
			String month=request.getParameter("month");		
			String time=request.getParameter("time");		
			String externalresources=request.getParameter("extr");		
			String state=request.getParameter("state");
			String city=request.getParameter("city");
			News n=new News();
			n.setId(Id);
			n.setTitle(Title);
			n.setHeadline(headline);
			n.setDescription(description);
			n.setDay(day);
			n.setMonth(month);
			n.setTime(time);
			n.setExtr(externalresources);
			n.setState(state);
			n.setCity(city);
			
			DBConnection.updateNews(n);
			response.sendRedirect("Welcome.java");
		}

			
		
	}


