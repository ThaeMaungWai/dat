package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.UserRequestDTO;
import DTO.UserResponseDTO;


public class UserDAO {
	public static Connection connection = null;
	static {
		connection = ConnectionClass.myConnection();
	}
		public int insertUser(UserRequestDTO dto) {
			int status = 0;
			String sql = "insert into users(id,name,email,pas,role) values (?,?,?,?,?)";
			try {
				Connection connection= ConnectionClass.myConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getName());
				ps.setString(3, dto.getEmail());
				ps.setString(4, dto.getPas());
				ps.setString(5, dto.getRole());
				 status=ps.executeUpdate();
			} catch (SQLException e) {
	            e.printStackTrace();
			}
			return status;
		}
		public UserResponseDTO CheckUser(UserRequestDTO dto)
		{
			UserResponseDTO res = null;
			
			try 
			{
			Connection connection= ConnectionClass.myConnection();
			PreparedStatement ps=connection.prepareStatement("select * from users where name=? and pas=?");
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPas());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				res = new UserResponseDTO();
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setRole(rs.getString("role"));
				res.setPas(rs.getString("pas"));
			}
			} catch (SQLException e) 
			{
			System.out.println(e.getMessage());
			}
			return res;
		}
		public ArrayList<UserResponseDTO> ShowAllResult()
		{
			ArrayList<UserResponseDTO> list = new ArrayList();
			Connection con=ConnectionClass.myConnection();
			try 
			{
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				UserResponseDTO res = new UserResponseDTO();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				res.setPas(rs.getString("pas"));
				res.setEmail(rs.getString("email"));
				res.setRole(rs.getString("role"));	
				list.add(res);
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			return list;
		}
		public int updateUser(UserRequestDTO dto) {
			int result = 0;
			String sql = "update users set name=?,email=?,pas=?,role=? where id=?";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getEmail());
				ps.setString(3, dto.getPas());
				ps.setString(4, dto.getRole());
				ps.setString(5, dto.getId());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Update Failed!");
			}
			return result;
		}
		public int deleteUser(UserRequestDTO dto) {
			int result = 0;
			String sql = "delete from users where id=?";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, dto.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Delete Failed!");
			}
			return result;
		}
		public UserResponseDTO selectOne(UserRequestDTO dto) {
			UserResponseDTO res = new UserResponseDTO();
			String sql = "select * from users where id=?";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1,dto.getId());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					res.setId(rs.getString("id"));
					res.setName(rs.getString("name"));
					res.setEmail(rs.getString("email"));
					res.setPas(rs.getString("pas"));
					res.setRole(rs.getString("role"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}
		public ArrayList<UserResponseDTO> searchData(UserRequestDTO dto) {
			UserResponseDTO res = new UserResponseDTO();
			ArrayList<UserResponseDTO> list = new ArrayList();
			String sql = "select * from users where id=? or name=?";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(2, dto.getName());
				ps.setString(1, dto.getId());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					res.setId(rs.getString("id"));
					res.setName(rs.getString("name"));
					list.add(res);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
}
