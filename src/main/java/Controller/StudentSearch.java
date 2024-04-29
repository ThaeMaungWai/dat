package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDAO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import Model.StudentBean;

/**
 * Servlet implementation class StudentSearch
 */
@WebServlet("/StudentSearch")
public class StudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentBean bean = new StudentBean();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String attend = request.getParameter("attend");
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setAttend(request.getParameter("attend"));
		if(bean.getId() == null && bean.getName() == null && bean.getAttend() == null || bean.getId() == "" && bean.getName() == "" && bean.getAttend() == "") {
			request.setAttribute("error", "Fill the blanks!!");
			request.getRequestDispatcher("STU003.jsp").forward(request, response);
		}else {
		
			StudentRequestDTO dto = new StudentRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			dto.setAttend(bean.getAttend());

			//String attend = dto.getAttend();
			StudentDAO dao = new StudentDAO();
			
			ArrayList<StudentResponseDTO> list = dao.searchData(dto);
			System.out.println(list.size());
			
			if(!(attend.isEmpty() || attend.isBlank())) {
				if(list.size() == 0) {
					list =  dao.SearchwithCourse(dto.getAttend());
				}
			}
			System.out.println(list.size());
			if(list.size() == 0) {
				
				session.setAttribute("list", list);
				request.setAttribute("error", "User data not found!!");
				request.getRequestDispatcher("STU003.jsp").forward(request, response);
			}
			session.setAttribute("list", list);
			request.getRequestDispatcher("STU003.jsp").forward(request, response);
	}
	}

}
