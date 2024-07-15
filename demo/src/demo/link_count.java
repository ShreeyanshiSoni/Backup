package demo;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class link_count {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https:qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer=driver.findElement(By.className("footer_top_agile_w3ls"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement footercolumn1=footer.findElement(By.tagName("ul"));
		System.out.println(footercolumn1.findElements(By.tagName("a")).size());
		List<WebElement> liink=footercolumn1.findElements(By.tagName("a"));
		for(int i=1;i<liink.size();i++) {
			String clickon=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footercolumn1.findElements(By.tagName("a")).get(i).sendKeys(clickon);
			Thread.sleep(5000);
		}
		
		ArrayList<String> window=new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> it=window.iterator();
		/*this will slow down performane
		 * for(int j=1;j<window.size();j++) {
			
			String currentTab=it.next();
			
			driver.switchTo().window(currentTab);
			System.out.println(driver.getTitle());
			driver.switchTo().defaultContent();
		}*/
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		

	}

}
