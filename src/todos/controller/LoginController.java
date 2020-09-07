package todos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import todos.dao.IUsersDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String username = "";
		String password = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie cook : cookies) {
			if(cook.getName().equals("username")) {
				username = cook.getValue();
			}
			if(cook.getName().equals("password")) {
				password = cook.getValue();
			}
		}
		User us = new User(0,username,password);
		req.setAttribute("user", us);
		RequestDispatcher rq = req.getRequestDispatcher("webapp/login.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		IUsersDao ud = new IUsersDao();
		User us = ud.findUser(username, password);
		if(us != null) {
			HttpSession ht = req.getSession();
			ht.setAttribute("user", us);
			Cookie cookUsername = new Cookie("username",username);
			cookUsername.setMaxAge(60*60*15);
			Cookie cookPassword = new Cookie("password",password);
			cookPassword.setMaxAge(60*60*15);
			resp.addCookie(cookUsername);
			resp.addCookie(cookPassword);
			resp.sendRedirect("todoslist");
		}else {
			resp.sendRedirect("login");
		}
	}
}
