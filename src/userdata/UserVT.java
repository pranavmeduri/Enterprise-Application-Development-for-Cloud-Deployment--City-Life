package userdata;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserVT
 */
@WebServlet("/UserVT")
public class UserVT extends HttpServlet {

	   
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String type=request.getParameter("type");
		
		if(BNUD.checkUser(id,pass,type))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("id", id);
			session.setAttribute("type", type);
			System.out.println(id+pass+type);
			if(type.equalsIgnoreCase("admin"))
			{
				response.sendRedirect("DashBoardA.jsp");

			}
			if(type.equalsIgnoreCase("member"))
			{
				response.sendRedirect("DashBoardM.jsp");

			}
			if(type.equalsIgnoreCase("advertiser"))
			{
				response.sendRedirect("DashBoardAD.jsp");

			}
			
		}
		else
		{
			doGet(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
		request.setAttribute("err", "Enter Correct ID or Password");
		rs.forward(request	, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		process(request, response);
	}


}
