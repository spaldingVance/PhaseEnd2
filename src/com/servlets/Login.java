package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpsession = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		try {
			Transaction transaction = session.beginTransaction();
			boolean isCorrect[] = {false};
			
			List<User> userList = session.createQuery("from User").list();
			userList.forEach(user -> {
				if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
					isCorrect[0] = true;
				}
			});
			
			if (isCorrect[0]) {
				httpsession.setAttribute("userName", userName);
				response.sendRedirect("welcome.jsp");
			}
			else {
				httpsession.invalidate();
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.println("<p>Invalid Credentials!</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
