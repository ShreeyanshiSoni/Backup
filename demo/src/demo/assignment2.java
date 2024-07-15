package demo;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[contains(@class,'form-control ng-pristine')]")).sendKeys("shree");
		//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("shree");
		//driver.findElement(By.className("form-control ng-dirty ng-touched ng-invalid")).sendKeys("shree");
		//driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-invalid.ng-touched']")).sendKeys("shree");
		//driver.findElement(By.cssSelector(".form-control.ng-dirty.ng-touched.ng-invalid")).sendKeys("shree");
		driver.findElement(By.name("name")).sendKeys("shree");
		driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("abcd");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).click();
		WebElement staticdrop=driver.findElement(By.id("exampleFormControlSelect1"));
		//WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select drop=new Select(staticdrop);
		drop.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("09/09/1999");
		driver.findElement(By.cssSelector(".btn-success")).click();


		
		
		
		
		
		

	}

}
