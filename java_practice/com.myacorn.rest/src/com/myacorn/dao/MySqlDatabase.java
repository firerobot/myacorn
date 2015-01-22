package com.myacorn.dao;

import javax.naming.*;
import javax.sql.*;

public class MySqlDatabase {

	private static DataSource mySqlDs = null; //hold the database object
	private static Context initialContext = null; //used to lookup the database connection in tomcat
	
	public static DataSource MySqlDataSource() throws Exception {
		if (mySqlDs != null) {
			return mySqlDs;
		}
		
		try {
			if (initialContext == null) {
				initialContext = new InitialContext();
			}
			
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			mySqlDs = (DataSource) envContext.lookup("jdbc/sakila");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mySqlDs;
	}
}
