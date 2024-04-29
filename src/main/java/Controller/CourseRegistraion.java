package Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CourseDAO;
import DTO.CourseRequestDTO;
import Model.CourseBean;

/**
 * Servlet implementation class CourseRegistraion
 */
@WebServlet("/CourseRegistraion")
public class CourseRegistraion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		CourseBean bean = new CourseBean();
		bean.setId(id);
		bean.setName(name);
		if(bean.getId() == "" || bean.getName() == "") {
			request.setAttribute("error", "Field cannot be blank!!");
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
		else {
			CourseRequestDTO dto = new CourseRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			CourseDAO dao = new CourseDAO();
			int i = dao.insertCourse(dto);
			if(i > 0) {
				request.setAttribute("msg", "Registration Successful.");
			}
			else {
				request.setAttribute("error", "Registration Failed!!");
			}
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
	}
	
}
