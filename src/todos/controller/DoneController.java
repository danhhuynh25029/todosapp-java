package todos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todos.dao.ITodosDao;
@WebServlet(urlPatterns= {"/done"})
public class DoneController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int done = Integer.parseInt(req.getParameter("done"));
			String title = req.getParameter("title");
			String date = req.getParameter("date");
			ITodosDao td = new ITodosDao();
			try {
				td.editTodos(title, date, done);
				RequestDispatcher rq = req.getRequestDispatcher("todoslist");
				rq.forward(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
