package rahushettyacademy.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int counter=0;
		int retryLimit=1;
		if(counter!=retryLimit) {
		if (counter < retryLimit) {
			counter++;
			System.out.println(counter);
			System.out.println(retryLimit);
			return true;
		}
		}
		return false;
	}
		
}