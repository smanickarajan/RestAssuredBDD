package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String getFirstName() {
		String generatedstring=RandomStringUtils.randomAlphabetic(1);
		return ("Jhon"+generatedstring);
	}
	
	public static String getLastName() {
		String generatedstring=RandomStringUtils.randomAlphabetic(1);
		return ("Kennedy"+generatedstring);
	}
	
	public static String getUserName() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return ("Jhon"+generatedstring);
	}
	
	public static String getPassword() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return ("Jhon"+generatedstring);
	}
	
	public static String getEmail() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return (generatedstring+"@gmail.com");
	}
}
