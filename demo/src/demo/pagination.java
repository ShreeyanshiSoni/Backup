package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> res;
		do {
			int count=0;
			List<WebElement> liist=driver.findElements(By.xpath("//tr//td[1]"));
			res=liist.stream().filter(s->s.getText().contains("Apple")).map(s->getprice(s)).collect(Collectors.toList());
			count=count+1;
			res.forEach(s->System.out.println(s));
			if(res.size()<1) {
				driver.findElement(By.xpath("//li[7]/a[@role='button']")).click();
			}
		}
	while(res.size()<1);
		
			}

	private static String getprice(WebElement s) {
		// TODO Auto-generated method stub
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
