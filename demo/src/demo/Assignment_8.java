package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ma");
		Thread.sleep(3000);
		List<WebElement> suggestion = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		
		  
		
		/*for (WebElement item : suggestion) { // System.out.println(item.getText());
		  if(item.getText().contains("Malaysia")) { item.click(); }
		 
		for (WebElement item : suggestion) {
			for (int i = 0; i < suggestion.size(); i++) {
				item.sendKeys(Keys.DOWN);
				*/

			}
		}
	

