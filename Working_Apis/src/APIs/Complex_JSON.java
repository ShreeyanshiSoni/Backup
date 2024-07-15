package APIs;

import org.testng.Assert;

import Files.ADD_JSON;
import io.restassured.path.json.JsonPath;

public class Complex_JSON {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(ADD_JSON.Send_Complex_JSON());
		String complex_response=js.get("dashboard.website");
		System.out.println(complex_response);
		//1. Print No of courses returned by API
		
		int no_course=js.getInt("courses.size()");
		System.out.println(no_course);
		
		//2.Print Purchase Amount
		//3. Print Title of the first course
		//4. Print All course titles and their respective Prices
		for (int i=0;i<no_course;i++) {
		String Course_title=js.getString("courses["+i+"].title");
		int Course_price=js.get("courses["+i+"].price");
		System.out.print(Course_title+":");
		System.out.println(Course_price);
		}
		//
		
		//5. Print no of copies sold by RPA Course
		for (int j=0;j<no_course;j++) {
			String Course_title=js.getString("courses["+j+"].title");
			if(Course_title.equals("RPA")) {
				int Course_copies=js.getInt("courses["+j+"].copies");
				System.out.print("No. of copies of "+Course_title+":");
				System.out.println(Course_copies);
			}
			
		}
		int sum=0;
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		for (int k=0;k<no_course;k++) {
			int cost=0;
			String Course_title=js.getString("courses["+k+"].title");
			int Course_price=js.getInt("courses["+k+"].price");
			int Course_copies=js.getInt("courses["+k+"].copies");
			cost=Course_price*Course_copies;
			System.out.print("No. of copies of "+Course_title+":");
			System.out.println(cost);
			sum=sum+cost;
			System.out.println("Total cost of courses"+sum);
			}
		Assert.assertEquals(sum,js.getInt("dashboard.purchaseAmount"));
			
		}

	}


