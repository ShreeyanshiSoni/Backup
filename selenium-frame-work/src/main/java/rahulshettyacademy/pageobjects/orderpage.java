package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclass.Abstractclass;

public class orderpage extends Abstractclass{
	WebDriver driver;
	public orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//td[2]")
	List<WebElement> orderitem;
	
	
public Boolean validate_order_name(String name) {
		
		Boolean match = orderitem.stream().anyMatch(s -> s.getText().equals(name));
		return match;
	}
}
