package stepDefinations;

import POJO.Google_Maps_Add;
import POJO.location;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.utils;

public class stepDefinations extends utils {

	RequestSpecification req;
	Response response;
	static String place_id;
	String Name_response;
	TestDataBuild data = new TestDataBuild();


	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String Name, String Address, String Language) throws IOException {

		
		req=given().log().all().spec(RequestSpecification()).body(data.add_place_payload(Name, Address, Language));

	}

	@When("when user calls {string} with {string} http Request")
	public void when_user_calls_with_http_request(String resource, String Method) {
		APIResources resource_value = APIResources.valueOf(resource);
		if (Method.equalsIgnoreCase("POST")) 

			response = req.when().post(resource_value.getresource());

		else if (Method.equalsIgnoreCase("GET"))

			response = req.when().get(resource_value.getresource());

		else if (Method.equalsIgnoreCase("DELETE"))

			response = req.when().delete(resource_value.getresource());

	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(int Value) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), Value);

	}

	@Then("{string} in response body is {string}")
	public void status_in_response_body_is_ok(String key, String value) {
		// Write code here that turns the phrase above into concrete action
		assertEquals(JsonPath(response, key), value);

	}

	@Then("Validate {string} after user calls {string} http Request is correct.")
	public void validate_after_user_calls_http_request_is_correct(String Name, String Method) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		place_id = JsonPath(response, "place_id");
		req = given().spec(RequestSpecification()).queryParam("place_id", place_id);
		when_user_calls_with_http_request(Method, "GET");
		Name_response = JsonPath(response, "name");
		assertEquals(Name,Name_response);
		System.out.println(place_id);

	}
	
	@Given("delete Place Payload DeletePlaceAPI")
	public void delete_place_payload_delete_place_api() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req=given().log().all().spec(RequestSpecification()).body(data.deleteAPI_payload(place_id));
	    
	}
}
