package rahulshettyacademy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.checkoutpage;
import rahulshettyacademy.pageobjects.confirmation_page;
import rahulshettyacademy.pageobjects.landingpage;
import rahulshettyacademy.pageobjects.orderpage;
import rahulshettyacademy.pageobjects.product_catlogue;
import rahulshettyacademy.pageobjects.validate_product;
import rahushettyacademy.testcomponents.Base_test;

public class End_to_End extends Base_test {
	String name="IPHONE 13 PRO";
	String countryname="India";
	product_catlogue pc;

	@Test(dataProvider="get_data",groups= {"purchase"})
	public void standalonetest_copy(HashMap<String,String> input) throws IOException {
		
		//landing to url
		//landingpage lp=launch();
		pc=lp.loginapplication(input.get("email"),input.get("password"));
		//getting product list
		List<WebElement> productnames=pc.getproductlist();
		validate_product vp=pc.addtocart(input.get("productname"));
		//validate_product vp=new validate_product(driver);
		vp.validate(input.get("productname"));
		//checkout page
		checkoutpage checkoutt=vp.checkout();
		//confirmation page
		confirmation_page cp=checkoutt.addressdetails(countryname);
		String orderplacedtext=cp.validate_confirm_msg();
		Assert.assertEquals(orderplacedtext,"THANKYOU FOR THE ORDER.");
		System.out.println("completed successfully");
	}
	
	
	@Test(dependsOnMethods= {"standalonetest_copy"})
	public void order_history(){
		lp.loginapplication("shreeya@gmail.com","Shreeya@gmail1");
		lp.gotoorders();
		orderpage op=pc.gotoorders();
		Assert.assertTrue(op.validate_order_name(name));
		
	}
	/*Basic code for data provider
	@DataProvider
	public Object[][] get_data() {
		return new Object [][] {{"shreeya@gmail.com","Shreeya@gmail1","IPHONE 13 PRO"},{"Anurag@gmail.com","Anurag@21","ADIDAS ORIGINAL"}};
		
	}
	 */
	//using hashmap
	@DataProvider
	public Object[][] get_data() throws IOException {
		/*HashMap<String,String> set1=new HashMap<String,String>();
		set1.put("email","shreeya@gmail.com");
		set1.put("password","Shreeya@gmail1");
		set1.put("productname","IPHONE 13 PRO");
		
		HashMap<String,String> set2=new HashMap<String,String>();
		set2.put("email","Anurag@gmail.com");
		set2.put("password","Anurag@21");
		set2.put("productname","ADIDAS ORIGINAL");
		*/
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Data\\purchse.json");
		return new Object [][] {{data.get(0)},{data.get(0)}};
		
	}






}
