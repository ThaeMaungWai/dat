package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDAO;
import DAO.UserDAO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setId(request.getParameter("id"));
		StudentDAO dao = new StudentDAO();
		int i = dao.DeleteStu(dto);
		if(i < 0) {
			request.setAttribute("error", "Delete Failed!!");
		}
		else {
			request.setAttribute("msg", "Delete Successful!!");
			List<StudentResponseDTO> list = dao.ShowStu();
			session.setAttribute("list", list);
		}
		request.getRequestDispatcher("STU003.jsp").forward(request, response);
	}

}


