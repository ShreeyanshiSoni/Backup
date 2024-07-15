package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.abstractclass.Abstractclass;

public class validate_product extends Abstractclass {
	WebDriver driver;

	public validate_product(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartitem;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement checkout;

	

	

	public Boolean validate(String name) {
		
		Boolean match = cartitem.stream().anyMatch(s -> s.getText().equals(name));
		return match;
	}

	public checkoutpage checkout() {
		checkout.click();
		checkoutpage checkoutt=new checkoutpage(driver);
		return checkoutt;
	}
	
}