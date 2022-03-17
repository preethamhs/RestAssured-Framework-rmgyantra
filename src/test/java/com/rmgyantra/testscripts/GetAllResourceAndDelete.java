package com.rmgyantra.testscripts;

import org.testng.annotations.Test;

import com.rmgyantra.genericutility.BaseApiClass;
import com.rmgyantra.genericutility.EndPoints;
import com.rmgyantra.pojoclass.PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllResourceAndDelete extends BaseApiClass {
	
	@Test
	public void getAllResourceAndDelete() {
				
		Response response = when()
		    .get(EndPoints.GETALLPROJECT);
		String ProjectId = response.jsonPath().get("[0].projectId");
		response.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		when()
		.delete("/projects/"+ProjectId)
	   .then()
	   .assertThat()
	   .statusCode(204)
	   .contentType(ContentType.JSON);
	}

}
