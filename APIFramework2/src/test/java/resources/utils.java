package resources;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class utils {
	static RequestSpecification base;
	public io.restassured.specification.RequestSpecification RequestSpecification() throws IOException {
		
		if (base==null) {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		base= new RequestSpecBuilder()
	    		.setContentType("application/json")
	    		.addFilter(RequestLoggingFilter.logRequestTo(log))
	    		.addFilter(ResponseLoggingFilter.logResponseTo(log))
	    		.setBaseUri(baseURL("baseURL"))
	    		.addQueryParam("key","qaclick123").build();
				return base;
		}
		return base;
	}
	public static String baseURL(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\selenium webdriver\\workspace\\APIFramework2\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String JsonPath(Response response,String key) {
		String response_String=response.asString();
		JsonPath js= new JsonPath(response_String);
		return js.getString(key);
	}
}
