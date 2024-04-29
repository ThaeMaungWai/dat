package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;

public class StudentDAO {
	public static Connection con = null;

    static {
        con = ConnectionClass.myConnection();
    }

    public String generateCusId() {
        String stuId = null;
        int count = 0;
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select count(*)+1 from student_info");
            ResultSet rs = ps.executeQuery();
            rs.next();

            count = rs.getInt(1);

            if (count < 10) {
                stuId = "STU00" + count;
            } else if (count >= 10 && count < 100) {
                stuId = "STU0" + count;
            } else if (count == 100) {
                stuId = "STU" + count;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stuId;
    }

    public int insertStU(StudentRequestDTO dto) {
        int result = 0;
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "insert into student_info(id,name,dob,gender,phone,education,attend,photo) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDob());
            ps.setString(4, dto.getGender());
            ps.setString(5, dto.getPhone());
            ps.setString(6, dto.getEducation());
            ps.setString(7, dto.getAttend());
            ps.setBinaryStream(8, dto.getFile());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        {
            System.out.println("Rest of code");
        }
        return result;
    }

    public StudentResponseDTO SelectOne(StudentRequestDTO dto) {
        StudentResponseDTO res = new StudentResponseDTO();
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from student_info where id=?");
            ps.setString(1, dto.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                res.setId(rs.getString("id"));
                res.setName(rs.getString("name"));
                res.setDob(rs.getString("dob"));
                res.setGender(rs.getString("gender"));
                res.setPhone(rs.getString("phone"));
                res.setEducation(rs.getString("education"));
                res.setAttend(rs.getString("attend"));
                res.setFile(rs.getBinaryStream("photo"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public int UpdateStu(StudentRequestDTO dto) {
        int result = 0;
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "update student_info set name=?,dob=?,gender=?,phone=?,education=?,attend=?,photo=? where id=?");

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDob());
            ps.setString(3, dto.getGender());
            ps.setString(4, dto.getPhone());
            ps.setString(5, dto.getEducation());
            ps.setString(6, dto.getAttend());
            ps.setBinaryStream(7, dto.getFile());
            ps.setString(8, dto.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        {
            System.out.println("Rest of code");
        }
        return result;
    }

    public int DeleteStu(StudentRequestDTO dto) {
        int result = 0;
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from student_info where id=?");
            ps.setString(1, dto.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        {
            System.out.println("Rest of code");
        }
        return result;
    }

    public ArrayList<StudentResponseDTO> ShowStu() {
        ArrayList<StudentResponseDTO> list = new ArrayList();
        Connection con = ConnectionClass.myConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from student_info");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentResponseDTO res = new StudentResponseDTO();
                res.setId(rs.getString("id"));
                res.setName(rs.getString("name"));
                res.setDob(rs.getString("dob"));
                res.setGender(rs.getString("gender"));
                res.setPhone(rs.getString("phone"));
                res.setEducation(rs.getString("education"));
                res.setAttend(rs.getString("attend"));
                res.setFile(rs.getBinaryStream("photo"));
                list.add(res);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<StudentResponseDTO> searchData(StudentRequestDTO dto) {

        ArrayList<StudentResponseDTO> list = new ArrayList();

        String sql = "select * from student_info where id=? or name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentResponseDTO res = new StudentResponseDTO();
                res.setId(rs.getString("id"));
                res.setName(rs.getString("name"));
                res.setAttend(rs.getString("attend"));
                list.add(res);
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<StudentResponseDTO> SearchwithCourse(String attend) {
        ArrayList<StudentResponseDTO> list = new ArrayList();
        Connection con = ConnectionClass.myConnection();
        String sql = "select * from student_info where attend like '%" + attend + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentResponseDTO res = new StudentResponseDTO();
                res.setId(rs.getString("id"));
                res.setName(rs.getString("name"));
                res.setDob(rs.getString("dob"));
                res.setGender(rs.getString("gender"));
                res.setPhone(rs.getString("phone"));
                res.setEducation(rs.getString("education"));
                res.setAttend(rs.getString("attend"));
                res.setFile(rs.getBinaryStream("photo"));
                list.add(res);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public byte[] getImageData(String studentId) {
        Connection con = ConnectionClass.myConnection();
        byte[] imageData = null;
        try {
            PreparedStatement ps = con.prepareStatement("select photo from student_info where id = ?");
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InputStream inputStream = rs.getBinaryStream("photo");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                imageData = outputStream.toByteArray();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return imageData;
    }
	
	
	
  
}