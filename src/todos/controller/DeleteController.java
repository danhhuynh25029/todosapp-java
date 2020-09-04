package todos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todos.dao.ITodosDao;
@WebServlet(urlPatterns= {"/delete"})
public class DeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		ITodosDao td = new ITodosDao();
		try {
			td.deleteTodos(title);
			RequestDispatcher rq = req.getRequestDispatcher("todoslist");
			rq.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
