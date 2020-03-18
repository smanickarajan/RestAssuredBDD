package datadriventesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_Postnewemployee {
	
	
	@Test(dataProvider="empdata")
	public void postnewemployee(String firstname, String lastname,String username,String password, String email) {
		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", firstname);
		requestParams.put("LastName",lastname);
		requestParams.put("UserName", username);
		requestParams.put("Password", password);
		requestParams.put("Email",email);
		httpRequest.header("Content-Type", "application/json");

		//httpRequest.body(requestParams.toJSONString()); // attach above data to the request
System.out.println("The Request is"+ httpRequest.body(requestParams.toJSONString()));
		// Response object
		Response response = httpRequest.request(Method.POST, "/register");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

	}

	@DataProvider(name="empdata")
	String[][] empdata() {
		String empdata[][] = { { "manick77XYZ", "XYZmanick77", "manick77XYZ", "manick77XYZxyx", "manick33@gmail.com" },
				{ "manick44XYZ", "XYZmanick44", "manick44XYZ", "manick44XYZxyx", "manick44@gmail.com" },
				{ "manick55XYZ", "XYZmanick55", "manick55XYZ", "manick55XYZxyx", "manick55@gmail.com" }
		          };
		return empdata;
	}

}
