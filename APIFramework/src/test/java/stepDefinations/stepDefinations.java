package stepDefinations;
import POJO.Google_Maps_Add;
import POJO.location;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class stepDefinations {
	RequestSpecification add_place;
	RequestSpecification base;
	String add_place_response;
	
	@Given("Add Place Payload")
	public void add_place_payload() {
	    
        Google_Maps_Add gma=new Google_Maps_Add();
		
		//setting value to all variable using that object
		gma.setAccuracy(50);
		gma.setName("Frontline house");
		gma.setPhone_number("(+91)9838933937");
		gma.setAddress("29, side layout, cohen 09");
		gma.setWebsite("http://google.com");
		gma.setLanguage("French-IN");
		
		//setting value to a list type variable
		List<String> l=new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		gma.setTypes(l);
		
		//setting values to variable having sub JSON
		location lo=new location();
		lo.setLat("67");
		lo.setLng("88");
		gma.setLocation(lo);
		
	    base= new RequestSpecBuilder()
	    		.setContentType("application/json")
	    		.setBaseUri("https://rahulshettyacademy.com")
	    		.addQueryParam("key","qaclick123").build();
	    
	    
	    add_place=given().spec(base).body(gma);
	   
	   
	   
	    
	}
	@When("when user calls AddPlaceAPI with Post http Request")
	public void when_user_calls_add_place_api_with_post_http_request(RequestSpecification add_place) {
		 add_place_response=add_place.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().asString();
	   
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Response add_place_response) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(add_place_response.getStatusCode(),200);
	   
	}
	@Then("{string} in response body is {string}")
	public void status_in_response_body_is_ok(String key,String value) {
	    // Write code here that turns the phrase above into concrete actions
		
		JsonPath js=new JsonPath(add_place_response);
		assertEquals(js.get(key),value);
	   
	}




}
