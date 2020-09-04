package todos.dao;

import java.sql.Connection;
import java.util.ArrayList;

import todos.model.Todos;

public interface TodosDao {
	void editTodos(String title,String date,int done);
	void deleteTodos(String title);
	ArrayList<Todos> findAll(int id);
	void insertTodos(int id,String title,String date);
	Todos findTodos(String title);
}
