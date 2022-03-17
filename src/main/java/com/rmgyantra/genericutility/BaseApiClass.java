package com.rmgyantra.genericutility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

public class BaseApiClass {
	public DatabaseUtitility dUtil=new DatabaseUtitility();
	public JavaUtility jUtil=new JavaUtility();
    @BeforeSuite
    public void Bs() {
    	dUtil.databaseConnection();
    	System.out.println("Data base connection is successfull");
    	baseURI="http://localhost";
    	port=8084;	
    }
    
    @AfterSuite
    public void as() {
			dUtil.closeDatabase();
		  	System.out.println("Data base connection closed");
    }

}
