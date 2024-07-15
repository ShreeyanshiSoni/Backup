package demo;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_handles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parent= it.next();
		String child= it.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.xpath("//p[contains(@class,'im-para red')]")).getText());
		String email=driver.findElement(By.xpath("//p[contains(@class,'im-para red')]")).getText().split("at ")[1].split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(email);
		
		

	}

}
