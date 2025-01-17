package rahulshettyacademy;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.landingpage;

public class standalonetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/client/");
		String name="IPHONE 13 PRO";
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("shreeya@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shreeya@gmail1");
		driver.findElement(By.id("login")).click();
		//landingpage lp=new landingpage(driver);//creating objects
		
		List<WebElement> items=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		/*for(int i=0;i<items.size();i++) {
			String name=items.get(i).getText();
			System.out.println(name);
			if(name.contains("IPHONE 13 PRO")){
				System.out.println(name+"yufyf");
				driver.findElements(By.cssSelector(".btn.w-10.rounded")).get(i).click();
			}
		}*/
		
		WebElement item=items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		items.stream().forEach(s->System.out.println(s));
		//System.out.println(item);
		item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartitem=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=cartitem.stream().anyMatch(s->s.getText().equals(name));
		
		Assert.assertTrue(match);
		System.out.println("done");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@class,'text-validated')])[3]")).sendKeys("ind");
		List<WebElement> option=driver.findElements(By.xpath("//button[contains(@class,'list-group')]/span"));
		WebElement ans=option.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		ans.click();
		driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
		String coming=driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertEquals(coming,"THANKYOU FOR THE ORDER.");
		//driver.close();
		
	}

}
