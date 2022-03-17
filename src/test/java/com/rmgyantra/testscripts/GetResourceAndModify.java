package com.rmgyantra.testscripts;

import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.genericutility.BaseApiClass;
import com.rmgyantra.genericutility.EndPoints;
import com.rmgyantra.pojoclass.PojoClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetResourceAndModify extends BaseApiClass {
	
	@Test
	public void getResourceAndModify() {
		  Response response = when()
			    .get(EndPoints.GETALLPROJECT);
			String ProjectId = response.jsonPath().get("[0].projectId");
			response.then().log();
			
			int ran=jUtil.getRandomNum();
			String expProjectName = "RCB"+ran;
			PojoClass obj=new PojoClass("abc", expProjectName, "On Going", 20);
			
			Response response1 = given()
			   .body(obj)
			   .contentType(ContentType.JSON)
			.when()
			   .put("/projects/"+ProjectId);
			String responseProjectName = response1.jsonPath().get("projectName");
			
			response.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
			String DbProjectName = dUtil.getDataAndVerify("select * from project", 4,expProjectName);
			Assert.assertEquals(responseProjectName, DbProjectName);		 

	}

}
