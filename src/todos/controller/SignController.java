package todos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todos.dao.IUsersDao;
@WebServlet(urlPatterns= {"/sign"})
public class SignController extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher rq = req.getRequestDispatcher("webapp/sign.jsp");
			rq.forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			IUsersDao ud = new IUsersDao();
			try{
				ud.insertUser(username, password);
				RequestDispatcher rq = req.getRequestDispatcher("webapp/login.jsp");
				rq.forward(req,resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
