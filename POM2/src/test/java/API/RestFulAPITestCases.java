package API;

import static io.restassured.RestAssured.given;
import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class RestFulAPITestCases {



	@Test
	public void stastusCode() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200);
	}

	@Test
	public void pathtest() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page",equalTo(2));
	}

	@Test
	public void testDataIDData0() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page",equalTo(2),
				"data[0].id",equalTo(7));
	}

	@Test
	public void testDataFirstNameData5() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page",equalTo(2),
				"data[5].first_name",equalTo("Rachel"));
	}

	@Test
	public void howManyDataElements() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("size()",equalTo(6));
	}

	@Test
	public void size() {
		given().
		when().
		get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200").
		then().
		assertThat().
		body("size()",equalTo(4));
	}

	@Test
	public void queryparma() {
		given().
		queryParam("Limit","100")
		.queryParam("Offset","200")
		.when().get("https://pokeapi.co/api/v2/pokemon")
		.then().log().body();
	}

	@Test
	public void queryparma2() {
		Response response1 = (Response) given().queryParam("Limit","100")
				.queryParam("Offset","200")
				.when().get("https://pokeapi.co/api/v2/pokemon")
				.then()
				.extract().response();

		String username = response1.jsonPath().get("results[1].name");
		given().queryParam("CUSTOMER_ID", username)
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1").
		when().log().all().
		get("https://demo.guru99.com/V4/sinkministatement.php").
		then().log()
		.body();
	}

	@Test
	public void givenExample() {
		given().queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1")
		.when().get("https://demo.guru99.com/V4/sinkministatement.php")
		.then().log().body();
	}

	@Test
	public void getHeaders() {
		System.out.println(given().when().get("https://www.takealot.com/").then().extract().headers());
	}


	private static String requestBody = "{\n" +
			"  \"title\": \"foo\",\n" +
			"  \"body\": \"bar\",\n" +
			"  \"userId\": \"2\" \n}";



	@Test
	public void PostRequest(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		//HTTP POST request is used to post data or create a resource on a server.
		Response response = 
				given()
				.header("Content-type", "application/json")
				.and().body(requestBody)
				.when()
				.post("/posts/")
				.then().

				log().
				all().
				extract().
				response();

		Assert.assertEquals( response.statusCode(),201);
		Assert.assertEquals( response.jsonPath().getString("title"),"foo");
		Assert.assertEquals( response.jsonPath().getString("body"),"bar");
		Assert.assertEquals( response.jsonPath().getString("userId"),"2");
		Assert.assertEquals( response.jsonPath().getString("id"),"101");
	}
	
	@Test
	public void puttRequest(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		//HTTP POST request is used to post data or create a resource on a server.
		Response response = 
				given()
				.header("Content-type", "application/json")
				.and().body(requestBody)
				.when()
				.put("/posts/7")
				.then().

				log().
				all().
				extract().
				response();

		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals( "foo",response.jsonPath().getString("title"));
		Assert.assertEquals( "bar",response.jsonPath().getString("body"));
		Assert.assertEquals( "2",response.jsonPath().getString("userId"));
		Assert.assertEquals( "7",response.jsonPath().getString("id"));
	}
	
	@Test
	public void deleteRequest(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		//HTTP POST request is used to post data or create a resource on a server.
		Response response = 
				given()
				.header("Content-type", "application/json")
				.and().body(requestBody)
				.when()
				.delete("/posts/1")
				.then().

				log().
				all().
				extract().
				response();
}
}
