package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import rahulshettyacademy.abstractclass.Abstractclass;


public class product_catlogue  extends Abstractclass{
	WebDriver driver;
	public product_catlogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mb-3')]")));
	
	@FindBy (css=".mb-3")
	List<WebElement> items;
	
	@FindBy (css=".ng-animating")
	WebElement buffer;
	
	@FindBy (xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	By itemsby=By.cssSelector(".mb-3");
	By toaster=By.xpath("//div[@id='toast-container']");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	
	
	
	public List<WebElement> getproductlist() {
		
		waituntilappear(itemsby);
		return items;
	}
	public WebElement nameofproduct (String name) {
		WebElement productname= getproductlist().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		return productname;
	}
	
	public validate_product addtocart(String name) {
		WebElement prod=nameofproduct(name);
		prod.findElement(addtocart).click();
		waituntilappear(toaster);
		waituntildisappear(buffer);
		gotocartpage();
		validate_product vp=new validate_product(driver);
		return vp;
	}
	
	
	
	
	
	
	
	

	
	
	
}
