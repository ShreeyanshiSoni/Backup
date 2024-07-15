package demo;

import java.util.List;
import java.util.stream.Collectors;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter_validate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> res=driver.findElements(By.xpath("//tbody/tr"));
		int actualsize=res.size();
		List<Object> output=res.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		int outputsize=output.size();
		Assert.assertEquals(actualsize,outputsize);
		
		WebElement locate=driver.findElement(By.id("search-field"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(locate)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).below(locate)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(locate)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(locate)).getText());
		
		
		
	}
	

}
//facing case sensitive issue her