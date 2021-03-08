package Testcase;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class GetRequest {
	
	@Test
	public void test1() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		int statuse_Code = response.statusCode();
		long resp_time = response.getTime();
		
		System.out.println("Status code:" +statuse_Code);
		System.out.println("Response time:" +resp_time);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-Type"));
		
		//Assertion
		
		AssertJUnit.assertEquals(statuse_Code, 200);
	}
	
	@Test
	public void test2() {
		
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",equalTo("George"))
		.log().all();
	
		
		
	}
}
