package API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPGETFirstTwo {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1/Books";
	}
	
	@Test
	public void getFirst2() {
		
		//The HTTP GET request is used to fetch a resource from a server
		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.get("/posts")
				.then()
				.extract().response();
		
		Assert.assertEquals(response.statusCode(),200);
		//String Books = response.jsonPath().getString("..book[:2]");
		String Books = response.jsonPath().getString(".books[0]");
		System.out.println(Books);
	}
	
	@Test
	public void pathtest() {
		given().
		when().
		get("https://bookstore.toolsqa.com/BookStore/v1/Books").
		then().
		assertThat().
		body("books[0].title",equalTo("Git Pocket Guide"));
	}
	
	

}
