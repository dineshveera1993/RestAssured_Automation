package Testcase;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; 

public class PostRequest {

	@Test
	public void testPost() {
		
	//	Map<String,Object> map = new  HashMap<String,Object>();
	//	map.put("name", "Dinesh");
	//	map.put("job", "Software professional");
	//	System.out.println(map);
		
		JSONObject request = new JSONObject(); //JsonObject library class used to convert hashMap to Json
		request.put("name","Dinesh");
		request.put("job","Software professional");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		    given().
			header("content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			auth().none().
			body(request.toJSONString());
		when().
			post("/users").
		then().
		//	 statusCode(201).
			 log().all()
			 .extract().response();

	}
	
}
