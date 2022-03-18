package com.rmgyantra.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtitility {
	Connection conn=null;
	public void databaseConnection() {
		
	     try {
	    	 Driver driver=new Driver();
	 		DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) {
				
		}
	
	}
	
	public void closeDatabase() {
		
      try {
		conn.close();
	} catch (SQLException e) {
		
	}
	}
	
	public void getAlldata(String query)  {
		 try {
		 ResultSet result = conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			
		}
		 
		 
	}
	
	public String getDataAndVerify(String query,int columnIndex,String expData) {
		boolean flag=false;
		ResultSet result=null;
		String actData=null;
		try {
		    result = conn.createStatement().executeQuery(query);
			while (result.next()) {
				if(result.getString(columnIndex).equals(expData)) {
					flag=true;
					actData=result.getString(columnIndex);
					break;
					
				}
				
			}
		} catch (SQLException e) {
		
		}
		if(flag) {
			System.out.println("Project name is present");
		}
		else {
			System.out.println("Project name is not present");
		}
		return actData;
	}

}
