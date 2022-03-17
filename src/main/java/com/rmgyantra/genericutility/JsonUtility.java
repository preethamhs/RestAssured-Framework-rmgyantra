package com.rmgyantra.genericutility;



import io.restassured.response.Response;

public class JsonUtility {
	
	public Object getResponseData(Response response,String jsonPath) {
		return response.jsonPath().get(jsonPath);
	}

}
