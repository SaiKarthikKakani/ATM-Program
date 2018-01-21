package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import model.Users;

public class RestAssuredTest {

	private static final String headerName = "Content-Type";
	private static final String expectedStatusCode = "200 OK";
	private static final CharSequence expectedHeaderValue = "application/json; charset=utf-8";
	private static final int expectedNumberOfUsers = 10;

	@BeforeTest
	public void initRestService() {
		baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test(description = "Check Response Status")
	public void checkStatusCode() {
		Response rps = given().get("/users").andReturn();
		String statusCode = rps.getStatusLine();
		System.out.println("The Response status code is: " + statusCode);
		Assert.assertTrue(statusCode.contains(expectedStatusCode),
				"Status Code " + statusCode + "doesn't match with" + expectedStatusCode);
	}

	@Test(description = "Check Response Headers have Header-content-type")
	public void checkHeader() {
		Response rps = given().get("/users").andReturn();
		Headers headers = rps.getHeaders();
		Boolean contentType = headers.hasHeaderWithName(headerName);
		Assert.assertTrue(contentType, "The header " + headerName + " is not present in the list of headers");
	}

	@Test(description = "Check Response Headers have Header-content-type with value application/json; charset=utf-8")
	public void checkHeaderValue() {
		Response rps = given().get("/users").andReturn();
		String headerValue = rps.getHeader(headerName);
		Assert.assertTrue(headerValue.contains(expectedHeaderValue), "The header value is not as expected!");
		System.out.println("The value of header " + headerName + "is: " + headerValue);
	}

	@Test(description = "Check Response Body to have a length of 10 users")
	public void checkBodyLength() {
		Response rps = given().get("/users").andReturn();
		Users[] users = rps.as(Users[].class);
		int numberOfUsers = users.length;
		System.out.println("No: of users = " + numberOfUsers);
		Assert.assertEquals(numberOfUsers, expectedNumberOfUsers);
	}

}
