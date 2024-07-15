package APIs;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;//for given method
//for equalto method

import Files.ADD_JSON;

public class Add_Location_API {
	
	public static void main(String[] args) {
		// Add place API automation(POST Method)
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(ADD_JSON.SendJSON()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.header("server","Apache/2.4.52 (Ubuntu)") //Important verification check for server
		.extract().response().asString();          //storing response in a string
		
		System.out.println(response);
		
		System.out.println("------------------------------------------------Place ADDED----------------------------------------");
		JsonPath js=new JsonPath(response);        //parsing the string
		String place_id=js.getString("place_id");
		
		System.out.println(place_id);
		
		
		//Update API(PUT Method)
		String Response_put=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response_put);
		System.out.println("------------------------------------------------Place Updated----------------------------------------");

		
		//Validate API (GET Method)
		String new_address="70 Summer walk, USA";
		String Response_3=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().extract().response().asString();
		JsonPath js1=new JsonPath(Response_3);
		String address=js1.getString("address");
		System.out.println(Response_3);
		
		System.out.println("------------------------------------------------Place Update Validated----------------------------------------");

		Assert.assertEquals(new_address,address);
		
		
		//Delete API
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}\r\n"
				+ "")
		.when().get("maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);
		
		System.out.println("------------------------------------------------Place Deleted----------------------------------------");

				
		
				
	}
	
	
	
}
