package APIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class Passing_JSON_using_file {

	public static void main(String[] args) throws IOException {
		//sending data through file
		
		RestAssured.baseURI="http://216.10.245.166/";
		given().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\selenium webdriver\\workspace\\Working_Apis\\src\\Files\\payload.json"))))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200);
					
				}
				
			

	}


