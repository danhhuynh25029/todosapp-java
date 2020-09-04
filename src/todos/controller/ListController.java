package todos.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todos.dao.ITodosDao;
import todos.model.Todos;
import todos.model.User;
@WebServlet(urlPatterns= {"/todoslist"})
public class ListController extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession ht = req.getSession();
			User user = (User) ht.getAttribute("user");
			if(user == null) {
				RequestDispatcher rq = req.getRequestDispatcher("login");
				rq.forward(req,resp);
			}
			else {
				int id = user.getId();
				ITodosDao td = new ITodosDao();
				ArrayList<Todos> list = td.findAll(id);
				req.setAttribute("list", list);
				RequestDispatcher rq = req.getRequestDispatcher("webapp/todoslist.jsp");
				rq.forward(req, resp);
			}
		}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession ht = req.getSession();
			User user = (User) ht.getAttribute("user");
			int id = user.getId();
			ITodosDao td = new ITodosDao();
			ArrayList<Todos> list = td.findAll(id);
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("webapp/todoslist.jsp");
			rq.forward(req, resp);
		}
}
