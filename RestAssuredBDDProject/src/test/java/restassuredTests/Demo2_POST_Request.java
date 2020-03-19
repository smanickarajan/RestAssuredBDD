package restassuredTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Request {

	public static HashMap map = new HashMap();

	@BeforeClass
	public void postdata() {
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
	}

	@Test
	public void testpost() {
		
		Response response=
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.and()
		.body("SuccessCode",
				equalToIgnoringCase("OPERATION_SUCCESS"))
		.log()
		.all()
		.extract()
		.response();
		
		String JsonAsString=response.asString();
		Assert.assertEquals(JsonAsString.contains("OPERATION_SUCCESS"), true);
	}

}
