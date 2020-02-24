package com.mvc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String role = request.getParameter("role");
		String gender = request.getParameter("gender");
		String isact = request.getParameter("isact");
		String regDate = request.getParameter("regdate");
		
		
		java.text.DateFormat ft = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date regParseDate = null;
		try {
			regParseDate= ft.parse(regDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RegisterBean registerBean = new RegisterBean();
		
		registerBean.setFullName(fullName);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setPassword(password);
		registerBean.setRole(role);
		registerBean.setGender(gender);
		registerBean.setIsActive(isact);
		registerBean.setRegDate(regParseDate);
		//registerBean.setRegDate(regDate);
		//registerBean.setRegDate(startDate);
		
		RegisterDao registerDao = new RegisterDao();
		String registerUser = registerDao.registerUser(registerBean) ;
		
		request.getRequestDispatcher("/JSP/Home.jsp").forward(request, response);
		System.out.println(registerUser);

		
		
	}

}
