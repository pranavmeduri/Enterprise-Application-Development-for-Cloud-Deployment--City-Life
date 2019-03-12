package hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/updateHospital")
public class updateHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("n");
		String category=request.getParameter("c");
		String speciality=request.getParameter("s");
		String location=request.getParameter("l");
		String address=request.getParameter("a");
		
		
		
		Hospital h=new Hospital();
		h.setId(id);
		h.setHospitalname(name);
		h.setCategory(category);
		h.setSpeciality(speciality);
		h.setLocation(location);
		h.setAddress(address);
		
		HospitalDBLogic.updateHospitalr(h);
		response.sendRedirect("AdminHospitalPanel.jsp");
		
				
	}
}
