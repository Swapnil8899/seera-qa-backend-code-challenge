package stepdefinitionTestClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
public class Step extends Utils{
	
	
	TestDataBuild testData = new TestDataBuild();
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
//*******************   Post scenario 	***********************
	@Given("User search property for {string} {string} by {string} and {string}")
	public void User_search_property_for(String checkIn, String checkOut, String sortBy, String sortOrder) throws IOException {
		res =given().spec(requestSpecification()).header("Accept-Charset","UTF-8")
		.body(testData.property(checkIn, checkOut, sortBy, sortOrder));
		
	}

	@When("User calls {string} post request")
	public void user_calls_post_request(String apiPath) throws IOException {
		response =res.when().post(getGlobalValue(apiPath)).
		then().log().all().extract().response();	
		
	}
//*******************Reusable Get method***********************
	@When("User calls {string} get request and validate {string} schema")
	public void user_calls_get_request(String apiPath,String schemaFileName) throws IOException {
		
		resspec= new ResponseSpecBuilder().expectStatusCode(200).build();
		response = given().spec(requestSpecification()).when().get(getGlobalValue(apiPath)).then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaFileName)).log().all().spec(resspec).extract().response();
				
	}

//*******************Reusable status code validation method***********************
	@Then("API is success with {int} status code")
	public void api_is_success_with_status_code(int statusCodeExpected) {
		assertEquals(response.getStatusCode(),statusCodeExpected);
	}
	

	
	@Then("API is success with {int}")
	public void api_is_success_with_status(int statusCodeExpected) {
		assertEquals(response.getStatusCode(),statusCodeExpected);
	}

//*******************Reusable Response fields validation method***********************
	@And("{string} is {string} in response body")
	public void is_in_response_body(String ResponseKey, String ResponseValue) {
		assertEquals(getJsonPath(response, ResponseKey),ResponseValue);
	}

	

}
