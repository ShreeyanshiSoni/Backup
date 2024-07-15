package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.checkoutpage;
import rahulshettyacademy.pageobjects.confirmation_page;
import rahulshettyacademy.pageobjects.landingpage;
import rahulshettyacademy.pageobjects.product_catlogue;
import rahulshettyacademy.pageobjects.validate_product;
import rahushettyacademy.testcomponents.Base_test;
import rahushettyacademy.testcomponents.Retry;

public class ErrorMsg extends Base_test {

	@Test(groups= {"Error_validations"})
	public void Error_msg() throws IOException {
		String name="IPHONE 13 PRO";
		String countryname="India";
		lp.loginapplication("shreeya@gmail.com","Shre9725682947eya@gmail1");
		Assert.assertEquals("Incorrect email or password.", lp.errormessage());
		
		
	}

}
