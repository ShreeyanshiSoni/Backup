package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		//driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("Sept")){
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			Thread.sleep(1000);
			
		}
		
		List<WebElement> dates=driver.findElements(By.className("flatpickr-day"));
		int c=dates.size();
		for(int i=0;i<c;i++) {
			String date=driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if(date.equalsIgnoreCase("2")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
				
			}
		
	}	
}}

