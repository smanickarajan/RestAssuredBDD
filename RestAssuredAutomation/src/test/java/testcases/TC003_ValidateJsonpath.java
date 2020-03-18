package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_ValidateJsonpath {
	@Test
	public void getWeatherDetails() {
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		 //Response object
		
		Response response=httpRequest.request(Method.GET,"Hyderabad");
		
		//print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("The Reponse is :"+responseBody);
		  
		  System.out.println("-------------------------------------------------");
		  JsonPath jsonpath = response.jsonPath();
		  System.out.println(jsonpath.get("City"));
		  //System.out.println(jsonpath.get("WeatherDescription"));
		  
		  
	}
}
