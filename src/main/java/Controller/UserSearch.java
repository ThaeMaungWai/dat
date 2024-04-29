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
import Model.UserBean;


/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		if(bean.getId().isBlank() && bean.getName().isBlank() || bean.getId().isEmpty() && bean.getName().isEmpty()) {
			request.setAttribute("error", "Fill the blanks!!");
			request.getRequestDispatcher("USR003.jsp").forward(request, response);
		}else {

		
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			UserDAO dao = new UserDAO();
			ArrayList<UserResponseDTO> list = dao.searchData(dto);
			if(list.size() == 0) {
				System.out.println("Searching Failed!");
				session.setAttribute("list", list);
				request.setAttribute("error","User Data not found!!");
			}
			session.setAttribute("list", list);
			request.getRequestDispatcher("USR003.jsp").forward(request, response);
		}
		
	}

}
