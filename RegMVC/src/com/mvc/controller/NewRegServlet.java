package com.mvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

/**
 * Servlet implementation class NewRegServlet
 */
@WebServlet("/")
public class NewRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDao registerDao;

	public void init() {
		registerDao = RegisterDao.getInstance();

	}

	public NewRegServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		try {

			switch (action) {

			case "/new":
				showNewRegForm(request, response);
				break;

			case "/insert":
				insertUser(request, response);
				break;

			case "/delete":
				deleteUser(request, response);
				break;

			case "/edit":
				showEditForm(request, response);
				break;

			case "/update":
				updateUser(request, response);
				break;

			case "/list":
				listUser(request, response);
				break;

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	//list
		private void listUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			List<RegisterBean> regList = registerDao.selectAllUsers();
			request.setAttribute("listUser", regList);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("JSP/List.jsp");
			dispatcher.forward(request, response);
		}
		
		//update
		private void updateUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
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
				regParseDate = ft.parse(regDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RegisterBean regBean = new RegisterBean(id,fullName,email,userName,password,role,isact,gender,regParseDate);
			registerDao.updateUser(regBean);
			response.sendRedirect("JSP/List.jsp");		
		}
		
		private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			registerDao.deleteUser(id);
			response.sendRedirect("JSP/List.jsp");
		}
		
		// show new form for add only
			private void showNewRegForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("JSP/Admin.jsp");
				dispatcher.forward(request, response);

			}

			//update and delete
			private void showEditForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {

				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				RegisterBean existUser = registerDao.selectUser(id);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("JSP/Admin.jsp");
				// setting attribute
				request.setAttribute("user", existUser);
				dispatcher.forward(request, response);

			}
			
			//insert user
			private void insertUser(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{
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
					regParseDate = ft.parse(regDate);
				} catch (Exception e) {
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
				// registerBean.setRegDate(regDate);
				// registerBean.setRegDate(startDate);

				RegisterDao registerDao = new RegisterDao();
				String registerUser = registerDao.registerUser(registerBean);

				request.getRequestDispatcher("/JSP/Home.jsp")
						.forward(request, response);
				System.out.println(registerUser);

			}

}
