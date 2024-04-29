package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
import Model.StudentBean;

@WebServlet("/StudentRegister")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class StudentRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        StudentBean bean = new StudentBean();
        bean.setId(request.getParameter("id"));
        bean.setName(request.getParameter("name"));
        bean.setDob(request.getParameter("dob"));
        bean.setGender(request.getParameter("gender"));
        bean.setPhone(request.getParameter("phone"));
        bean.setEducation(request.getParameter("education"));

        Part filePart = request.getPart("photo");

        if (filePart != null && filePart.getSize() > 0) {
		    InputStream inputStream = filePart.getInputStream();
		    
		    if (inputStream == null || bean.getId().equals("") || bean.getName().equals("") || bean.getDob().equals("")
		            || bean.getEducation().isEmpty() || bean.getGender().isBlank()) {

		        request.setAttribute("error", "Fields cannot be blank!");
		        request.getRequestDispatcher("STU001.jsp").include(request, response);
		        return;
		    }

		    ArrayList<String> attend1 = new ArrayList<>();
		    String[] attend = request.getParameterValues("attend");

		    for (int i = 0; i < attend.length; i++) {
		        attend1.add(attend[i]);
		    }

		    if (attend1.size() > 0) {
		        StringBuilder sb = new StringBuilder();
		        for (String a : attend) {
		            sb.append(a).append(",");
		        }
		        bean.setAttend(sb.deleteCharAt(sb.length() - 1).toString());
		    }

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

		    int i = dao.insertStU(dto);
		    if (i > 0) {
		        byte[] imageData = dao.getImageData(dto.getId());
		        request.setAttribute("msg", "Registration Successful.");
		        request.setAttribute("imageData", imageData);
		    } else {
		        request.setAttribute("error", "Registration Failed!!");
		        request.setAttribute("bean", bean);
		    }

		    request.getRequestDispatcher("STU001.jsp").forward(request, response);
		} else {
		    request.setAttribute("error", "File is empty or not provided!");
		    request.getRequestDispatcher("STU001.jsp").include(request, response);
		    return;
		}
    }
}
