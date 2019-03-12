package history;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upControl
 */
@WebServlet("/upControl")
public class upControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String Name=request.getParameter("name");
		String place=request.getParameter("place");
		String Popularity=request.getParameter("popularity");
		String Location=request.getParameter("Location");
		String AboutPlace=request.getParameter("AboutPlace");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.print/*("<html><body>"
				+ "<h1>"+Name+"</h1>"
				+ "<form action='upControl' method='post'>"
				+ "<h1> Update History ....</h1>"
				+ "<table >"
				+ "<tr><td>Name</td><td><input type='text'value='"+Name+"' name='Name'></td></tr>"
				+ "<tr><td>Place</td><td><input type='date' value='"+place+"' name='Place'></td></tr>"
				+ "<tr><td>Popularity</td><td><input type='text' value='"+Popularity+"' name='Popularity'></td></tr>"
				+ "<tr><td>Location</td><td><input type='text' value='"+Location+"' name='Location'></td></tr>"
				+ "<tr><td>AboutPlace</td><td><input type='text' value='"+AboutPlace+"' name='AboutPlace'></td></tr>"
				+ "<tr><td></td><td><input type='submit' value='UPDATE'></td></tr>"

				+ "</table>"
				+ "<input type='hidden' value='"+Name+"' name='Name'>"
				
				+ "</form>"
				+ "</body></html>");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Name=request.getParameter("Name");
		String place=request.getParameter("place");
		String Popularity=request.getParameter("Popularity");
		String Location=request.getParameter("Location");
		String AboutPlace=request.getParameter("AboutPlace");
		User s=new User();
		s.setName(place);
		s.setPopularity(Popularity);
		s.setPlace(Name);
		s.setLocation(Location);
		s.setAboutplace(AboutPlace);
		DBlogic.updateUser(s);
		response.sendRedirect("historical.jsp");

	}

}
