package APIs;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PoJo.Course_json;
import PoJo.api;
import PoJo.getCourses;
import PoJo.webAutomation;
public class Auth_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		//API to get Access token
		String response=given()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath js=new JsonPath(response);
		String access_token=js.get("access_token");
		
		System.out.println(access_token);
		
		//Api to use access token and fetch info
		
		getCourses gc=given().queryParam("access_token",access_token)
		.when().log().all()
		.get("/oauthapi/getCourseDetails").as(getCourses.class);
		//System.out.println(gc.getCourses().getApi().get(0).getCourseTitle());
		
		List<webAutomation> webAutomation=gc.getCourses().getWebAutomation();
		for(int i=0;i<webAutomation.size();i++) {
			System.out.println(webAutomation.get(i).getCourseTitle());
			System.out.println(webAutomation.get(i).getPrice());
		}
		
		
	}
	
	

}
