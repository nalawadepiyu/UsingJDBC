package com.apex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection dbConn = null;
	
	public static Connection getConnection() throws Exception{
	
		
	
    try{
    //step1:
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //com.microsoft.jdbc.sqlserver.SQLServerDriver
	//step2
    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=InfoDB;";
    //"jdbc:microsoft:sqlserver//DESKTOP-0GAQQ5O/SQLEXPRESS:1433/InfoDB"
    //HOST:1433;DatabaseName=DATABASE
	//step3
	dbConn = DriverManager.getConnection(url,"sa", "Priyanka@123");
	}
     catch (SQLException sqle) {
	   sqle.printStackTrace();
	   throw sqle;
	}
         catch(Exception e) {
	   e.printStackTrace();
	   throw e;
	}
    	return dbConn;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
		dbConn.close();
		
	}
}
