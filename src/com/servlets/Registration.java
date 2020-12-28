package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();		
		
		try {
			Transaction transaction = session.beginTransaction();
			User u = new User();
			boolean isAvailable[] = {true};
			
			List<User> userList = session.createQuery("from User").list();
			userList.forEach(user -> {
				if (user.getUserName().equalsIgnoreCase(userName)) {
					isAvailable[0] = false;
				}
			});
			
			if (isAvailable[0]) {
				u = new User(userName, password);
				session.save(u);
				transaction.commit();
				
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<p>Registration Complete!</p>");
			}
			else {
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<p>User Name Taken!<p>");
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
