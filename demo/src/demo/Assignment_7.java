package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		//driver.manage().window().maximize();
		List<WebElement> c1=driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr/td[1]"));
		List<WebElement> c2=driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr/td[2]"));
		List<WebElement> c3=driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr/td[3]"));
		int c1size=c1.size();
		int c2size=c2.size();
		int c3size=c3.size();
		List<WebElement> column=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		int columnsize=column.size();
		System.out.println("no of rows : "+c1size);
		System.out.println("no of column : "+columnsize);
		List<WebElement> row2=driver.findElements(By.xpath("//table[@id='product']/tbody/tr[3]/td"));
		System.out.println(row2.get(0).getText());
		System.out.println(row2.get(1).getText());
		System.out.println(row2.get(2).getText());
		
		
	}

}
