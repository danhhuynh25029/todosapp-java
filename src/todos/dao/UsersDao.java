package todos.dao;

import java.sql.Connection;

import todos.model.User;

public interface UsersDao {
	User findUser(String username,String password);
	void insertUser(String username,String password);
}
