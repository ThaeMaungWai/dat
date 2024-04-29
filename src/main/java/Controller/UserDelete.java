package Controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		int i = dao.deleteUser(dto);
		if(i < 0) {
			request.setAttribute("error", "Delete Failed!!");
		}
		else {
			request.setAttribute("msg", "Delete Successful!!");
			ArrayList<UserResponseDTO> list = dao.ShowAllResult();
			session.setAttribute("list", list);
		}
		request.getRequestDispatcher("USR003.jsp").forward(request, response);
	} 
}
