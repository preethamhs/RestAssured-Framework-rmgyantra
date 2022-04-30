package com.rmgyantra.testscripts;

import org.testng.annotations.Test;

import com.rmgyantra.genericutility.EndPoints;

import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
public class MultipleResponse {
	
	@Test
	public void multi() {
		Response respose = when()
		  .get("http://localhost:8084/projects");
		List<String> allprojectId = respose.jsonPath().get("projectId");
		
		List<String> allprojectName = respose.jsonPath().get("projectName");
		
		for(int i=0;i<allprojectId.size();i++) {
			System.out.println(allprojectId.get(i)+"  "+allprojectName.get(i));
		}
		
		//respose.then()
		//.log().all();
		
		/*for (String string : allprojectName) {
			System.out.println(string);
		}*/
      
		//RestAssuredConfig.
	}

}
