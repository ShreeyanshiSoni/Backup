package APIs;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PoJo.Course_json;
import PoJo.Google_Maps_Add;
import PoJo.api;
import PoJo.getCourses;
import PoJo.location;
import PoJo.webAutomation;
import io.restassured.specification.RequestSpecification;
public class Serialization {

	public static void main(String[] args) {
		
		//Creating object for a class having all getter and setter method
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
		
	    RequestSpecification base= new RequestSpecBuilder()
	    		.setContentType("application/json")
	    		.setBaseUri("https://rahulshettyacademy.com")
	    		.addQueryParam("key","qaclick123").build();
	    
	    
	    RequestSpecification add_place=given().spec(base).body(gma);
	    
	    String add_place_response=add_place.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().asString();
	    
	    System.out.println(add_place_response);
	    
	    
		/*  RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		
		String res=given().queryParam("key","qaclick123")
		.body(gma)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();
		
		System.out.println(res);
		
		*/
	}

}
