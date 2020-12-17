package co.simplon.dao;

import java.sql.*;


import javax.servlet.ServletContext;



public class DAOContext {
	/*private static String db_url="";
	private static String db_username="";
	private static String db_password="";*/
	
	public static Connection getConnection() throws SQLException{
		String protocol =  "jdbc:";
		String sous_protocol = "mysql://";
		String ip = "localhost:3306/";
		String bd = "testjdbc";
		String paramètre = "?useSSL=false&serverTimezone=Europe/Paris";
		String login = "root";
		String password = "Dissidia12!";
		String url = protocol+sous_protocol+ip+bd+paramètre;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection connexion = DriverManager.getConnection(url,login,password);
		System.out.println("success");
		return connexion;
		
	}
	;
	public PaysDAO getPaysDao() {
		return new PaysDaoImpl(this);
	}
	/*public void init(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName(servletContext.getInitParameter("JDBC_DRIVER"));
			db_url = servletContext.getInitParameter("JDBC_URL");
			db_username = servletContext.getInitParameter( "JDBC_LOGIN" );
			db_password = servletContext.getInitParameter( "JDBC_PASSWORD" );
		}catch(Exception exception) {
			
		}*/
		
	}
	
		
	


