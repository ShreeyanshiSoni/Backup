package APIs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ADD_JSON;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

public class working_with_Library {
		
		
	
	
		//sending data through function
		@Test(dataProvider="data")
		public static void library(String isbn,String aisle) {
			// TODO Auto-generated method stub
			RestAssured.baseURI="http://216.10.245.166/";
			given().queryParam("key","qaclick123").header("Content-Type","application/json")
			.body(ADD_JSON.Add_Book(isbn,aisle))
			.when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200);
			
		}
		
		@DataProvider(name="data")
		public static Object[][] Data_Value() {
			
			return new Object[][] {{"Y","0"},{"O","0"},{"S","4"},{"V","2"}};
			 
		}//

	}

	
