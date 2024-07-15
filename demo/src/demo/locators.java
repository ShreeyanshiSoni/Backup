package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("shreeya");
		driver.findElement(By.name("inputPassword")).sendKeys("shreeya");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("shreeya");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shreeya@.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']:nth-child(3)")).sendKeys("shreeyanshi@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9516025212");
		//driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password=driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(password);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("shreeya");
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		Thread.sleep(10000,2000);
		//driver.findElement(By.id("chkboxOne")).click();
		//driver.findElement(By.name("chkboxTwo")).click();
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000,2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.className("logout-btn")).click();
	
		
		
		
		
		
		
		

	}

}
