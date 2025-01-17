package APIs;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
public class jira_create_issue {

	public static void main(String[] args) {
		RestAssured.baseURI="https://shreeyanshisoni2000.atlassian.net";
		
		//Creating jira issue
		String response=given().header("Content-Type","application/json")
		.header("Authorization","Basic c2hyZWV5YW5zaGkuc29uaTIwMDBAZ21haWwuY29tOkFUQVRUM3hGZkdGMGdYVXV1MjlHbVI3M1FlNmQwdk1OMUZ6RjRPU3UycXdIbmVreDlKSjk1S0F5MkthVWNEMngtRTJMcm5TU1JUZ0wtSjFqSUpiR0J2Z0ZYWHNJTVItQm1DQmdQdzYyaGZIMWREbFZSTUtLYW1EMHdDeXVYWEIzWURoOWs0TGhFempxczRQWVdFUy1zd3pQZ01wWW5QQWJnUnVZMHdKS1JIZnB2R2NlRm5xSTZwYz1BMzdENjhGQg==")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Automation\",\r\n"
				+ "       \"description\": [\"HIIIIIIIIIIIIIIIII\",\"New defect\"],\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("/rest/api/3/issue")
		.then().log().all().assertThat().statusCode(201).extract().asString();
		
		
		JsonPath js=new JsonPath(response);
		String issue_id=js.getString("id");
		
		System.out.println(issue_id);
		//adding attachment
		given().header("Content-Type","multipart/form-data; boundary=<calculated when request is sent>").pathParam("key", issue_id)
		.header("Authorization","Basic c2hyZWV5YW5zaGkuc29uaTIwMDBAZ21haWwuY29tOkFUQVRUM3hGZkdGMGdYVXV1MjlHbVI3M1FlNmQwdk1OMUZ6RjRPU3UycXdIbmVreDlKSjk1S0F5MkthVWNEMngtRTJMcm5TU1JUZ0wtSjFqSUpiR0J2Z0ZYWHNJTVItQm1DQmdQdzYyaGZIMWREbFZSTUtLYW1EMHdDeXVYWEIzWURoOWs0TGhFempxczRQWVdFUy1zd3pQZ01wWW5QQWJnUnVZMHdKS1JIZnB2R2NlRm5xSTZwYz1BMzdENjhGQg==")
		.header("X-Atlassian-Token","no-check")
		.multiPart("file",new File("C:\\Users\\defect.png")).log().all().post("/rest/api/3/issue/{key}/attachments").then()
		.assertThat().statusCode(200);
	
		//
		
		

	}

}
