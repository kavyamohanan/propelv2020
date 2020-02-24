package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	static Connection connection = null;

	public static Connection getConnection() throws Exception {

		try {

			// calling the method loadPropertiesFIle() to get the details from
			// jdbc.properties File
			Properties prop = loadPropertiesFile();

			// storing properties into variables
			String driverClass = prop.getProperty("ORACLEJDBC.JDBC_DRIVER");
			String url = prop.getProperty("ORCALEJDBC.DB_URL");
			String username = prop.getProperty("ORACLEJDBC.USER");
			String password = prop.getProperty("ORACLEJDBC.PASS");
			
			//register jdbc driver
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {

			throw new RuntimeException("Error Connecting to database "+e);
		}
	}

	private static Properties loadPropertiesFile() throws Exception {

		// creating new object for property class
		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("jdbc.properties"));

		return prop;
	}

	public static void main(String[] args) throws Exception {

		connection = ConnectionFactory.getConnection();
		System.out.println("Connected to database");
	}

}
