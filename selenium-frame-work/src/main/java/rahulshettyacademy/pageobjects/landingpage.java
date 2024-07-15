package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclass.Abstractclass;


public class landingpage extends Abstractclass {
	WebDriver driver;
	public landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpass;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public String errormessage() {
		waituntilappearWebElement(errormsg);
		return errormsg.getText();
		
	}
	public product_catlogue loginapplication(String email,String pass) {
		userEmail.sendKeys(email);
		userpass.sendKeys(pass);
		login.click();
		product_catlogue pc=new product_catlogue(driver);
		return pc;
		
	}
}
