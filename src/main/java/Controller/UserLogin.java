package Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();		
		UserBean bean = new UserBean();
		//Date date = new Date();
		LocalDate date = LocalDate.now();
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPas(request.getParameter("pas"));
		if(bean.getEmail() == "" || bean.getPas() == "" || bean.getEmail() == null 
		|| bean.getPas() == null || bean.getName()== null|| bean.getName()=="") {
			request.setAttribute("error", "Field cannot be blank!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);
		}
		else {
			UserDAO dao = new UserDAO();
			UserRequestDTO dto = new UserRequestDTO();
			dto.setName(bean.getName());
			dto.setEmail(bean.getEmail());
			dto.setPas(bean.getPas());
			UserResponseDTO res = new UserResponseDTO();
			res = dao.CheckUser(dto);  
			if(res == null)
			{
				request.setAttribute("error", "Login Failed!");
				request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			}
			String name=res.getName();
			String email = res.getEmail();
			String today = date.toString();
			if(res != null) {
				session.setAttribute("name", name);
				session.setAttribute("date", today);
				//session.setAttribute("res", date.toString());
				request.getRequestDispatcher("MNU001.jsp").forward(request, response);
			}
			
		}
	}

}
