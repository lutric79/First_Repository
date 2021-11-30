package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AnalyzeCityValue {
	
	@Test
	public void VerifyCityjSonResponse() {
	
	RestAssured.baseURI = "http://demoqa.com/utilities/weather/City";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET,"/Gqeberha");
	JsonPath jsonPathEvaluator = response.jsonPath();
	String city = jsonPathEvaluator.get("City");
	System.out.println("City received from response:" + city);
	
	//Assert that the correct status code is returned
	Assert.assertEquals(city,  "Gqeberha", "Correct city received from the response");

}
}
