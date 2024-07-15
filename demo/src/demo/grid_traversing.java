package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class grid_traversing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		List<WebElement> liist=driver.findElements(By.xpath("//tr//td[1]"));
		List<String> find=liist.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());
		find.stream().forEach(s->System.out.println(s));
		

	}

	private static String getprice(WebElement s) {
		// TODO Auto-generated method stub
		String ans=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return ans;
	}

}
	