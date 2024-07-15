package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]/span[@class='checkmark']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement option=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s=new Select(option);
		s.selectByVisibleText("Consultant");
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.urlContains("https://rahulshettyacademy.com/angularpractice/shop"));
		List<WebElement> item=driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
		for(int i=0;i<item.size();i++) {
			item.get(i).click();
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'nav-link btn ')]"))).click();

		
		

	}

}
