/**
 * 
 */
package com.barry.myStruts.stockage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author algas
 *
 */
public  class DaoORBUSER  {
	private static DaoORBUSER instance = new DaoORBUSER();
	Connection connection;
	private final static String URL = "jdbc:mysql://localhost:3306/user";
	private final static String LOGIN = "root";
	private final static String PSWD = "";
	private Properties properties;
	
	private DaoORBUSER() {
		 try {
			 
			 properties = new Properties();
             //this.charger();
			//connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("LOGIN"),properties.getProperty("PSWD"));
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	private void charger() {
//		try {
//			//properties.load(new FileInputStream("mysql.properties"));
//			properties.load(DaoFactoryUSER.class.getResourceAsStream("mysql.properties"));
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

	public static DaoORBUSER getInstance() {
		return instance;
	}

	public static void main(String [] args) {
		
		DaoORBUSER daoORB = new DaoORBUSER();
//		daoORB.charger();
	}
	
}
