package com.rmgyantra.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.genericutility.BaseApiClass;
import com.rmgyantra.genericutility.EndPoints;
import com.rmgyantra.pojoclass.PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResource extends BaseApiClass {

	@Test
	public void createResource() {
		int ran=jUtil.getRandomNum();
		String expProjectName = "tyss"+ran;
		PojoClass obj=new PojoClass("abc", expProjectName, "completed", 20);
		
		Response response = given()
		   .body(obj)
		   .contentType(ContentType.JSON)
		.when()
		    .post(EndPoints.ADDPROJECT);
		String responseProjectName = response.jsonPath().get("projectName");
		response.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		String DbProjectName = dUtil.getDataAndVerify("select * from project", 4,expProjectName);
		Assert.assertEquals(responseProjectName, DbProjectName);
	}
}
