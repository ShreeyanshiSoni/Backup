package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractclass.Abstractclass;

public class checkoutpage extends Abstractclass {
		WebDriver driver;

		public checkoutpage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "(//input[contains(@class,'text-validated')])[3]")
		WebElement country;

		@FindBy(xpath = "//button[contains(@class,'list-group')]/span")
		List<WebElement> countrynamelist;
		
		@FindBy(xpath = "//a[contains(@class,'action__submit')]")
		WebElement submit;
		
		By placeorder = By.xpath("//h1[@class='hero-primary']");
		
		public confirmation_page addressdetails(String countryname) {
			country.sendKeys("ind");
			WebElement ans = countrynamelist.stream().filter(s -> s.getText().equals(countryname)).findFirst().orElse(null);
			ans.click();
			submit.click();
			waituntilappear(placeorder);
			confirmation_page cp=new confirmation_page(driver);
			return cp;
		}

}

