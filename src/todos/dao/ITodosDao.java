package todos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import todos.ConnectionDatabase.JDBCConnection;
import todos.model.Todos;

public class ITodosDao implements TodosDao{


	@Override
	public void editTodos(String title,String date,int done) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "update todos set title=?,day=?,done=? where title=? ";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, date);
			st.setInt(3, done);
			st.setString(4,title);
			int rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTodos(String title) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "delete from todos where title = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			int rs = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Todos> findAll(int id) {
		Connection con = JDBCConnection.getJDBCConnection();
		ArrayList<Todos> ls = new ArrayList<>();
		String sql = "select * from todos where todos_id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Todos td = new Todos(rs.getInt(5),rs.getString(2),rs.getString(3),rs.getInt(4));
				ls.add(td);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertTodos(int id,String title,String date) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "insert into todos(title,day,done,todos_id) values(?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,title);
			st.setString(2, date);
			st.setInt(3, 0);
			st.setInt(4, id);
			int rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Todos findTodos(String title) {
		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "select * from todos where title=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,title);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				Todos td = new Todos(rs.getInt(5),rs.getString(2),rs.getString(3),rs.getInt(4));
				return td;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
