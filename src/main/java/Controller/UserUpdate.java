package Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.UserBean;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();
		String id = request.getParameter("id");
		
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(id);
		UserResponseDTO res = new UserResponseDTO();
		res = dao.selectOne(dto);
		System.out.println(res.getId());
		session.setAttribute("res", res);
		request.getRequestDispatcher("USR002.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPas(request.getParameter("pas"));
		bean.setC_pas(request.getParameter("c_pas"));
		bean.setRole(request.getParameter("role"));
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getEmail());
		System.out.println(bean.getPas());
		System.out.println(bean.getC_pas());
		System.out.println(bean.getRole());
		if(bean.getId() == null || bean.getName() == null || bean.getEmail() == null || bean.getPas() == null || bean.getC_pas() == null || bean.getRole() == null
			|| bean.getId() == "" || bean.getName() == "" || bean.getEmail() == "" || bean.getPas() == "" || bean.getC_pas() == "" || bean.getRole() == "") {
			request.setAttribute("error", "Field cannot be blank!!!");
			request.setAttribute("res", bean);
			request.getRequestDispatcher("USR002.jsp").forward(request, response);
		}
		else if(!bean.getC_pas().equals(bean.getPas())) {
			request.setAttribute("error", "Password is not match!");
			request.setAttribute("res", bean);
			request.getRequestDispatcher("USR002.jsp").forward(request, response);
		}
		else {
			UserDAO dao = new UserDAO();
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			dto.setEmail(bean.getEmail());
			dto.setPas(bean.getPas());
			dto.setRole(bean.getRole());
			int i = dao.updateUser(dto);
			if(i > 0) {
				session.setAttribute("res", dto);
				request.setAttribute("msg", "Update Successful.");
			}
			else {
				request.setAttribute("res", bean);
				request.setAttribute("error", "Update Failed!");
			}
			request.getRequestDispatcher("USR002.jsp").forward(request, response);
		}
	}
	}


