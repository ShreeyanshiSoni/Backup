package API;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import POJO.order_details;
import POJO.orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import POJO.login_json;
import POJO.Token_JSON;
import POJO.add_product_JSON;
import io.restassured.specification.RequestSpecification;

public class login {
	public static void main(String[] args) {
		System.out.println("------------------------------------------Login-----------------------------------------");
		//Creating a Spec builder
		RequestSpecification req=new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://rahulshettyacademy.com").build();
		
		//getting JSON from POJO classes
		login_json ljson=new login_json();
		ljson.setUserEmail("Anuragsoni@gmail.com");
		ljson.setUserPassword("Anurag@21");
		
		
		
		//passing spec builder to given
		RequestSpecification reqlogin=given().spec(req).body(ljson);
		
		
		//deserialization of login response
		Token_JSON log_res=reqlogin.when().post("api/ecom/auth/login").as(Token_JSON.class);
		
		//access all values from login response
		String token=log_res.getToken();
		String user_id=log_res.getUserId();
		
		System.out.print(token);
		
		
		System.out.println("------------------------------------------create product-----------------------------------------");
		
	
		RequestSpecification AddNewProduct=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.build();
		RequestSpecification AddProduct=given().log().all().spec(AddNewProduct)
				.param("productName","heels")
				.param("productAddedBy",user_id)
				.param("productCategory","fashion")
				.param("productSubCategory","footwear")
				.param("productPrice","11500")
				.param("productDescription","Addias Originals")
				.param("productFor","women")
				.multiPart("productImage",new File("C:\\Users\\Shreeyas\\Documents\\ss.png"));//got error here for i small
		
		String product_id=AddProduct.when().post("/api/ecom/product/add-product").then().log().all().extract().response().asString();
		JsonPath js=new JsonPath(product_id);
		String productId=js.get("productId");
		
		System.out.println(productId);
		
		
		System.out.println("------------------------------------------add product to cart-----------------------------------------");
		
		
		RequestSpecification addToCart=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.addHeader("Content-Type","application/json")
				.build();
		
		RequestSpecification addToCart_req=given().log().all().spec(addToCart);
		
		String addToCart_response=addToCart_req.body("{\r\n"
				+ "    \"_id\": \"6687f185ae2afd4c0b18b3e4\",\r\n"
				+ "    \"product\": {\r\n"
				+ "        \"_id\": \"6687f7c0ae2afd4c0b18bc81\",\r\n"
				+ "        \"productName\": \"Heels\",\r\n"
				+ "        \"productCategory\": \"fashion\",\r\n"
				+ "        \"productSubCategory\": \"shirts\",\r\n"
				+ "        \"productPrice\": 11500,\r\n"
				+ "        \"productDescription\": \"Addias Originals\",\r\n"
				+ "        \"productImage\": \"https://rahulshettyacademy.com/api/ecom/uploads/productImage_1720186816627.jpg\",\r\n"
				+ "        \"productRating\": \"0\",\r\n"
				+ "        \"productTotalOrders\": \"0\",\r\n"
				+ "        \"productStatus\": true,\r\n"
				+ "        \"productFor\": \"women\",\r\n"
				+ "        \"productAddedBy\": \"6687f185ae2afd4c0b18b3e4\",\r\n"
				+ "        \"__v\": 0\r\n"
				+ "    }\r\n"
				+ "}").when().post("/api/ecom/user/add-to-cart").then().log().all().extract().response().asString();
		
		
		System.out.println(addToCart_response);
		
	
		System.out.println("------------------------------------------view product-----------------------------------------");
		
		
		RequestSpecification view_product=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)                      //added path param here but got error
				.build();
		
		RequestSpecification view_product_req=given().log().all().spec(view_product).pathParam("id",productId);
		
		String view_product_response=view_product_req.when().get("/api/ecom/product/get-product-detail/{id}").then().extract().asString();
		
		
		System.out.println(view_product_response);

		System.out.println("------------------------------------------Create product-----------------------------------------");
		order_details od=new order_details();
		od.setCountry("India");
		od.setProductOrderedId(productId);
		
		List<order_details> oderdetails_list=new ArrayList();
		oderdetails_list.add(od);
		orders orders=new orders();
		orders.setOrders(oderdetails_list);
		
		
		RequestSpecification order_product=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)  
				.addHeader("Content-Type","application/json")
				.build();
		
		RequestSpecification oder_product_req=given().log().all().spec(order_product).body(orders);
		
		String order_product_response=oder_product_req.when().post("/api/ecom/order/create-order").then().extract().asString();
		
		
		System.out.println(order_product_response);
		
		
		System.out.println("------------------------------------------delete product-----------------------------------------");
		
		RequestSpecification delete_product=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)                      //added path param here but got error
				.build();
		
		RequestSpecification delete_req=given().log().all().spec(delete_product).pathParams("productId",productId);
		
		String delete_response=delete_req.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response().asString();
		
		
		System.out.println(delete_response);
		
		
		
		
		
		
		
		
		
		
	
		
		
	}
}
