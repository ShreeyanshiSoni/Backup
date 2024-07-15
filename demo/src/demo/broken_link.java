package demo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class broken_link {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		option.addExtensions(new File("./Extension/SelectorsHub.crx"));
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		List<WebElement> liinks=driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:liinks) {
			String url=link.getAttribute("Href");
			HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int rescode=con.getResponseCode();
			a.assertTrue(rescode<400,"this is broken link :"+link.getText()+" with code :"+rescode);
			
		}
		a.assertAll();		
	}

}
