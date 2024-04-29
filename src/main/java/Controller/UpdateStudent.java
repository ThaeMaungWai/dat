package Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.StudentDAO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import Model.StudentBean;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 20    // 20MB
)

public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		StudentDAO dao = new StudentDAO();
		String id = request.getParameter("id");
		
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setId(id);
		StudentResponseDTO res = new StudentResponseDTO();
		res = dao.SelectOne(dto);
		System.out.println(res.getId());
		session.setAttribute("res", res);
		request.getRequestDispatcher("STU002.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		StudentBean bean = new StudentBean();

		bean.setId( request.getParameter("id"));
		bean.setName(request.getParameter("name")) ;
		bean.setDob(request.getParameter("dob")) ;
		bean.setGender(request.getParameter("gender"));
		bean.setPhone(request.getParameter("phone"));
		bean.setEducation(request.getParameter("education"));
		Part file = request.getPart("photo");
	    InputStream inputStream = file.getInputStream();
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDob());
		System.out.println(bean.getGender());
		System.out.println(bean.getPhone());
		System.out.println(bean.getEducation());
		ArrayList <String> attend1 = new ArrayList();
		String[] attend = request.getParameterValues("attend");
		
		
		if(inputStream == null ||bean.getId().equals("") || bean.getName().equals("") 
		   || bean.getDob().equals("") || bean.getEducation().isEmpty() 
		   || bean.getGender() == null  
		   ||inputStream.available() == 0
		   || bean.getPhone().equals("") || attend == null ) {
			
			request.setAttribute("error", "Field cannot be blanks!!");
			request.getRequestDispatcher("STU002.jsp").include(request, response);
		}else {
			for( int i = 0; i < attend.length; i++)
			{
				attend1.add(attend[i]);
			}
			if(attend1.size() > 0)
			{
				StringBuilder sb = new StringBuilder();
				for(String a: attend)
				{
					sb.append(a).append(",");
				}
				bean.setAttend(sb.deleteCharAt(sb.length()-1).toString());
			}
			
    		 bean.setFile(inputStream);
    		 System.out.println(bean.getAttend());
    		 System.out.println(bean.getFile());
    		StudentDAO dao = new StudentDAO();
    		StudentRequestDTO dto = new StudentRequestDTO();
    		dto.setId(bean.getId());
    		dto.setName(bean.getName());
    		dto.setDob(bean.getDob());
    		dto.setPhone(bean.getPhone());
    		dto.setGender(bean.getGender());
    		dto.setEducation(bean.getEducation());
    		dto.setAttend(bean.getAttend());
    		dto.setFile(inputStream);
    		int i = dao.UpdateStu(dto);
    		if(i > 0) {
    			request.setAttribute("msg", "Update Successful.");
    		}
    		else {
    			request.setAttribute("error", "Update Failed!!");
    			request.setAttribute("bean", bean);
    		}
    
            request.getRequestDispatcher("STU003.jsp").forward(request, response);
		}
	}

}
