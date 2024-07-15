package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt=driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select drop=new Select(dropdown);
        drop.selectByVisibleText(opt);
        driver.findElement(By.xpath("//input[@class='inputs']")).sendKeys(opt);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String[] aleert=driver.switchTo().alert().getText().split(",")[0].split(" ");
        String ans=aleert[1];
        Assert.assertEquals(ans,opt);
        driver.switchTo().alert().accept();
        
	}

}
