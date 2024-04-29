package Controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CourseDAO;
import DAO.StudentDAO;
import DTO.CourseResponseDTO;

@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CourseDAO dao = new CourseDAO();
		StudentDAO sdao = new StudentDAO();
		ArrayList<CourseResponseDTO> list = dao.ShowCourse();
		session.setAttribute("course", list);
		String stu_id = sdao.generateCusId();
		System.out.println(stu_id);
		session.setAttribute("id", stu_id);
		
		request.getRequestDispatcher("STU001.jsp").forward(request, response);
	}
}
