package rahushettyacademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.landingpage;

public class Base_test {
	public WebDriver driver;
	public landingpage lp;

	public WebDriver initialize_driver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String BrowserName =System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("Edge")) {
			// edge browser
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			// firefox browser
		}
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		//new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Data\\purchse.json")
		String JsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		//List<HashMap<String,String>> data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});)
		List<HashMap<String,String>> data =mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}

	@BeforeMethod(alwaysRun=true)
	public landingpage launch() throws IOException {
		driver = initialize_driver();
		lp=new landingpage(driver);// creating objects
		lp.goTo();
		return lp;

	}
	//@AfterMethod(alwaysRun=true)
	public void closedriver() {
		driver.close();
	}

	
	public String getscreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File((System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Screenshots\\"+testcasename+".png"));
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Screenshots\\"+testcasename+".png";
		
	}
}
