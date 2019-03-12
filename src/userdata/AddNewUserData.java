package userdata;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewUserData
 */
@WebServlet("/AddNewUserData")
public class AddNewUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setAddress(address);
		u.setMobile(mobile);
		u.setPassword(password);
		u.setType(type);
		
		if(BNUD.addUser(u))
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			doGet(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs=request.getRequestDispatcher("signup.jsp");
	request.setAttribute("err", "this user allready registered");
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
