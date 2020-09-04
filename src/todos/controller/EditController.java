package todos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todos.dao.ITodosDao;
import todos.model.Todos;

@WebServlet(urlPatterns= {"/edit"})
public class EditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		ITodosDao td = new ITodosDao();
		Todos ts = td.findTodos(title);
		req.setAttribute("todos", ts);
		RequestDispatcher rq = req.getRequestDispatcher("webapp/edit.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		ITodosDao td = new ITodosDao();
		try {
			td.editTodos(title, date,0);
			RequestDispatcher rq = req.getRequestDispatcher("todoslist");
			rq.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
