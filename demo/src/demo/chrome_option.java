package demo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome_option {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		/*set download directory
		
		
		
		Map<String,Object> prefs =new HashMap<String,Object>();
		prefs.put("download.default_directory","C:\\Users\\Shreeyas\\Desktop\\");
		option.setExperimentalOption("prefs", prefs);
		
		
		
		*/
		
		/*
		 for set download directory
		 driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.9.0");
		 driver.findElement(By.xpath("//div[@class='content']/table[@class='grid']/tbody/tr[6]/td/a[2]")).click();
		
		*
		*/
		
		/*blocking pop ups
		
		
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		 */
		
		/*
		 
		  start maimized
		  
		 option.addArguments("start-maximized");
		 
		 
		 
		 */
		
		/*certification issue
		 
		option.setAcceptInsecureCerts(true);
		
		*/
		/*
		add extensions
		
		option.addExtensions(new File("./Extension/SelectorsHub.crx"));
		
		*/
		
		/*block pop ups-faced issue with swiggy website that it was enabling the loaction
		
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		driver.findElement(By.className("LukWG")).click();
		
		
		*/
		//driver.get("https://expired.badssl.com/");
		//driver.get("https://www.swiggy.com/");
		
		
		/*take screen shot from selenium
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.swiggy.com/");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\Shreeyas\\ss.png"));
		
		*/
		
	}

}
