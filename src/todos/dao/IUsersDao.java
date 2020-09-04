package todos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todos.ConnectionDatabase.JDBCConnection;
import todos.model.User;

public class IUsersDao implements UsersDao {
	@Override
	public User findUser(String username, String password) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "select * from user where username=? and password=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				User us = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
				return us;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insertUser(String username, String password) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "insert into user(username,password) values(?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			int rs = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
