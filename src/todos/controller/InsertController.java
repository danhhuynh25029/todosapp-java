package todos.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todos.dao.ITodosDao;
import todos.model.User;
@WebServlet(urlPatterns= {"/insert"})
public class InsertController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("content");
		String date = req.getParameter("date");
		ITodosDao td = new ITodosDao();
		HttpSession ht  = req.getSession();
		User us = (User) ht.getAttribute("user");
		int id = us.getId();
		try {
			td.insertTodos(id, title, date);
			RequestDispatcher rq = req.getRequestDispatcher("todoslist");
			rq.forward(req,resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
