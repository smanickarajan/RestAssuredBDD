package restassuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.testng.annotations.Test;

public class Demo3_BasicValidation {
	@Test
	public void getWeatherDetails() {
		given().
		when()
		   .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
		   .statusCode(200)
		   .assertThat().body("City", equalToIgnoringCase("Hyderabad"))
			.statusLine("HTTP/1.1 200 OK").log().all();
	}
}
