package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DTO.UserRequestDTO;
import Model.UserBean;

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPas(request.getParameter("pas"));
		bean.setC_pas(request.getParameter("c_pas"));
		bean.setRole(request.getParameter("role"));
		
		if(bean.getId() == null || bean.getName() == null || bean.getEmail() == null || bean.getPas() == null || bean.getC_pas() == null || bean.getRole() == null
			|| bean.getId() == "" || bean.getName() == "" || bean.getEmail() == "" || bean.getPas() == "" || bean.getC_pas() == "" || bean.getRole() == "") {
			request.setAttribute("error", "Field cannot be blank!!!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
		else if(!bean.getC_pas().equals(bean.getPas())) {
			request.setAttribute("error", "Password is not match!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
		else {
			UserDAO dao = new UserDAO();
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			dto.setEmail(bean.getEmail());
			dto.setPas(bean.getPas());
			dto.setRole(bean.getRole());
			int i = dao.insertUser(dto);
			if(i > 0) {
				request.setAttribute("msg", "Registration Successful.");
			}
			else {
				request.setAttribute("bean", bean);
				request.setAttribute("error", "Registration Failed!");
			}
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
	}

}
