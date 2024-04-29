package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CourseRequestDTO;
import DTO.CourseResponseDTO;



public class CourseDAO {
	public static Connection con = null;
	static {
		con = ConnectionClass.myConnection();
	}
	public int insertCourse(CourseRequestDTO dto)
	{
		int result = 0;
		Connection con = ConnectionClass.myConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into course(id,name) values(?,?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			result = ps.executeUpdate();
		}catch (SQLException e) 
		{
				System.out.println(e.getMessage());
		}
		{
				System.out.println("Rest of code");
		}
		return result;
	}
	public ArrayList<CourseResponseDTO> ShowCourse()
	{
		ArrayList<CourseResponseDTO> list = new ArrayList();
		Connection con=ConnectionClass.myConnection();
		try 
		{
		PreparedStatement ps=con.prepareStatement("select * from course");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			CourseResponseDTO res = new CourseResponseDTO();
			res.setId(rs.getString("id"));
			res.setName(rs.getString("name"));	
			list.add(res);
		}
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		return list;
	}
	 public int deleteCourse(String courseId) {
	        int result = 0;
	        try {
	            PreparedStatement ps = con.prepareStatement("DELETE FROM course WHERE id = ?");
	            ps.setString(1, courseId);
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return result;
	    }
}
