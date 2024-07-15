package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclass.Abstractclass;

public class confirmation_page extends Abstractclass{
	WebDriver driver;
	public confirmation_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h1[@class='hero-primary']")
	WebElement orderplaced;
	
	public String validate_confirm_msg() {
		String orderplacedtext=orderplaced.getText();
		return orderplacedtext;
	}
}
