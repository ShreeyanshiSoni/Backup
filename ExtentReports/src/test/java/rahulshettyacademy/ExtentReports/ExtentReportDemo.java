package rahulshettyacademy.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportDemo {
	ExtentReports report;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentSparkReporter
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("My Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentReports
		//ExtentReporter report=new ExtentReporter();
		//exreport.attachReporter(reporter);
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "shreeya");
		
	}
	
	
	@Test
	public void initialdemo() {
		ExtentTest test=report.createTest("initail demo");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		//driver.close();
		test.fail("man ni mera pass krne ka");
		System.out.println(driver.getTitle());
		report.flush();
		
		
		
		
	}

}
