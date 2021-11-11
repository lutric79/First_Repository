package API;

//import org.testng.annotations.Test;
//
//import groovyjarjarasm.asm.commons.Method;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;
public class HTTPGETWeather {
	
	@Test
	public void GetWeatherDetails() {
		//Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/City";
		
		//Get the RequestSpecification of the request that you want to set
		//to the server. The server is specified by the BaseURI that we have
		//specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		//Make a request to the server by specifying the method Type and the method URL
		//This will return the Response from the server. Store the response in a variable
		Response response = httpRequest.request(Method.GET,"/Gqeberha");
		
		//Now let us print the body of the message to see what response
		//we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is => "+ responseBody);
		
		//Get the status code from the Response.class. In case of
		//a successful interaction with the web service, we
		//should get a status code of 200
		int statusCode = response.getStatusCode();	
		
		//Assert that the correct status code is returned
		Assert.assertEquals(statusCode/*actual value*/,200/*expected value*/, "Correct status code returned");
		}

}
