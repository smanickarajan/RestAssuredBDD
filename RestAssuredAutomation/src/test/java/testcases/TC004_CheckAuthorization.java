package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_CheckAuthorization {
	@Test
	public void getWeatherDetails() {
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		 //Response object
		
		Response response=httpRequest.request(Method.GET,"/");
		
		//print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("The Reponse is :"+responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  Assert.assertEquals(statusCode, 200);
	}
}
