package rahulshettyacademy.abstractclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import rahulshettyacademy.pageobjects.orderpage;

public class Abstractclass {
	WebDriver driver;

	public Abstractclass(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	@FindBy(xpath = "(//li/button[contains(@class,'btn-custom')])[2]")
	WebElement orderbutton;

	public void gotocartpage() {
		cartbutton.click();
	}

	public void waituntilappear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waituntilappearWebElement(WebElement findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waituntildisappear(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(element));
	}
	public orderpage gotoorders() {
		orderbutton.click();
		orderpage op=new orderpage(driver);
		return op;
	}

}
