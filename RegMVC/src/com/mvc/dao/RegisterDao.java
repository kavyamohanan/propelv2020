package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mvc.bean.RegisterBean;
import com.mvc.util.ConnectionFactory;

public class RegisterDao {

	// default constructor
	public RegisterDao() {
		super();
	}

	// singleton design pattern
	private static RegisterDao instance = null;

	public static RegisterDao getInstance() {
		if (instance == null) {
			instance = new RegisterDao();
		}
		return instance;
	}

	private static final String SELECT_USER_BYID = "SELECT * FROM users WHERE USR_SLNO=?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users WHERE USR_ISACTIVE='y'";
	private static final String UPDATE_USER = "UPDATE users SET USR_FULLNAME=?,USR_EMAIL=?,USR_USERNAME=?,USR_PASSWORD=?,USR_ISACTIVE=?,USR_ROLE=?,USR_GENDER=?,REG_DATE=? WHERE USR_SLNO=?";
	private static final String DELETE_USER = "UPDATE users SET usr_isactive='n' WHERE usr_slno=?";

	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;

	public String registerUser(RegisterBean registerBean) {

		String fullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String userName = registerBean.getUserName();
		String passWord = registerBean.getPassword();
		String role = registerBean.getRole();
		String isact = registerBean.getIsActive();
		String gender = registerBean.getGender();
		// Date regDate = registerBean.getRegDate();

		// System.out.println(registerBean.toString());

		try {

			con = ConnectionFactory.getConnection();
			String query = "insert into users(usr_fullName,usr_email,usr_userName,usr_passWord,usr_role,usr_isActive,usr_gender,reg_date) values(?,?,?,?,?,?,?,?)";

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, passWord);
			preparedStatement.setString(5, role);
			preparedStatement.setString(6, isact);
			preparedStatement.setString(7, gender);
			preparedStatement.setDate(8, new java.sql.Date(registerBean
					.getRegDate().getTime()));

			int i = preparedStatement.executeUpdate();

			// just to ensure that data has been inserted to the database
			if (i != 0) {

				return "SUCCESS";
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		// on failure
		return "oops...Something went wrong there...!";
	}

	// selecting user by id
	public RegisterBean selectUser(int id) {

		RegisterBean register = null;

		try {
			con = ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(SELECT_USER_BYID);

			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int sl = rs.getInt("usr_slno");
				String fullName = rs.getString("usr_fullname");
				String email = rs.getString("usr_email");
				String userName = rs.getString("usr_username");
				String password = rs.getString("usr_password");
				String active = rs.getString("usr_isactive");
				String role = rs.getString("usr_role");
				String gender = rs.getString("usr_gender");
				Date regDate = rs.getDate("reg_date");

				register = new RegisterBean(sl, fullName, email, userName,
						password, role, active, gender, regDate);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return register;
	}

	// selecting all users
	public List<RegisterBean> selectAllUsers() {

		List<RegisterBean> registerList = new ArrayList<RegisterBean>();

		try {
			con = ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(SELECT_ALL_USERS);

			System.out.println(SELECT_ALL_USERS);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("usr_slno");
				String fullName = rs.getString("usr_fullname");
				String email = rs.getString("usr_email");
				String userName = rs.getString("usr_username");
				String password = rs.getString("usr_password");
				String active = rs.getString("usr_isactive");
				String role = rs.getString("usr_role");
				String gender = rs.getString("usr_gender");
				Date regDate = rs.getDate("reg_date");

				registerList.add(new RegisterBean(id, fullName, email,
						userName, password, role, active, gender, regDate));
				// System.out.println(registerList);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return registerList;
	}

	// update user
	public boolean updateUser(RegisterBean registerBean) {

		boolean row = false;
		try {

			// establishing connection
			con = ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(UPDATE_USER);

			preparedStatement.setString(1, registerBean.getFullName());
			preparedStatement.setString(2, registerBean.getEmail());
			preparedStatement.setString(3, registerBean.getUserName());
			preparedStatement.setString(4, registerBean.getPassword());
			preparedStatement.setString(5, registerBean.getIsActive());
			preparedStatement.setString(6, registerBean.getRole());
			preparedStatement.setString(7, registerBean.getGender());
			preparedStatement.setDate(8, new java.sql.Date(registerBean
					.getRegDate().getTime()));

			preparedStatement.setInt(9, registerBean.getSlNo());

			System.out.println(registerBean.toString());

			row = preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println(e);
		}
		return row;
	}

	public boolean deleteUser(int id) {

		boolean row = false;
		try {

			// establishing connection
			con = ConnectionFactory.getConnection();
			preparedStatement = con.prepareStatement(DELETE_USER);

			// preparedStatement.setString(1, registerBean.getIsActive());

			preparedStatement.setInt(1, id);

			row = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return row;
	}

}
