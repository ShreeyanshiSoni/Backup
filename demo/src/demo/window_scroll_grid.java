package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class window_scroll_grid {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.manage().window().maximize();
		
		//find and validate sum of 2nd table
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		List<WebElement> column2=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum2=0;
		
		for(int i=0;i<column2.size();i++) {
			sum2=sum2 + Integer.parseInt(column2.get(i).getText());
		}
		int total2=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum2, total2);
		
		
		//find and validate sum of 1st table
		List<WebElement> column1=driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr/td[3]"));
		int sum1=0;
		
		for(int i=0;i<column1.size();i++) {
			sum1=sum1 + Integer.parseInt(column1.get(i).getText());
		}
		System.out.println(sum1);
		
		
	}

}
