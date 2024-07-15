package demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class partial_ss {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			WebDriver driver=new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			driver.switchTo().newWindow(WindowType.TAB);
			Set<String> window=driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			String parent=it.next();
			String child=it.next();
			driver.switchTo().window(child);
			driver.get("https://rahulshettyacademy.com/");
			String course=driver.findElement(By.xpath("//h2/a")).getText();
			System.out.println(course);
			driver.switchTo().window(parent);
			WebElement text=driver.findElement(By.xpath("//form/div[1]/input[1]"));
			text.sendKeys(course);
			File file=text.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("logo.png")); 
		
		}


	}


