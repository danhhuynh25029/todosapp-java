package todos.controller;

import java.io.IOException;
import todos.dao.IUsersDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todos.model.User;
@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ht = req.getSession();
		ht.invalidate();
		RequestDispatcher rq = req.getRequestDispatcher("webapp/login.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		System.out.println(username);
		IUsersDao ud = new IUsersDao();
		User us = ud.findUser(username, password);
		if(us != null) {
			HttpSession ht = req.getSession();
			ht.setAttribute("user", us);
			resp.sendRedirect("todoslist");
		}else {
			resp.sendRedirect("login");
		}
	}
}
