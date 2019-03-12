package history;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String Location=request.getParameter("L");
		String Place=request.getParameter("P");
		String Popularity=request.getParameter("Po");
		String AboutPlace=request.getParameter("Ab");
		User user=new User();
		user.setName(name);
		user.setLocation(Location);
		user.setPlace(Place);
		user.setPopularity(Popularity);
		user.setAboutplace(AboutPlace);
		
		
		if(DBlogic.addhistoryInfo(user))
		{
			response.sendRedirect("historical.jsp");

		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/historical.jsp");
			request.setAttribute("AddUser", "Id must be unique");
			rd.forward(request, response);
		}
		
	}

}
