package demo;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class green_kart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		String[] sbji = { "Carrot", "Cucumber" };
		Thread.sleep(3000);
		validatelist(driver, sbji);
		addtocart(driver, w);
	}

	public static void validatelist(WebDriver driver, String[] sbji) throws InterruptedException {
		List<WebElement> veggie = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int n = 0;
		for (int i = 0; i < veggie.size(); i++) {
			String[] vegname = veggie.get(i).getText().split(" -");
			String name = vegname[0];
			List sbjilist = Arrays.asList(sbji);
			Thread.sleep(200);
			if (sbjilist.contains(name)) {
				n = n + 1;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			if (n == sbji.length) {
				break;
			}

		}
	}



	public static void addtocart(WebDriver driver,WebDriverWait w) {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		//System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(), "Code applied ..!");
		
	
}
}

