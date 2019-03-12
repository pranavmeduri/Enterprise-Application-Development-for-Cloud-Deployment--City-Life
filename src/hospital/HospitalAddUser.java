package hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HospitalAddUser")
public class HospitalAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("n");
		String category=request.getParameter("c");
		String location=request.getParameter("l");
		String speciality=request.getParameter("s");
		String address=request.getParameter("a");
		
		
		
         Hospital h= new Hospital();
         h.setHospitalname(name);
         h.setAddress(address);
         h.setCategory(category);
         h.setLocation(location);
         h.setSpeciality(speciality);
         System.out.print(category);

         if(HospitalDBLogic.addHospital(h))
         {
        	 response.sendRedirect("AdminHospitalPanel.jsp");
        	 
         }

         else
         {
        	 response.sendRedirect("UserForm.html");
         }
	}

}
	
