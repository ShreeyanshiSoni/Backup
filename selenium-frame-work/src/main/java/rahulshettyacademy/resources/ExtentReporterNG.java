package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentSparkReporter
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("My Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentReports
		//ExtentReporter report=new ExtentReporter();
		//exreport.attachReporter(reporter);
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "shreeya");
		return report;
	
	}
}
