package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();

		loginBean.setUserName(userName);
		loginBean.setPassword(password);

		LoginDao loginDao = new LoginDao();

		try {

			String userValidate = loginDao.authenticateUser(loginBean);

			if (userValidate.equals("Admin_Role")) {

				System.out.println("Admin's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Admin", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/JSP/Admin.jsp").forward(request,response);

			} else if (userValidate.equals("Editor_Role")) {

				System.out.println("Editor's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Editor", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/JSP/Editor.jsp").forward(
						request, response);
			} else if (userValidate.equals("User_Role")) {
				System.out.println("User's Home");

				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("User", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/JSP/User.jsp").forward(request,
						response);
			} else {
				System.out.println("Error Message =" + userValidate);

				request.setAttribute("errorMessage", userValidate);

				request.getRequestDispatcher("/JSP/Login.jsp").forward(request,
						response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
