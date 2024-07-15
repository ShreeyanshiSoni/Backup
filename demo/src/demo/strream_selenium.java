package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class strream_selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		List<WebElement> liist=driver.findElements(By.xpath("//tr//td[1]"));
		List<String> tocompare=liist.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>correctlist=tocompare.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(tocompare, correctlist);
		

	}

}
