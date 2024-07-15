import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//wait until element is found
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList\"]")));
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).click().perform();
		
		//Insert User name and password
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("9399084551");
		
		//wait for next page
		wait.until(ExpectedConditions.urlMatches("https://www.amazon.in/ap/signin"));
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Devansh@13");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		
		
		
		
		
		
		

	}

}
