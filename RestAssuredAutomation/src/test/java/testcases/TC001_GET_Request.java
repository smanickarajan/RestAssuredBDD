package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
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
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  
	  long responsetime = response.getTimeIn(TimeUnit.SECONDS);
	  System.out.println("Response time is :" +responsetime);
	//status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  
	  String contentType=response.header("Content-Type");// capture details of Content-Type header
	  System.out.println("Content Type is:"+contentType);
	  
	  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
	  System.out.println("Content Encoding is:"+contentEncoding);
	  
	  System.out.println("-----------------------------------------------------------------------------");
	  
	  Headers allheaders = response.headers();
	  
	  for (Header header:allheaders) {
		  System.out.println(header.getName()+" :"+header.getValue());
	  }
}
}
